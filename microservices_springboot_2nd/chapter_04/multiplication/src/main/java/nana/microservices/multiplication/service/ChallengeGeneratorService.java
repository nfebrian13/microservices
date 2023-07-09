package nana.microservices.multiplication.service;

import nana.microservices.multiplication.domain.Challenge;

public interface ChallengeGeneratorService {

	/**
	 * @return a randomly-generated challenge with factors between 11 and 99
	 */
	Challenge randomChallenge();

}