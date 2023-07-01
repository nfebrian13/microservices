package nana.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nana.rabbitmq.dto.User;
import nana.rabbitmq.publisher.RabbitMQJsonProducer;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {

	@Autowired
	private RabbitMQJsonProducer producer;

	@PostMapping("/publish")
	public ResponseEntity<String> sendMessage(@RequestBody User user) {
		producer.sendJsonMessage(user);
		return ResponseEntity.ok("Json Message sent to RabbitMQ...");
	}

}
