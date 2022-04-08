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

    public List<FLwaterLevelPost> getWaterLevelPostFromService(){
        return fLwaterLevelPostRepository.findAll();
    }

    public void addWaterLevelPostFromService(FLwaterLevelPost fLwaterLevelPost){
        this.fLwaterLevelPostRepository.save(fLwaterLevelPost);
    }
}
