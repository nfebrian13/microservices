package nana.microservices.book.gamification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nana.microservices.book.gamification.domain.LeaderBoardRow;
import nana.microservices.book.gamification.repository.ScoreCardRepository;

import java.util.List;

@Service
class LeaderBoardServiceImpl implements LeaderBoardService {

	@Autowired
	private ScoreCardRepository scoreCardRepository;

	@Override
	public List<LeaderBoardRow> getCurrentLeaderBoard() {
		return scoreCardRepository.findFirst10();
	}
}
