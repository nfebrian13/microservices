package nana.microservices.book.multiplication.service;

import java.util.List;

import nana.microservices.book.multiplication.model.Multiplication;
import nana.microservices.book.multiplication.model.MultiplicationResultAttempt;

public interface MultiplicationService {

	/**
	 * Creates a Multiplication object with two randomly-generated factors between
	 * 11 and 99.
	 *
	 * @return a Multiplication object with random factors
	 */
	Multiplication createRandomMultiplication();

	/**
	 * @return true if the attempt matches the result of the multiplication, false
	 *         otherwise.
	 */
	boolean checkAttempt(final MultiplicationResultAttempt resultAttempt);

	/**
	 * Gets the statistics for a given user.
	 *
	 * @param userAlias the user's alias
	 * @return a list of {@link MultiplicationResultAttempt} objects, being the past
	 *         attempts of the user.
	 */
	List<MultiplicationResultAttempt> getStatsForUser(final String userAlias);

	/**
	 * Gets an attempt by its id
	 *
	 * @param resultId the identifier of the attempt
	 * @return the {@link MultiplicationResultAttempt} object matching the id,
	 *         otherwise null.
	 */
	MultiplicationResultAttempt getResultById(final Long resultId);

}
