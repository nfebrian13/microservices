package nana.microservices.book.gamification.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

/**
 * Configures RabbitMQ to use events in our application.
 */
@Configuration
public class RabbitMQConfiguration implements RabbitListenerConfigurer {
	
	@Value("${multiplication.exchange}")
	private String exchangeName;
	
	@Value("${multiplication.routing.key}")
	private String routingKey;
	
	@Value("${multiplication.queue}")
	private String queueName;

	public TopicExchange multiplicationExchange() {
		return new TopicExchange(exchangeName);
	}
	
	@Bean
	public Queue jsonQueue() {
		return new Queue(queueName);
	}
	
	@Bean
	public Binding jsonBinding() {
		return BindingBuilder.bind(jsonQueue())
				.to(multiplicationExchange())
				.with(routingKey);
	}	

	@Bean
	public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
		return new MappingJackson2MessageConverter();
	}

	@Bean
	public DefaultMessageHandlerMethodFactory messageHandlerMethodFactory() {
		DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
		factory.setMessageConverter(consumerJackson2MessageConverter());
		return factory;
	}

	@Override
	public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
		registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
	}
}