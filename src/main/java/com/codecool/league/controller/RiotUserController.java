package com.codecool.league.controller;

import com.codecool.league.model.riotUser.RiotUserDetailModel;
import com.codecool.league.model.riotUser.matchHistory.MatchModel;
import com.codecool.league.model.riotUser.matchResults.MatchResultModel;
import com.codecool.league.service.RiotUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class RiotUserController {

    private final RiotUserService riotUserService;

    @Autowired
    public RiotUserController(RiotUserService riotUserService) {
        this.riotUserService = riotUserService;
    }

    @GetMapping("/riot/{userName}")
    public RiotUserDetailModel getUserInfo(@PathVariable("userName") String userName) {
        return riotUserService.getUserInfo(userName);
    }

    @GetMapping("/riotmatches")
    public List<MatchModel> getMatchHistory() {
        return riotUserService.getMatchHistory();
    }

    @GetMapping("/riot/results")
    public List<MatchResultModel> getMatchResults() {
        return riotUserService.getMatchDetails();
    }

}
