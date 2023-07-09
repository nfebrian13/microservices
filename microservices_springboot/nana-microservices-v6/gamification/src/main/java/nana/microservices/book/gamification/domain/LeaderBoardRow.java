package nana.microservices.book.gamification.domain;

public class LeaderBoardRow {

	private Long userId;
	private Long totalScore;

	public LeaderBoardRow() {
		super();
	}

	public LeaderBoardRow(Long userId, Long totalScore) {
		super();
		this.userId = userId;
		this.totalScore = totalScore;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Long totalScore) {
		this.totalScore = totalScore;
	}

}
