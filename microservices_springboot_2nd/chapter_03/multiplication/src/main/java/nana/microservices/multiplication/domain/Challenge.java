package nana.microservices.multiplication.domain;

public class Challenge {

	private int factorA;
	private int factorB;

	public Challenge() {
		super();
	}

	public Challenge(int factorA, int factorB) {
		super();
		this.factorA = factorA;
		this.factorB = factorB;
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

	@Override
	public String toString() {
		return "Challenge [factorA=" + factorA + ", factorB=" + factorB + "]";
	}

}
