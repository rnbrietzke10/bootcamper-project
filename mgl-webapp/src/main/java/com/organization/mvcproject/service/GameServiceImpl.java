package com.organization.mvcproject.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.organization.mvcproject.dao.GamesDAO;
import com.organization.mvcproject.model.Game;

@Service()
public class GameServiceImpl implements GameService {

	@Override
	public List<Game> retrieveAllGames() {
		
		return GamesDAO.findAllGames();
	}

	@Override
	public Game saveGame(Game game) {
		
		return GamesDAO.saveOrUpdateGame(game);
	}
	
	



	

}