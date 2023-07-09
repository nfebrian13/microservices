package nana.microservices.book.gamification.service;

import java.util.List;

import nana.microservices.book.gamification.domain.LeaderBoardRow;

/**
 * Provides methods to access the LeaderBoard with users and scores.
 */
public interface LeaderBoardService {

	/**
	 * Retrieves the current leader board with the top score users
	 * 
	 * @return the users with the highest score
	 */
	List<LeaderBoardRow> getCurrentLeaderBoard();
}