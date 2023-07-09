package nana.microservices.multiplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import nana.microservices.multiplication.domain.ChallengeAttempt;
import nana.microservices.multiplication.dto.ChallengeAttemptDTO;
import nana.microservices.multiplication.service.ChallengeService;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class provides a REST API to POST the attempts from users.
 */
@RestController
@RequestMapping("/attempts")
class ChallengeAttemptController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ChallengeAttemptController.class);

	@Autowired
	private ChallengeService challengeService;

	@PostMapping
	ResponseEntity<ChallengeAttempt> postResult(@RequestBody @Valid ChallengeAttemptDTO challengeAttemptDTO) {
		return ResponseEntity.ok(challengeService.verifyAttempt(challengeAttemptDTO));
	}
}