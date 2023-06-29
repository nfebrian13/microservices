package nana.microservices.book.multiplication.event;

import java.io.Serializable;

public class MultiplicationSolvedEvent implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long multiplicationResultAttemptId;
	private Long userId;
	private boolean correct;

	public MultiplicationSolvedEvent() {
		super();
	}

	public MultiplicationSolvedEvent(Long multiplicationResultAttemptId, Long userId, boolean correct) {
		super();
		this.multiplicationResultAttemptId = multiplicationResultAttemptId;
		this.userId = userId;
		this.correct = correct;
	}

	public Long getMultiplicationResultAttemptId() {
		return multiplicationResultAttemptId;
	}

	public void setMultiplicationResultAttemptId(Long multiplicationResultAttemptId) {
		this.multiplicationResultAttemptId = multiplicationResultAttemptId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

}
