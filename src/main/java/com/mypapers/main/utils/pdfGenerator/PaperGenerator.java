package com.mypapers.main.utils.pdfGenerator;

import com.mypapers.main.models.Paper;
import java.util.Map;

public interface PaperGenerator {
    byte[] generatePDF(Paper resultSet, String templateName, Map<String, Object> parameters) ;
}
