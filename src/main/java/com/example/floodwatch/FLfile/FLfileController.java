package com.example.floodwatch.FLfile;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/flfile")
public class FLfileController {


    @Autowired
    private FLfileService fLfileService;


//    @Autowired
//    public FLfileController(FLfileService fLfileService) {
//        this.fLfileService = fLfileService;
//    }

    @GetMapping("/{id}")
    public FLfile getFile(@PathVariable Long id){
        return fLfileService.getFileById(id);
    }

    @GetMapping
    public List<FLfile> getFileList(){
        return fLfileService.getFileList();
    }

    @PostMapping
    public FLfile uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        return fLfileService.store(file);
    }
}




























