package com.example.floodwatch.FLwaterLevelPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/flwaterlevelpost")
public class FLwaterLevelPostController {

    private final FLwaterLevelPostService fLwaterLevelPostService;

    @Autowired
    public FLwaterLevelPostController(FLwaterLevelPostService fLwaterLevelPostService) {
        this.fLwaterLevelPostService = fLwaterLevelPostService;
    }

    @GetMapping
    public List<FLwaterLevelPost> getWaterLevelPost(){
        return fLwaterLevelPostService.getWaterLevelPostFromService();
    }

    @PostMapping
    public void addWaterLevelPost(@RequestBody FLwaterLevelPost fLwaterLevelPost){
        this.fLwaterLevelPostService.addWaterLevelPostFromService(fLwaterLevelPost);
    }
}
