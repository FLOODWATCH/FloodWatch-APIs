package com.example.floodwatch.FLvoters;

import javax.persistence.*;

@Entity
@Table
public class FLvoters{
    @Id
    @SequenceGenerator(
            name = "flvoters_sequence",
            sequenceName = "flvoters_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "flvoters_sequence"
    )
    private Long id;
    private String votersEmail;
    private String votersVote;

    public FLvoters(Long id, String votersEmail, String votersVote) {
        this.id = id;
        this.votersEmail = votersEmail;
        this.votersVote = votersVote;
    }

    public FLvoters(String votersEmail, String votersVote) {
        this.votersEmail = votersEmail;
        this.votersVote = votersVote;
    }

    public FLvoters() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVotersEmail() {
        return votersEmail;
    }

    public void setVotersEmail(String votersEmail) {
        this.votersEmail = votersEmail;
    }

    public String getVotersVote() {
        return votersVote;
    }

    public void setVotersVote(String votersVote) {
        this.votersVote = votersVote;
    }

    @Override
    public String toString() {
        return "FLvoters{" +
                "id=" + id +
                ", votersEmail='" + votersEmail + '\'' +
                ", votersVote='" + votersVote + '\'' +
                '}';
    }
}
