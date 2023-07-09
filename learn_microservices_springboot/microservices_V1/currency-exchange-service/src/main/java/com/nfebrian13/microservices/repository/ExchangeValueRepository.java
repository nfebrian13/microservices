package com.nfebrian13.microservices.repository;

import com.nfebrian13.microservices.model.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue,Long> {
    ExchangeValue findByFromAndTo(String from, String to);
}
