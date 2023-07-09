package nana.microservices.book.gamification.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ScoreCard {

	// The default score assigned to this card, if not specified.
	public static final int DEFAULT_SCORE = 10;

	@Id
	@GeneratedValue
	@Column(name = "CARD_ID")
	private Long cardId;

	@Column(name = "USER_ID")
	private Long userId;

	@Column(name = "ATTEMPT_ID")
	private Long attemptId;

	@Column(name = "SCORE_TS")
	private long scoreTimestamp;

	@Column(name = "SCORE")
	private int score;

	public ScoreCard() {
		super();
	}

	public ScoreCard(Long userId, Long attemptId) {
		super();
		this.userId = userId;
		this.attemptId = attemptId;
		this.scoreTimestamp = System.currentTimeMillis();
		this.score = DEFAULT_SCORE;
	}

	public ScoreCard(Long cardId, Long userId, Long attemptId, long scoreTimestamp, int score) {
		super();
		this.cardId = cardId;
		this.userId = userId;
		this.attemptId = attemptId;
		this.scoreTimestamp = scoreTimestamp;
		this.score = score;
	}

	public Long getCardId() {
		return cardId;
	}

	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getAttemptId() {
		return attemptId;
	}

	public void setAttemptId(Long attemptId) {
		this.attemptId = attemptId;
	}

	public long getScoreTimestamp() {
		return scoreTimestamp;
	}

	public void setScoreTimestamp(long scoreTimestamp) {
		this.scoreTimestamp = scoreTimestamp;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
