package nana.microservices.book.multiplication.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import nana.microservices.book.multiplication.event.EventDispatcher;
import nana.microservices.book.multiplication.event.MultiplicationSolvedEvent;
import nana.microservices.book.multiplication.model.Multiplication;
import nana.microservices.book.multiplication.model.MultiplicationResultAttempt;
import nana.microservices.book.multiplication.model.User;
import nana.microservices.book.multiplication.repository.MultiplicationResultAttemptRepository;
import nana.microservices.book.multiplication.repository.UserRepository;

@Service
public class MultiplicationServiceImpl implements MultiplicationService {

	@Autowired
	private RandomGeneratorService randomGeneratorService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MultiplicationResultAttemptRepository attemptRepository;

	@Autowired
	private EventDispatcher eventDispatcher;

	@Override
	public Multiplication createRandomMultiplication() {
		int factorA = randomGeneratorService.generateRandomFactor();
		int factorB = randomGeneratorService.generateRandomFactor();
		return new Multiplication(factorA, factorB);
	}

	@Transactional
	@Override
	public boolean checkAttempt(final MultiplicationResultAttempt attempt) {
		// Check if the user already exists for that alias
		Optional<User> user = userRepository.findByAlias(attempt.getUser().getAlias());

		// Avoids 'hack' attempts
		Assert.isTrue(!attempt.isCorrect(), "You can't send an attempt marked as correct!!");

		// Check if the attempt is correct
		boolean isCorrect = attempt.getResultAttempt() == 
				attempt.getMultiplication().getFactorA() * 
				attempt.getMultiplication().getFactorB();

		MultiplicationResultAttempt checkedAttempt = new MultiplicationResultAttempt(user.orElse(attempt.getUser()),
				attempt.getMultiplication(), attempt.getResultAttempt(), isCorrect);

		// Stores the attempt
		attemptRepository.save(checkedAttempt);

		// Communicates the result via Event
		eventDispatcher.send(new MultiplicationSolvedEvent(
				checkedAttempt.getId(), 
				checkedAttempt.getUser().getId(),
				checkedAttempt.isCorrect()));

		return isCorrect;
	}

	@Override
	public List<MultiplicationResultAttempt> getStatsForUser(String userAlias) {
		return attemptRepository.findTop5ByUserAliasOrderByIdDesc(userAlias);
	}

	@Override
	public MultiplicationResultAttempt getResultById(Long resultId) {
		return attemptRepository.findById(resultId).orElse(null);
	}

}