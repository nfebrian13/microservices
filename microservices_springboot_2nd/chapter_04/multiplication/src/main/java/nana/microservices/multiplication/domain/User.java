package nana.microservices.multiplication.domain;

public class User {

	private Long id;
	private String alias;

	public User() {
		super();
	}

	public User(Long id, String alias) {
		super();
		this.id = id;
		this.alias = alias;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", alias=" + alias + "]";
	}

}
