package com.nfebrian13.microservices.repository;


import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nfebrian13.microservices.bean.CurrencyConversionBean;

//@FeignClient(name = "currency-exchange-services", url = "localhost:8000")
@FeignClient(name = "currency-exchange-services")
@RibbonClient(name = "currency-exchange-services")
public interface CurrencyExchangeServiceProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);

}