package com.example.floodwatch.FLuser;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FLuserConfiguration {

    @Bean
    CommandLineRunner commandLineRunner (FLuserRepository fLuserRepository){
        return args -> {
            FLuser [] users = {
                    new FLuser(
                            "Keemchard Tamio",
                            "keemchardtamio@gmail.com",
                            "09305193102",
                            "Purok 3 0129 Santol, Tanza, Cavite",
                            "bosskc03"),
                    new FLuser(
                            "Testing Test",
                            "testingtest@gmail.com",
                            "09123456789",
                            "Amaya 2 Tanza Cavite",
                            "test123"),
            };
            for(int i = 0; i < users.length; i++){
//                System.out.println("------------------------------------------------------------------------------------");
//                System.out.println(users[i]);
//                System.out.println("------------------------------------------------------------------------------------");
                 fLuserRepository.save(users[i]);
            }
        };
    }
}
