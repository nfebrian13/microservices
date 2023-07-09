package com.nfebrian13.microservices.controller;

import com.nfebrian13.microservices.repository.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nfebrian13.microservices.model.ExchangeValue;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        ExchangeValue exchangeValue = new ExchangeValue(1000L, from, to, new BigDecimal(65));
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return exchangeValue;
    }

    @GetMapping("/currency-exchange-jpa/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValueFromJpa(@PathVariable String from, @PathVariable String to) {
        ExchangeValue exchangeValue = exchangeValueRepository.findByFromAndTo(from,to);
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return exchangeValue;
    }
}
