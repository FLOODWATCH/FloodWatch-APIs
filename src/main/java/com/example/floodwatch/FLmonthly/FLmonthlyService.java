package com.example.floodwatch.FLmonthly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FLmonthlyService {

    private final FLmonthlyRepository fLmonthlyRepository;

    @Autowired
    public FLmonthlyService(FLmonthlyRepository fLmonthlyRepository){
        this.fLmonthlyRepository = fLmonthlyRepository;
    }

    //GET from service
    public List<FLmonthly> getFLmontlyFromService(){
        return fLmonthlyRepository.findAll();
    }

    //POST from service
    public void addFLmonthlyFromService(FLmonthly fLmonthly){
        fLmonthlyRepository.save(fLmonthly);
    }


}
