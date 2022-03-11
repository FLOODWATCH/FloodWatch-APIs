package com.example.floodwatch.FLpost;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class FLpostService {
    private final FLpostRepository fLpostRepository;

    @Autowired
    public FLpostService(FLpostRepository fLpostRepository) {
        this.fLpostRepository = fLpostRepository;
    }

    public List<FLpost> getFLpostFromService(){
        return  fLpostRepository.findAll();
    }

    public void addFlpostFromService(FLpost fLpost){
        fLpostRepository.save(fLpost);
    }



//    public List<FLpost> getFLpost(){
//        return List.of(
//                new FLpost(1L,
//                        "KC",
//                        "kc@gmail.com",
//                        "This is my status",
//                        "March 11 2022")
//        );
//    }
}
