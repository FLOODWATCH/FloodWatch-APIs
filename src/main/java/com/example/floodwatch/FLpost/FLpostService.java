package com.example.floodwatch.FLpost;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;
import javax.persistence.RollbackException;


import javax.transaction.Transactional;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;


@Service
public class FLpostService {
    private final FLpostRepository fLpostRepository;

    @Autowired
    public FLpostService(FLpostRepository fLpostRepository) {
      this.fLpostRepository = fLpostRepository;
    }

    // GET SERVICE
    public List<FLpost> getFLpostFromService(){
      return  fLpostRepository.findAll();
    }

    // POST SERVICE
    public void addFlpostFromService(FLpost fLpost){
      fLpostRepository.save(fLpost);
    }
    // Simple Get by ID
    public FLpost getFileById(Long id) {
      Optional<FLpost> fLpostOptional = fLpostRepository.findById(id);
      if (fLpostOptional.isPresent()) {
        return fLpostOptional.get();
      } return null;
    }

    // DELETE SERVICE
    public void deleteFLpost(Long postId) {
      boolean exists =  fLpostRepository.existsById(postId);
      if (!exists) {
        throw new IllegalStateException("Student id does not exist");
      } else {
          fLpostRepository.deleteById(postId);
      }
    }

    // UPDATE SERVICE
    @Transactional
    public void updateFLpost(Long postId, String profTextPost) {
        FLpost fLpost = fLpostRepository.findById(postId)
            .orElseThrow(() -> new IllegalStateException("student does not exists"));
        fLpost.setProfTextPost(profTextPost);
    }




    //for fileeeeeeeeeeeeeeeeeeee START

    //for fileeeeeeeeeeeeeeeeeeee START
}
