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

    //Get logic
    public List<FLuser> getFluserFromService(){
        return fLuserRepository.findAll();
    }

//    public List<FLuser> getFluserFromService(){
//        return List.of(
//                new FLuser(1L,
//                        "Keemchard Tamio",
//                        "keemchardtamio@gmail.com",
//                        "09305193102",
//                        "Purok 3 0129 Santol, Tanza, Cavite",
//                        "bosskc03")
//        );
//    }
}
