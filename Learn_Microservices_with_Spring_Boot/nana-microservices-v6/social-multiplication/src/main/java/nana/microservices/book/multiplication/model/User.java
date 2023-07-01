package nana.microservices.book.multiplication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public final class User {

	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private Long id;

	@Column(name = "ALIAS")
	private String alias;

	public User() {
		super();
	}

	public User(String alias) {
		super();
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

	@Override
	public String toString() {
		return "User [id=" + id + ", alias=" + alias + "]";
	}

}