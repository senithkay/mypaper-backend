package com.mypapers.main.configurations;

import com.mypapers.main.utils.pdfGenerator.JasperGenerator;
import com.mypapers.main.utils.pdfGenerator.PaperGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public PaperGenerator paperGenerator(){
        return new JasperGenerator();
    }
}
