package com.example.www_week4;

import com.example.www_week4.daos.ManufaturerDAO;
import com.example.www_week4.entities.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class WwwWeek4Application {
    @Autowired
    private ManufaturerDAO manufaturerDAO;

    public static void main(String[] args) {
        SpringApplication.run(WwwWeek4Application.class, args);
    }
    @Bean
    CommandLineRunner test_1(){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                manufaturerDAO.insert(new Manufacturer("NgocNhu","a@gmail.com"));
                Manufacturer m = manufaturerDAO.findById(0L);
                System.out.println(m);

            }
        };
    }
}
