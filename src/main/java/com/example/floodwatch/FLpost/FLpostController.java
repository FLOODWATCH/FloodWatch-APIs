package com.example.floodwatch.FLpost;


import com.example.floodwatch.FLuser.FLuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sun.beans.introspect.PropertyInfo.Name.required;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/flpost")
public class FLpostController {

    private final FLpostService fLpostService;

    @Autowired
    public FLpostController(FLpostService fLpostService) {
      this.fLpostService = fLpostService;
    }

    // Display Data
    @GetMapping
    public List<FLpost> getFLpost(){
      return fLpostService.getFLpostFromService();
    }

    // Post Data
    @PostMapping
    public void addFLpost(@RequestBody FLpost fLpost){
      this.fLpostService.addFlpostFromService(fLpost);
    }

    // Delete Data
    @DeleteMapping(path = "{postId}")
    public void deleteFLpost(@PathVariable("postId") Long postId) {
      this.fLpostService.deleteFLpost(postId);
    }

    // Update Data
    @PutMapping(path = "{postId}")
    public void updateFLpost(
        @PathVariable("postId") Long postId,
        @RequestParam(required = false) String profTextPost) {
      this.fLpostService.updateFLpost(postId, profTextPost);
      }
//  @RequestParam(required = false)
}
