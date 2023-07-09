package nana.microservices.multiplication.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class ChallengeAttemptDTO {

	@Min(1)
	@Max(99)
	int factorA, factorB;
	@NotBlank
	String userAlias;
	@Positive(message = "How could you possibly get a negative result here? Try again.")
	int guess;

	public ChallengeAttemptDTO() {
		super();
	}

	public ChallengeAttemptDTO(@Min(1) @Max(99) int factorA, @Min(1) @Max(99) int factorB, @NotBlank String userAlias,
			@Positive(message = "How could you possibly get a negative result here? Try again.") int guess) {
		super();
		this.factorA = factorA;
		this.factorB = factorB;
		this.userAlias = userAlias;
		this.guess = guess;
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

	public String getUserAlias() {
		return userAlias;
	}

	public void setUserAlias(String userAlias) {
		this.userAlias = userAlias;
	}

	public int getGuess() {
		return guess;
	}

	public void setGuess(int guess) {
		this.guess = guess;
	}

	@Override
	public String toString() {
		return "ChallengeAttemptDTO [factorA=" + factorA + ", factorB=" + factorB + ", userAlias=" + userAlias
				+ ", guess=" + guess + "]";
	}

}
