package com.codecool.league.controller;

import com.codecool.league.model.champions.ChampionsDataModel;
import com.codecool.league.model.champions.ChampionsIdAndKeyDataModel;
import com.codecool.league.service.ChampionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class ChampionsController {

    private final ChampionsService championsService;

    @Autowired
    public ChampionsController(ChampionsService championsService) {
        this.championsService = championsService;
    }

    @GetMapping("/champions")
    public ChampionsDataModel getAllChampion() {
        return championsService.getAllChampion();
    }

    @GetMapping("/champions/userdata")
    public ChampionsIdAndKeyDataModel getAllChampionIdsAndKeys() {
        return championsService.getAllChampionIdsAndKeys();
    }

    @GetMapping("/champions/{tag}")
    public ChampionsDataModel getChampionsByTag(@PathVariable("tag") String tag) {
        return championsService.getChampionsByTag(tag);
    }
}
