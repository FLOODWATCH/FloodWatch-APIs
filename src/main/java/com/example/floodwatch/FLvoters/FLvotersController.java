package com.example.floodwatch.FLvoters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/flvoters")
public class FLvotersController {

    private final FLvotersService fLvotersService;

    @Autowired
    public FLvotersController(FLvotersService fLvotersService) {
        this.fLvotersService = fLvotersService;
    }

    @GetMapping
    public List<FLvoters> getFLvoters(){
        return fLvotersService.getFLvotersFromService();
    }

    @PostMapping
    public void addFLvoters(@RequestBody FLvoters fLvoters){
        fLvotersService.addFLvotersFromService(fLvoters);
    }

    @DeleteMapping(path = "{votersId}")
    public void deleteFLvoters(@PathVariable("votersId") Long votersId) {
        this.fLvotersService.deleteFLvotersFromService(votersId);
    }

    @PutMapping(path = "{votersId}")
    public void updateFLpoll(
            @PathVariable("votersId") Long votersId,
            @RequestParam(required = false) String votersVote ){
        fLvotersService.updateFLvotersFromService(votersId, votersVote);

    }



}
