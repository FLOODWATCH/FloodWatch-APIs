package com.example.floodwatch;

import com.example.floodwatch.FLuser.FLuser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@SpringBootApplication
public class FloodwatchApplication {

  public static void main(String[] args) {
    SpringApplication.run(FloodwatchApplication.class, args);
  }

}
