package com.spring.fundamental;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.fundamental.configuration.HelloWorldConfiguration;

@SpringBootTest
public class ApplicationContextTest {

	@Test
	void testApplicationContext() {
		ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
		Assertions.assertNotNull(context);
	}

}
