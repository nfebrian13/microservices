package nana.microservices.book.gamification.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nana.microservices.book.gamification.client.MultiplicationResultAttemptClient;
import nana.microservices.book.gamification.client.dto.MultiplicationResultAttempt;
import nana.microservices.book.gamification.domain.Badge;
import nana.microservices.book.gamification.domain.BadgeCard;
import nana.microservices.book.gamification.domain.GameStats;
import nana.microservices.book.gamification.domain.ScoreCard;
import nana.microservices.book.gamification.repository.BadgeCardRepository;
import nana.microservices.book.gamification.repository.ScoreCardRepository;

import javax.transaction.Transactional;

@Service
class GameServiceImpl implements GameService {

	private static final Logger LOGGER = LoggerFactory.getLogger(GameServiceImpl.class);

	public static final int LUCKY_NUMBER = 42;

	@Autowired
	private ScoreCardRepository scoreCardRepository;

	@Autowired
	private BadgeCardRepository badgeCardRepository;

	@Autowired
	private MultiplicationResultAttemptClient attemptClient;

	@Transactional
	@Override

	public GameStats newAttemptForUser(Long userId, Long attemptId, boolean correct) {
		// For the first version we'll give points only if it's correct
		if (correct) {
			ScoreCard scoreCard = new ScoreCard(userId, attemptId);
			scoreCardRepository.save(scoreCard);
			
			LOGGER.info("User with id {} scored {} points for attempt id {} " + userId + scoreCard.getScore() + attemptId);
			
			List<BadgeCard> badgeCards = processForBadges(userId, attemptId);
			
			return new GameStats(userId, scoreCard.getScore(),
					badgeCards.stream().map(BadgeCard::getBadge).collect(Collectors.toList()));
		}
		return GameStats.emptyStats(userId);
	}

	/**
	 * Checks the total score and the different score cards obtained to give new
	 * badges in case their conditions are met.
	 */
	private List<BadgeCard> processForBadges(Long userId, Long attemptId) {
		List<BadgeCard> badgeCards = new ArrayList<>();

		int totalScore = scoreCardRepository.getTotalScoreForUser(userId);
		LOGGER.info("New score for user {} is {}" + userId + totalScore);

		List<ScoreCard> scoreCardList = scoreCardRepository.findByUserIdOrderByScoreTimestampDesc(userId);
		List<BadgeCard> badgeCardList = badgeCardRepository.findByUserIdOrderByBadgeTimestampDesc(userId);

		// Badges depending on score
		checkAndGiveBadgeBasedOnScore(badgeCardList, Badge.BRONZE_MULTIPLICATOR, totalScore, 100, userId)
				.ifPresent(badgeCards::add);
		checkAndGiveBadgeBasedOnScore(badgeCardList, Badge.SILVER_MULTIPLICATOR, totalScore, 500, userId)
				.ifPresent(badgeCards::add);
		checkAndGiveBadgeBasedOnScore(badgeCardList, Badge.GOLD_MULTIPLICATOR, totalScore, 999, userId)
				.ifPresent(badgeCards::add);

		// First won badge
		if (scoreCardList.size() == 1 && !containsBadge(badgeCardList, Badge.FIRST_WON)) {
			BadgeCard firstWonBadge = giveBadgeToUser(Badge.FIRST_WON, userId);
			badgeCards.add(firstWonBadge);
		}

		// Lucky number badge
		MultiplicationResultAttempt attempt = attemptClient.retrieveMultiplicationResultAttemptbyId(attemptId);
		
		if (!containsBadge(badgeCardList, Badge.LUCKY_NUMBER) 
			&& (LUCKY_NUMBER == attempt.getMultiplicationFactorA()
			 || LUCKY_NUMBER == attempt.getMultiplicationFactorB())) {
			
			BadgeCard luckyNumberBadge = giveBadgeToUser(Badge.LUCKY_NUMBER, userId);
			badgeCards.add(luckyNumberBadge);
		}

		return badgeCards;
	}

	@Override
	public GameStats retrieveStatsForUser(Long userId) {
		int score = scoreCardRepository.getTotalScoreForUser(userId);
		List<BadgeCard> badgeCards = badgeCardRepository.findByUserIdOrderByBadgeTimestampDesc(userId);
		return new GameStats(userId, score, badgeCards.stream().map(BadgeCard::getBadge).collect(Collectors.toList()));
	}

	/**
	 * Convenience method to check the current score against the different
	 * thresholds to gain badges. It also assigns badge to user if the conditions
	 * are met.
	 */
	private Optional<BadgeCard> checkAndGiveBadgeBasedOnScore(List<BadgeCard> badgeCards, Badge badge, int score,
			int scoreThreshold, Long userId) {
		if (score >= scoreThreshold && !containsBadge(badgeCards, badge)) {
			return Optional.of(giveBadgeToUser(badge, userId));
		}
		return Optional.empty();
	}

	/**
	 * Checks if the passed list of badges includes the one being checked
	 */
	private boolean containsBadge(List<BadgeCard> badgeCards, Badge badge) {
		return badgeCards.stream().anyMatch(b -> b.getBadge().equals(badge));
	}

	/**
	 * Assigns a new badge to the given user
	 */
	private BadgeCard giveBadgeToUser(Badge badge, Long userId) {
		
		BadgeCard badgeCard = new BadgeCard(userId, badge);
		badgeCardRepository.save(badgeCard);
		
		LOGGER.info("User with id {} won a new badge: {}" + userId + badge);
		return badgeCard;
	}
}
