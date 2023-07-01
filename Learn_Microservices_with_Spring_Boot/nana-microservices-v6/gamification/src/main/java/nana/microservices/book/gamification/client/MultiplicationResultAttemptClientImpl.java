package nana.microservices.book.gamification.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import nana.microservices.book.gamification.client.dto.MultiplicationResultAttempt;

/**
 * This implementation of MultiplicationResultAttemptClient interface connects
 * to the Multiplication microservice via REST.
 */
@Component
class MultiplicationResultAttemptClientImpl implements MultiplicationResultAttemptClient {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${multiplicationHost}")
	private String multiplicationHost;
	
	@Override
	public MultiplicationResultAttempt retrieveMultiplicationResultAttemptbyId(Long multiplicationResultAttemptId) {
		return restTemplate.getForObject(multiplicationHost + "/results/" + multiplicationResultAttemptId,
				MultiplicationResultAttempt.class);
	}
}
