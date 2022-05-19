package com.example.floodwatch.FLpost;


import com.example.floodwatch.FLuser.FLuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.copy;
import static java.nio.file.Paths.get;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/flpost")
public class FLpostController {

    private final FLpostService fLpostService;
//    public static final String DIRECTORY = System.getProperty("user.dir") + "/assets/images/";
    public static final String DIRECTORY = System.getProperty("user.home") + "/Downloads/uploads/";

  // File System Storage
    @PostMapping("/images")
    public ResponseEntity<List<String>> uploadFiles(@RequestParam("files")List<MultipartFile> multipartFiles) throws IOException {
      List<String> filenames = new ArrayList<>();
      for(MultipartFile file : multipartFiles) {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        Path fileStorage = get(DIRECTORY, filename).toAbsolutePath().normalize();
        copy(file.getInputStream(), fileStorage, REPLACE_EXISTING);
        filenames.add(filename);
      }
      return ResponseEntity.ok().body(filenames);
    }
    @GetMapping("download/{filename}")
    public ResponseEntity<Resource> downloadFiles(@PathVariable("filename") String filename) throws IOException {
        Path filePath = get(DIRECTORY).toAbsolutePath().normalize().resolve(filename);
        if(Files.exists(filePath)) {
          throw new FileNotFoundException(filename + " was not found on the server");
        }
        Resource resource = new UrlResource(filePath.toUri());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("File-Name", filename);
        httpHeaders.add(CONTENT_DISPOSITION, "attachment;File-Name=" + resource.getFilename());
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(Files.probeContentType(filePath)))
          .headers(httpHeaders).body(resource);
    }

    // Normal Requests
    @Autowired
    public FLpostController(FLpostService fLpostService) {
      this.fLpostService = fLpostService;
    }

    // Display Data
    @GetMapping
    public List<FLpost> getFLpost(){
      return fLpostService.getFLpostFromService();
    }
    // Get Data File
//    @GetMapping(path = "/upload/{id}")
//    public  FLpost getPost(@PathVariable("id") Long id) throws IOException {
//      return fLpostService.getImage(id);
//    }
    // Get Data with ID
    @GetMapping(path = "/get/{id}")
    public FLpost getPostId(@PathVariable Long id) {
      return fLpostService.getFileById(id);
    }

    // Post Data
    @PostMapping
    public void addFLpost(@RequestBody FLpost fLpost){
      this.fLpostService.addFlpostFromService(fLpost);
    }
    // Post Data with File
//    @PostMapping
//    public FLpost uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
//      return fLpostService.store(file);
//    }

    // Post Data File
//    @PostMapping("/get")
//    public FLpost uploadPost(@RequestParam("file") MultipartFile file, @RequestBody FLpost fLpost) throws IOException {
//      return fLpostService.uploadImage(file, fLpost);
//    }


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
