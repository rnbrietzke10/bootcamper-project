package com.organization.mvcproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.organization.mvcproject.model.Game;
import com.organization.mvcproject.service.GameService;


@RequestMapping(value ="/game")
@RestController
public class GameController {

	
	private GameService gameService;
	
	public GameController(GameService gameService) {
		this.gameService = gameService;
	}



	@GetMapping(value = "/getAll")
	public ResponseEntity<List<Game>> fetchAllGames() {
		return new ResponseEntity<>(gameService.retrieveAllGames(), HttpStatus.OK);
	}

	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createGame(@RequestBody Game game) {
		gameService.saveGame(game);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateGame(@RequestBody Game game) {
		gameService.updateGame(game);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}