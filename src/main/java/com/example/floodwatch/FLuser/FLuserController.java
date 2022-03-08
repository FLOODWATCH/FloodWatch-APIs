package com.example.floodwatch.FLuser;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
    public List<FLuser> Hello(){
        return fLuserService.getFluserFromService();
    }
}
