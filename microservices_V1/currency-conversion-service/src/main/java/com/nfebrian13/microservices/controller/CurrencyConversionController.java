package com.nfebrian13.microservices.controller;

import com.nfebrian13.microservices.bean.CurrencyConversionBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        return new CurrencyConversionBean(1L, from, to, BigDecimal.ONE, quantity, quantity, 0);
    }

    @GetMapping("/currency-converter-rest-template/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean converterCurrencyRestTemplate(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        ResponseEntity<CurrencyConversionBean> currencyConversionResponseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, uriVariables);

        CurrencyConversionBean response = currencyConversionResponseEntity.getBody();
        return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity, quantity.multiply(quantity), response.getPort());
    }
}
