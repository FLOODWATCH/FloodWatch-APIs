package com.example.floodwatch.FLpoll;

import com.example.floodwatch.FLpost.FLpost;
import com.example.floodwatch.FLpost.FLpostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FLpollService {
    private final FLpollRepository fLpollRepository;

    @Autowired
    public FLpollService(FLpollRepository fLpollRepository) {
        this.fLpollRepository = fLpollRepository;
    }

    //GET SERVICE
    public List<FLpoll> getFlpollFromService(){
        return fLpollRepository.findAll();
    }


    //POST SERVICE
    public void addFlpollFromService(FLpoll flpoll){
        fLpollRepository.save(flpoll);
    }


    // DELETE SERVICE
    public void deleteFLpollFromService(Long pollId) {
        boolean exists =  fLpollRepository.existsById(pollId);
        if (!exists) {
            throw new IllegalStateException("Poll id does not exist");
        } else {
            fLpollRepository.deleteById(pollId);
        }
    }


    // UPDATE SERVICE
    @Transactional
    public void updateFLpollFromService(Long pollId,
                                        Integer pollSafeVote,
                                        Integer pollNotSafeVote,
                                        Integer pollNoVote,
                                        Integer pollTotalVoters) {
        FLpoll fLpoll = fLpollRepository.findById(pollId)
                .orElseThrow(() -> new IllegalStateException("poll does not exists"));
       if(pollSafeVote != null){
           fLpoll.setPollSafeVote(pollSafeVote);
       }else if(pollSafeVote == null){
           fLpoll.setPollNotSafeVote(fLpoll.getPollSafeVote());
       }
       if(pollNotSafeVote != null){
           fLpoll.setPollNotSafeVote(pollNotSafeVote);
       }else if(pollNotSafeVote == null){
           fLpoll.setPollNotSafeVote(fLpoll.getPollNotSafeVote());
       }
       if(pollNoVote != null){
           fLpoll.setPollNoVote(pollNoVote);
       }else if(pollNoVote == null){
           fLpoll.setPollNoVote(fLpoll.getPollNoVote());
       }
       if(pollTotalVoters != null){
           fLpoll.setPollTotalVoters(pollTotalVoters);
       }else if(pollTotalVoters == null){
           fLpoll.setPollTotalVoters(fLpoll.getPollTotalVoters());
       }





    }
}
