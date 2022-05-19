package com.example.floodwatch.FLpoll;


import javax.persistence.*;

@Entity
@Table
public class FLpoll {
    @Id
    @SequenceGenerator(
            name = "flpoll_sequence",
            sequenceName = "flpoll_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "flpoll_sequence"
    )
    private Long id;
    private String pollDate;
    //private int pollSafeVote = 0;
    private Integer pollSafeVote;
   // private int pollNotSafeVote = 0;
    private Integer pollNotSafeVote;
   // private int pollNoVote = 0;
    private Integer pollNoVote;
   // private int pollTotalVoters = 0;
    private Integer pollTotalVoters;

    public FLpoll(Long id, String pollDate, Integer pollSafeVote, Integer pollNotSafeVote, Integer pollNoVote, Integer pollTotalVoters) {
        this.id = id;
        this.pollDate = pollDate;
        this.pollSafeVote = pollSafeVote;
        this.pollNotSafeVote = pollNotSafeVote;
        this.pollNoVote = pollNoVote;
        this.pollTotalVoters = pollTotalVoters;
    }

    public FLpoll(String pollDate, Integer pollSafeVote, Integer pollNotSafeVote, Integer pollNoVote, Integer pollTotalVoters) {
        this.pollDate = pollDate;
        this.pollSafeVote = pollSafeVote;
        this.pollNotSafeVote = pollNotSafeVote;
        this.pollNoVote = pollNoVote;
        this.pollTotalVoters = pollTotalVoters;
    }

    public FLpoll() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPollDate() {
        return pollDate;
    }

    public void setPollDate(String pollDate) {
        this.pollDate = pollDate;
    }

    public Integer getPollSafeVote() {
        return pollSafeVote;
    }

    public void setPollSafeVote(Integer pollSafeVote) {
        this.pollSafeVote = pollSafeVote;
    }

    public Integer getPollNotSafeVote() {
        return pollNotSafeVote;
    }

    public void setPollNotSafeVote(Integer pollNotSafeVote) {
        this.pollNotSafeVote = pollNotSafeVote;
    }

    public Integer getPollNoVote() {
        return pollNoVote;
    }

    public void setPollNoVote(Integer pollNoVote) {
        this.pollNoVote = pollNoVote;
    }

    public Integer getPollTotalVoters() {
        return pollTotalVoters;
    }

    public void setPollTotalVoters(Integer pollTotalVoters) {
        this.pollTotalVoters = pollTotalVoters;
    }

    @Override
    public String toString() {
        return "FLpoll{" +
                "id=" + id +
                ", pollDate='" + pollDate + '\'' +
                ", pollSafeVote=" + pollSafeVote +
                ", pollNotSafeVote=" + pollNotSafeVote +
                ", pollNoVote=" + pollNoVote +
                ", pollTotalVoters=" + pollTotalVoters +
                '}';
    }
}
