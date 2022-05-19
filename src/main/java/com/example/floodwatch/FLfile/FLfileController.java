package com.example.floodwatch.FLfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/flfile")
public class FLfileController {

    private final FLfileService fLfileService;

    @Autowired
    public FLfileController(FLfileService fLfileService) {
      this.fLfileService = fLfileService;
    }

    // POST
    @PostMapping("/upload")
    public FLfile uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
      return fLfileService.uploadImage(file);
    }
    // GET ALL
  @GetMapping("/images")
    public List<FLfile> getImages() {
      return fLfileService.getImages();
    }
    // DELETE
    @DeleteMapping(path = "{id}")
    public void deleteFLfile(@PathVariable("id") Long id) {
      fLfileService.deleteFLfile(id);
    }

//  @PostMapping("/upload")
//  public void uploadImage(@RequestBody FLfile fLfile) {
//    this.fLfileService.uploadImage(fLfile);
//  }


}
