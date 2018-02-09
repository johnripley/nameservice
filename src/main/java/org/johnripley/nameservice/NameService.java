package org.johnripley.nameservice;

import org.johnripley.nameinfo.BaseNameLookup;
import org.johnripley.nameinfo.NameLookup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NameService {
    

    @Value("${names-service.startYear:1880}")
    int startYear;
    
    @Value("${names-service.endYear:2016}")
    int endYear;
    
    public static void main(String[] args) {
	SpringApplication.run(NameService.class, args);
    }

    @Bean
    public NameLookup nameLooup()
    {
	return new BaseNameLookup(startYear, endYear);
    }
    
}
