package de.neuefische.rickandmortyclient.controller;

import de.neuefische.rickandmortyclient.model.RMCharacter;
import de.neuefische.rickandmortyclient.service.RMService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ram")
@RequiredArgsConstructor
public class RickAndMortyController {
    private final RMService rmService; // initialize Service-class

    @GetMapping("/characters")
    public List<RMCharacter> getAllCharacters(){
        return rmService.getAllCharacters();
    }

    @GetMapping("/characters/alive")
    public List<RMCharacter> getAllAliveCharacters(){
        return rmService.getAllAliveCharacters();
    }

}
