package com.codecool.league.service;

import org.json.JSONArray;
import org.json.JSONObject;

import com.codecool.league.dao.RiotApiDao;
import org.springframework.beans.factory.annotation.Autowired;

public class RiotApiService {

    RiotApiDao riotApiDao;
    JSONObject user;
    JSONArray matchHistory;


    @Autowired
    public RiotApiService(RiotApiDao riotApiDao) {
        this.riotApiDao = riotApiDao;
    }

    public String getAllChampion() {
        return riotApiDao.getAllChampion();
    }

    public String getFreeChampions() {
        return riotApiDao.getFreeChampions();
    }

    public String getUserInfo(String userName) {
        user = new JSONObject(riotApiDao.getUserInfo(userName));
        return user.toString();
    }

    public String getMatchHistory() {
        String matchHistory = riotApiDao.getMatchHistory(user.getString("accountId"));
        JSONObject matchHistoryJSON = new JSONObject(matchHistory);
        JSONArray matchHistoryJSONArray = matchHistoryJSON.getJSONArray("matches");
        JSONArray reducedMatchHistoryArray = new JSONArray();

        for (int i = 0; i < 10; i++) {
            JSONObject match = new JSONObject();
            match.put("gameId", matchHistoryJSONArray.getJSONObject(i).getString("gameId"));
            match.put("champion", matchHistoryJSONArray.getJSONObject(i).getString("champion"));
            reducedMatchHistoryArray.put(match);
        }
        this.matchHistory = reducedMatchHistoryArray;
        return reducedMatchHistoryArray.toString();
    }

    public String getMatchDetails() {
        //TODO: check for user's team
        JSONArray reducedMatchHistoryJSONArray = new JSONArray();

        for (int i = 0; i < matchHistory.length(); i++) {

            String matchDetail = riotApiDao.getMatchResult(matchHistory.getJSONObject(i).getString("gameId"));
            JSONObject matchDetailJSON = new JSONObject(matchDetail);

            JSONObject reducedMatchDetailJSON = new JSONObject();
            reducedMatchDetailJSON.put("gameId", matchDetailJSON.getString("gameId"));
            reducedMatchDetailJSON.put("platformId", matchDetailJSON.getString("platformId"));
            reducedMatchDetailJSON.put("gameDuration", matchDetailJSON.getString("gameDuration"));
            reducedMatchDetailJSON.put("gameMode", matchDetailJSON.getString("gameMode"));

            JSONArray teams = new JSONArray(matchDetailJSON.getJSONArray("teams"));
            JSONArray reducedTeams = new JSONArray();
            for (int j = 0; j < teams.length(); j++) {
                JSONObject reducedTeamDetail = new JSONObject();
                reducedTeamDetail.put("teamId", teams.getJSONObject(j).getString("teamId"));
                reducedTeamDetail.put("win", teams.getJSONObject(j).getString("win"));
                reducedTeams.put(reducedTeamDetail);
            }
            reducedMatchDetailJSON.put("teams", reducedTeams);

            reducedMatchHistoryJSONArray.put(reducedMatchDetailJSON);
        }

        return reducedMatchHistoryJSONArray.toString();
    }
}