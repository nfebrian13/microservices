package nana.microservices.book.gamification.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nana.microservices.book.gamification.service.GameService;

/**
 * This class receives the events and triggers the associated business logic.
 */
@Component
class EventHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(EventHandler.class);

	@Autowired
	private GameService gameService;

	@RabbitListener(queues = { "multiplication_queue" })
	void handleMultiplicationSolved(MultiplicationSolvedEvent event) {
		LOGGER.info("Multiplication Solved Event received: {}", event.getMultiplicationResultAttemptId());

		try {
			gameService.newAttemptForUser(event.getUserId(), event.getMultiplicationResultAttemptId(),
					event.isCorrect());
		} catch (final Exception e) {
			LOGGER.error("Error when trying to process MultiplicationSolvedEvent", e);
			// Avoids the event to be re-queued and reprocessed.
			throw new AmqpRejectAndDontRequeueException(e);
		}
	}
}