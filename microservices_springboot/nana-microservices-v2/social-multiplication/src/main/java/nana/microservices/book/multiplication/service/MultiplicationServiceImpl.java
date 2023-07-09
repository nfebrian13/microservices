package nana.microservices.book.multiplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nana.microservices.book.multiplication.model.Multiplication;

@Service
class MultiplicationServiceImpl implements MultiplicationService {

	@Autowired
	private RandomGeneratorService randomGeneratorService;

	@Override
	public Multiplication createRandomMultiplication() {
		int factorA = randomGeneratorService.generateRandomFactor();
		int factorB = randomGeneratorService.generateRandomFactor();
		return new Multiplication(factorA, factorB);
	}
}