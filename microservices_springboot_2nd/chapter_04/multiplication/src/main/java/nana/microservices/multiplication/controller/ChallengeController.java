package nana.microservices.multiplication.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nana.microservices.multiplication.domain.Challenge;
import nana.microservices.multiplication.service.ChallengeGeneratorService;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ChallengeController.class);

	@Autowired
    private ChallengeGeneratorService challengeGeneratorService;

	@GetMapping("/random")
	public Challenge getRandomChallenge() {
		Challenge challenge = challengeGeneratorService.randomChallenge();
		LOGGER.info("Generating a random challenge: {}", challenge);
		return challenge;
	}
}
