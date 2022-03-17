package com.example.floodwatch.FLuser;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/fluser")
public class FLuserController {

    //i have created an instance without constructor can i use dependency injection, the autowired annotation
    private final FLuserService fLuserService;

    //dependency injection
    @Autowired
    public FLuserController(FLuserService fLuserService) {
        this.fLuserService = fLuserService;
    }

    //user Get API
    @GetMapping
    public List<FLuser> getFLuser(){
      return fLuserService.getFluserFromService();
    }

    //user Post API
    @PostMapping
    public void addFLuser(@RequestBody FLuser fLuser){
      fLuserService.addFluserFromService(fLuser);
    }
}
