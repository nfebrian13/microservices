package com.nfebrian13.microservices.repository;


import com.nfebrian13.microservices.bean.CurrencyConversionBean;
import org.springframework.cloud.openfeign.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange-services", url = "localhost:8000")
//@RibbonClient(name = "currency-exchange-services")
public interface CurrencyExchangeServiceProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);

}