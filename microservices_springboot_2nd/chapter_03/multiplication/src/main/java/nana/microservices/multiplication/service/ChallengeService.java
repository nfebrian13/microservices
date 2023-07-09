package nana.microservices.multiplication.service;

import nana.microservices.multiplication.domain.ChallengeAttempt;
import nana.microservices.multiplication.dto.ChallengeAttemptDTO;

public interface ChallengeService {

    /**
     * Verifies if an attempt coming from the presentation layer is correct or not.
     *
     * @return the resulting ChallengeAttempt object
     */
    ChallengeAttempt verifyAttempt(ChallengeAttemptDTO attemptDTO);

}