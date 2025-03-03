package com.example.movietool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Service
public class commandLineService {
    @Autowired
    private getTitleService getTitleService;
    public void readHelpFile() {
        try{
            File file = new File("src/main/java/CLI/MovieDatabaseFetch/help.txt");
            FileReader fileReader = new FileReader(file);
            int character;
            while((character = fileReader.read()) != -1) {
                System.out.println((char) character);
            }
            System.out.println();
        }
        catch (IOException e) {
            e.getMessage();
        }
    }
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
            case "--h":
                readHelpFile();
                break;
            default:
                System.out.println("invalid command");
        }
    }
}
