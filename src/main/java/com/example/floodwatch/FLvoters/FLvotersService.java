package com.example.floodwatch.FLvoters;

import com.example.floodwatch.FLpoll.FLpoll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FLvotersService {
    private final FLvotersRepository fLvotersRepository;

    @Autowired
    public FLvotersService(FLvotersRepository fLvotersRepository) {
        this.fLvotersRepository = fLvotersRepository;
    }

    //GET from service
    public List<FLvoters> getFLvotersFromService(){
        return fLvotersRepository.findAll();
    }

    //POST from service
    public void addFLvotersFromService(FLvoters fLvoters){
        fLvotersRepository.save(fLvoters);
    }

    //DELETE from service
    public void deleteFLvotersFromService(Long votersId) {
        boolean exists =  fLvotersRepository.existsById(votersId);
        if (!exists) {
            throw new IllegalStateException("voters id does not exist");
        } else {
            fLvotersRepository.deleteById(votersId);
        }
    }
    //UPDATE from service
    @Transactional
    public void updateFLvotersFromService(Long votersId, String votersVote) {
        FLvoters fLvoters = fLvotersRepository.findById(votersId)
                .orElseThrow(() -> new IllegalStateException("voters does not exists"));



        fLvoters.setVotersVote(votersVote);
    }
}
