package com.mypapers.main.services;

import com.mypapers.main.models.Paper;
import com.mypapers.main.utils.pdfGenerator.PaperGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PapersService {
    private final PaperGenerator paperGenerator;
    @Autowired
    public PapersService(PaperGenerator paperGenerator) {
        this.paperGenerator = paperGenerator;
    }
    public byte[] getMcqPaper(Paper paper){
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("p1", "Param1");
        return paperGenerator.generatePDF(new Paper(), "template1.jrxml", parameters);
    }
}
