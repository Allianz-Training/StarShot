package com.allianz.finalproject.starshot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import com.allianz.finalproject.starshot.bussiness.domain.ContactUsRepository;

@SpringBootApplication
public class StarshotApplication {
  @Autowired
  private ContactUsRepository contactUsRepository;

  public static void main(String[] args) {
    SpringApplication.run(StarshotApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {
      System.out.println("R E A D Y");

    };
  }
}
