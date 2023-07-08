package nana.microservices.book.multiplication.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MultiplicationResultAttempt {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "USER_ID")
	private User user;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "MULTIPLICATION_ID")
	private Multiplication multiplication;

	@Column(name = "RESULT_ATTEMPT")
	private int resultAttempt;

	@Column(name = "CORRECT")
	private boolean correct;

	public MultiplicationResultAttempt() {
		super();
	}

	public MultiplicationResultAttempt(User user, Multiplication multiplication, int resultAttempt, boolean correct) {
		super();
		this.user = user;
		this.multiplication = multiplication;
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

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	@Override
	public String toString() {
		return "MultiplicationResultAttempt [user=" + user + ", multiplication=" + multiplication + ", resultAttempt="
				+ resultAttempt + ", correct=" + correct + "]";
	}

}
