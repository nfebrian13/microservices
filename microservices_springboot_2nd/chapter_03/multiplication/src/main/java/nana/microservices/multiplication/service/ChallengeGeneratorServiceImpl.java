package nana.microservices.multiplication.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import nana.microservices.multiplication.domain.Challenge;

@Service
public class ChallengeGeneratorServiceImpl implements ChallengeGeneratorService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ChallengeGeneratorServiceImpl.class);

	private final static int MINIMUM_FACTOR = 11;
	private final static int MAXIMUM_FACTOR = 100;

	private int next() {
		Random random = new Random();
		return random.nextInt(MAXIMUM_FACTOR - MINIMUM_FACTOR) + MINIMUM_FACTOR;
	}

	@Override
	public Challenge randomChallenge() {
		return new Challenge(next(), next());
	}

}