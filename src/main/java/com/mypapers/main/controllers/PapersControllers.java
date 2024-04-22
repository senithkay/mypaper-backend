package com.mypapers.main.controllers;

import com.mypapers.main.dtos.QuestionsAndAnswers;
import com.mypapers.main.models.Paper;
import com.mypapers.main.services.PapersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(value = "/papers")
public class PapersControllers {
    private final PapersService papersService;
    @Autowired
    public PapersControllers(PapersService papersService) {
        this.papersService = papersService;
    }
    @PostMapping("/getMcqPaper")
    public byte[] getMcqPaper(@RequestBody List<QuestionsAndAnswers> questionsAndAnswers) {
        return papersService.getMcqPaper(new Paper());
    }
}
