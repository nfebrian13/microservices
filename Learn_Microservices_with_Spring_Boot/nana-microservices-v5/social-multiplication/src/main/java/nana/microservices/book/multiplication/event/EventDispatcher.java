package nana.microservices.book.multiplication.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Handles the communication with the Event Bus.
 */
@Component
public class EventDispatcher {

	private static final Logger LOGGER = LoggerFactory.getLogger(EventDispatcher.class);

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Value("${multiplication.exchange}")
	private String multiplicationExchange;

	@Value("${multiplication.routing.key}")
	private String multiplicationRoutingRoutingKey;

	public void send(MultiplicationSolvedEvent multiplicationSolvedEvent) {
		LOGGER.info(String.format("MultiplicationSolvedEvent Message sent -> %s",
				multiplicationExchange + " " + multiplicationRoutingRoutingKey));

		rabbitTemplate.convertAndSend(multiplicationExchange, multiplicationRoutingRoutingKey,
				multiplicationSolvedEvent);
	}
}