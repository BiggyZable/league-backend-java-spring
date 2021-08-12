package com.codecool.league.controller;

import com.codecool.league.model.news.NewsModel;
import com.codecool.league.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }


    @GetMapping("/news/{pageNumber}")
    public List<NewsModel> getNews(@PathVariable("pageNumber") int pageNumber) {
        return newsService.getNews(pageNumber);
    }

}
