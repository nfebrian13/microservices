package nana.microservices.multiplication.domain;

public class ChallengeAttempt {

	private Long id;
	private User user;
	private int factorA;
	private int factorB;
	private int resultAttempt;
	private boolean correct;

	public ChallengeAttempt() {
		super();
	}

	public ChallengeAttempt(Long id, User user, int factorA, int factorB, int resultAttempt, boolean correct) {
		super();
		this.id = id;
		this.user = user;
		this.factorA = factorA;
		this.factorB = factorB;
		this.resultAttempt = resultAttempt;
		this.correct = correct;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getFactorA() {
		return factorA;
	}

	public void setFactorA(int factorA) {
		this.factorA = factorA;
	}

	public int getFactorB() {
		return factorB;
	}

	public void setFactorB(int factorB) {
		this.factorB = factorB;
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

	@Override
	public String toString() {
		return "ChallengeAttempt [id=" + id + ", user=" + user + ", factorA=" + factorA + ", factorB=" + factorB
				+ ", resultAttempt=" + resultAttempt + ", correct=" + correct + "]";
	}

}
