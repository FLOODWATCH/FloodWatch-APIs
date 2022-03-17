package com.example.floodwatch.FLuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FLuserService {

    //i have created a variable of FLuser Repo below but take note pre that interface cannot be intanciated, kaya nga gagamit tayo lago ng dependency injection
    private final FLuserRepository fLuserRepository;

    @Autowired
    public FLuserService(FLuserRepository fLuserRepository) {
      this.fLuserRepository = fLuserRepository;
    }

    //Get Service
    public List<FLuser> getFluserFromService(){
      return fLuserRepository.findAll();
    }

    //Post Service
    public void addFluserFromService(FLuser fLuser){
      fLuserRepository.save(fLuser);
    }


}
