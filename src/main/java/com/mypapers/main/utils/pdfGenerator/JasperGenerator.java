package com.mypapers.main.utils.pdfGenerator;

import com.mypapers.main.models.Paper;
import com.mypapers.main.utils.common.Properties;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;

public class JasperGenerator implements PaperGenerator{
    public byte[] generatePDF(Paper resultSet, String templateName, Map<String, Object> parameters){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            String filePath = getFilePath(templateName);
            InputStream templateStream
                    = getClass().getResourceAsStream(filePath);
            JasperReport jasperReport = JasperCompileManager.compileReport(templateStream);
            JasperPrint jasperPrint
                    = JasperFillManager.fillReport(jasperReport, parameters,new JREmptyDataSource());
            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
            exporter.exportReport();
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
        return outputStream.toByteArray();
    }

    public String getFilePath(String fileName){
        return Properties.TEMPLATES_BASE_PATH + fileName;
    }
}
