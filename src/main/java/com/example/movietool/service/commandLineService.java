package com.example.movietool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class commandLineService {
    @Autowired
    private getTitleService getTitleService;
}
