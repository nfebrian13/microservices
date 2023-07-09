package nana.microservices.book.multiplication.model;

public class MultiplicationResultAttempt {

	private User user;
	private Multiplication multiplication;
	private int resultAttempt;

	public MultiplicationResultAttempt() {
		super();
	}

	public MultiplicationResultAttempt(User user, Multiplication multiplication, int resultAttempt) {
		super();
		this.user = user;
		this.multiplication = multiplication;
		this.resultAttempt = resultAttempt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Multiplication getMultiplication() {
		return multiplication;
	}

	public void setMultiplication(Multiplication multiplication) {
		this.multiplication = multiplication;
	}

	public int getResultAttempt() {
		return resultAttempt;
	}

	public void setResultAttempt(int resultAttempt) {
		this.resultAttempt = resultAttempt;
	}

	@Override
	public String toString() {
		return "MultiplicationResultAttempt [user=" + user + ", multiplication=" + multiplication + ", resultAttempt="
				+ resultAttempt + "]";
	}

}
