package com.example.floodwatch.FLpoll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/flpoll")
public class FLpollController {
    private final FLpollService fLpollService;

    @Autowired
    public FLpollController(FLpollService fLpollService) {
        this.fLpollService = fLpollService;
    }

    @GetMapping
    public List<FLpoll> getFLpoll(){
        return  fLpollService.getFlpollFromService();
    }

    @PostMapping
    public void addFLpoll(@RequestBody FLpoll fLpoll){
        fLpollService.addFlpollFromService(fLpoll);
    }

    @DeleteMapping(path = "{pollId}")
    public void deleteFLpost(@PathVariable("pollId") Long pollId) {
        this.fLpollService.deleteFLpollFromService(pollId);
    }


    @PutMapping(path = "{pollId}")
    public void updateFLpoll(
            @PathVariable("pollId") Long pollId,
            @RequestParam(required = false) Integer pollSafeVote,
            @RequestParam(required = false) Integer pollNotSafeVote,
            @RequestParam(required = false) Integer pollNoVote,
            @RequestParam(required = false) Integer pollTotalVoters ){
        fLpollService.updateFLpollFromService(pollId, pollSafeVote, pollNotSafeVote, pollNoVote, pollTotalVoters);

    }

}
