package com.example.floodwatch.FLpost;


import com.example.floodwatch.FLuser.FLuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/flpost")
public class FLpostController {

    private final FLpostService fLpostService;

    @Autowired
    public FLpostController(FLpostService fLpostService) {
        this.fLpostService = fLpostService;
    }

    @GetMapping
    public List<FLpost> getFLpost(){
        return fLpostService.getFLpostFromService();
    }

    @PostMapping
    public void addFLpost(@RequestBody FLpost fLpost){
        this.fLpostService.addFlpostFromService(fLpost);
    }
}
