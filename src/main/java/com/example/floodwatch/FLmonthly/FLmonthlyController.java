package com.example.floodwatch.FLmonthly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/flmonthly")
public class FLmonthlyController {

    private final FLmonthlyService fLmonthlyService;

    @Autowired
    public FLmonthlyController(FLmonthlyService fLmonthlyService){
        this.fLmonthlyService = fLmonthlyService;
    }

    @GetMapping
    public List<FLmonthly> getFLmonthly(){
        return fLmonthlyService.getFLmontlyFromService();
    }

    @PostMapping
    public void addFLmonthly(@RequestBody FLmonthly fLmonthly){
        fLmonthlyService.addFLmonthlyFromService(fLmonthly);
    }

}
