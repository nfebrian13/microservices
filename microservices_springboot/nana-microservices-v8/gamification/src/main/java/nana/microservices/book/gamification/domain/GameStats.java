package nana.microservices.book.gamification.domain;

import java.util.Collections;
import java.util.List;

public class GameStats {

	private Long userId;
	private int score;
	private List<Badge> badges;

	public GameStats() {
		super();
	}

	public GameStats(Long userId, int score, List<Badge> badges) {
		super();
		this.userId = userId;
		this.score = score;
		this.badges = badges;
	}

	/**
	 * Factory method to build an empty instance (zero points and no badges)
	 * 
	 * @param userId the user's id
	 * @return a {@link GameStats} object with zero score and no badges
	 */
	public static GameStats emptyStats(Long userId) {
		return new GameStats(userId, 0, Collections.emptyList());
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public List<Badge> getBadges() {
		return badges;
	}

	public void setBadges(List<Badge> badges) {
		this.badges = badges;
	}

}
