package nana.microservices.book.gamification.client.dto;

public class MultiplicationResultAttempt {

	private String userAlias;
	private int multiplicationFactorA;
	private int multiplicationFactorB;
	private int resultAttempt;
	private boolean correct;

	public MultiplicationResultAttempt() {
		super();
	}

	public MultiplicationResultAttempt(String userAlias, int multiplicationFactorA, int multiplicationFactorB,
			int resultAttempt, boolean correct) {
		super();
		this.userAlias = userAlias;
		this.multiplicationFactorA = multiplicationFactorA;
		this.multiplicationFactorB = multiplicationFactorB;
		this.resultAttempt = resultAttempt;
		this.correct = correct;
	}

	public String getUserAlias() {
		return userAlias;
	}

	public void setUserAlias(String userAlias) {
		this.userAlias = userAlias;
	}

	public int getMultiplicationFactorA() {
		return multiplicationFactorA;
	}

	public void setMultiplicationFactorA(int multiplicationFactorA) {
		this.multiplicationFactorA = multiplicationFactorA;
	}

	public int getMultiplicationFactorB() {
		return multiplicationFactorB;
	}

	public void setMultiplicationFactorB(int multiplicationFactorB) {
		this.multiplicationFactorB = multiplicationFactorB;
	}

	public int getResultAttempt() {
		return resultAttempt;
	}

	public void setResultAttempt(int resultAttempt) {
		this.resultAttempt = resultAttempt;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

}
