package com.example.floodwatch.FLpost;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

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
//    if (profTextPost != null &&
//          profTextPost.length() > 0 &&
//          !Objects.equals(fLpost.getProfTextPost(), profTextPost)) {
//        fLpost.setProfTextPost(profTextPost);
//      }
  }
}
