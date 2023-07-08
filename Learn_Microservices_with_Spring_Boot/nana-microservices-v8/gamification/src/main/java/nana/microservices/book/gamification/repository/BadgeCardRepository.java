package nana.microservices.book.gamification.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nana.microservices.book.gamification.domain.BadgeCard;

import java.util.List;

/**
 * Handles data operations with BadgeCards
 */
@Repository
public interface BadgeCardRepository extends CrudRepository<BadgeCard, Long> {

	/**
	 * Retrieves all BadgeCards for a given user.
	 * 
	 * @param userId the id of the user to look for BadgeCards
	 * @return the list of BadgeCards, sorted by most recent.
	 */
	List<BadgeCard> findByUserIdOrderByBadgeTimestampDesc(Long userId);

}
