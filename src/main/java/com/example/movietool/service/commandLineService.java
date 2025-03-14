package com.example.movietool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class commandLineService {
    @Autowired
    private getTitleService getTitleService;

    public void processCommand(String command) {
        switch (command) {
            case "playing":
                getTitleService.getNowPlayingTitle();
                break;
            case "popular":
                getTitleService.getPopularTitle();
                break;
            case "top":
                getTitleService.getTopRatedTitle();
                break;
            case "upcoming":
                getTitleService.getUpcomingTitle();
                break;
            default:
                System.out.println("invalid command");
        }
    }
}
