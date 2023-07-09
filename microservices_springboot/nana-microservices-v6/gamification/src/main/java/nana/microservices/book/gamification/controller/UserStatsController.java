package nana.microservices.book.gamification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nana.microservices.book.gamification.domain.GameStats;
import nana.microservices.book.gamification.service.GameService;

/**
 * This class implements a REST API for the Gamification User Statistics
 * service.
 */
@RestController
@RequestMapping("/stats")
class UserStatsController {

	@Autowired
	private GameService gameService;

	@GetMapping
	public GameStats getStatsForUser(@RequestParam("userId") Long userId) {
		return gameService.retrieveStatsForUser(userId);
	}
}