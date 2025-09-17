package com.sakalesh.game_app_sdp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sakalesh.game_app_sdp.exceptions.*;
import com.sakalesh.game_app_sdp.services.GameService;

import com.sakalesh.game_app_sdp.modal.Game;
import com.sakalesh.game_app_sdp.repository.GameRepository;

@RestController
@RequestMapping(path = "/games")
public class GameController {
    
    @Autowired
    private GameService service;
    
    // Add home endpoint for root path
    @GetMapping("/")
    public String home() {
        return "Game App API is running! Use the following endpoints:\n" +
               "GET /games - Get all games\n" +
               "POST /games - Create a new game\n" +
               "GET /games/{id} - Get game by ID\n" +
               "PUT /games/{id} - Update game\n" +
               "DELETE /games/{id} - Delete game";
    }
    
    @PostMapping
    public Game create(@RequestBody Game game) {
        return service.create(game);
    }
    
    @GetMapping
    public List<Game> findAll() {
        return service.findAll();
    }
    
    @GetMapping(path = "/{id}")
    public Game findById(@PathVariable String id) throws IdNotPresentException {
        return service.findById(id);
    }
    
    @PutMapping(path = "/{id}")
    public Game update(@PathVariable String id, @RequestBody Game game) throws IdNotPresentException {
        return service.update(id, game);
    }
    
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable String id) throws IdNotPresentException {
        service.delete(id);
    }
}