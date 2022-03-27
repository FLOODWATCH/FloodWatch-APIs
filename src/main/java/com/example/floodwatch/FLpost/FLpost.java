package com.example.floodwatch.FLpost;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table
public class FLpost {
    @Id
    @SequenceGenerator(
            name = "flpost_sequence",
            sequenceName = "flpost_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "flpost_sequence"
    )
    private Long id;
    private String profName;
    private String profEmail;
    private String profTextPost;
    private String profPostTime;


    //constructor with id, name, email, post, and time
    public FLpost(Long id, String profName, String profEmail, String profTextPost, String profPostTime) {
        this.id = id;
        this.profName = profName;
        this.profEmail = profEmail;
        this.profTextPost = profTextPost;
        this.profPostTime = profPostTime;
    }

    //constructor without id and file to post
    public FLpost(String profName, String profEmail, String profTextPost, String profPostTime) {
        this.profName = profName;
        this.profEmail = profEmail;
        this.profTextPost = profTextPost;
        this.profPostTime = profPostTime;
    }

    //constructor without parameter
    public FLpost() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfName() {
        return profName;
    }

    public void setProfName(String profName) {
        this.profName = profName;
    }

    public String getProfEmail() {
        return profEmail;
    }

    public void setProfEmail(String profEmail) {
        this.profEmail = profEmail;
    }

    public String getProfTextPost() {
        return profTextPost;
    }

    public void setProfTextPost(String profTextPost) {
        this.profTextPost = profTextPost;
    }

    public String getProfPostTime() {
        return profPostTime;
    }

    public void setProfPostTime(String profPostTime) {
        this.profPostTime = profPostTime;
    }

    @Override
    public String toString() {
        return "FLpost{" +
                "id=" + id +
                ", profName='" + profName + '\'' +
                ", profEmail='" + profEmail + '\'' +
                ", profTextPost='" + profTextPost + '\'' +
                ", profPostTime='" + profPostTime + '\'' +
                '}';
    }
}
