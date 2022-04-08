package com.example.floodwatch.FLfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FLfileService {

    @Autowired
    private  FLfileRepository fLfileRepository;


//    @Autowired
//    public FLfileService(FLfileRepository fLfileRepository) {
//        this.fLfileRepository = fLfileRepository;
//    }

    //for getting list of files (GET)
    public List<FLfile> getFileList(){
        return fLfileRepository.findAll();
    }

    //for getting files by Id (GET)
    public  FLfile getFileById(Long id){
        Optional<FLfile> fLfileOptional = fLfileRepository.findById(id);
        if(fLfileOptional.isPresent()){
            return fLfileOptional.get();
        }
        return null;
    }

    //for POST
    public FLfile store(MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        FLfile ff = new FLfile(filename, file.getContentType(), file.getBytes());
        return fLfileRepository.save(ff);
    }
}






























