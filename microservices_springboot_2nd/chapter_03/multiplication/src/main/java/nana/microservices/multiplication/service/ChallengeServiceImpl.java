package nana.microservices.multiplication.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import nana.microservices.multiplication.domain.ChallengeAttempt;
import nana.microservices.multiplication.domain.User;
import nana.microservices.multiplication.dto.ChallengeAttemptDTO;

@Service
public class ChallengeServiceImpl implements ChallengeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ChallengeServiceImpl.class);
	
    @Override
    public ChallengeAttempt verifyAttempt(ChallengeAttemptDTO attemptDTO) {
        // Check if the attempt is correct
        boolean isCorrect = attemptDTO.getGuess() ==
                attemptDTO.getFactorA() * attemptDTO.getFactorB();

        // We don't use identifiers for now
        User user = new User(null, attemptDTO.getUserAlias());

        // Builds the domain object. Null id for now.
        ChallengeAttempt checkedAttempt = new ChallengeAttempt(null,
                user,
                attemptDTO.getFactorA(),
                attemptDTO.getFactorB(),
                attemptDTO.getGuess(),
                isCorrect
        );
        return checkedAttempt;
    }
    
}