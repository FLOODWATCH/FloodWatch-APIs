package com.example.floodwatch.FLwaterLevelPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FLwaterLevelPostService {

    private final FLwaterLevelPostRepository fLwaterLevelPostRepository;

    @Autowired
    public FLwaterLevelPostService(FLwaterLevelPostRepository fLwaterLevelPostRepository) {
        this.fLwaterLevelPostRepository = fLwaterLevelPostRepository;
    }

    //get from service
    public List<FLwaterLevelPost> getWaterLevelPostFromService(){
        return fLwaterLevelPostRepository.findAll();
    }

    //post from service
    public void addWaterLevelPostFromService(FLwaterLevelPost fLwaterLevelPost){
        this.fLwaterLevelPostRepository.save(fLwaterLevelPost);
    }

    //delete from service
    public void deleteWaterLevelPostFromService(Long FlwaterLevelPostId) {
        boolean exists =  fLwaterLevelPostRepository.existsById(FlwaterLevelPostId);
        if (!exists) {
            throw new IllegalStateException("Poll id does not exist");
        } else {
            fLwaterLevelPostRepository.deleteById(FlwaterLevelPostId);
        }
    }
}
