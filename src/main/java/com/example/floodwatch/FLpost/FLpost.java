package com.example.floodwatch.FLpost;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import org.hibernate.annotations.Type;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

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
    private String profFile;

  public FLpost() {
  }

  public FLpost(Long id, String profName, String profEmail, String profTextPost, String profPostTime, String profFile) {
    this.id = id;
    this.profName = profName;
    this.profEmail = profEmail;
    this.profTextPost = profTextPost;
    this.profPostTime = profPostTime;
    this.profFile = profFile;
  }

  public FLpost(String profName, String profEmail, String profTextPost, String profPostTime, String profFile) {
    this.profName = profName;
    this.profEmail = profEmail;
    this.profTextPost = profTextPost;
    this.profPostTime = profPostTime;
    this.profFile = profFile;
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

  public String getProfFile() {
    return profFile;
  }

  public void setProfFile(String profFile) {
    this.profFile = profFile;
  }

  @Override
  public String toString() {
    return "FLpost{" +
      "id=" + id +
      ", profName='" + profName + '\'' +
      ", profEmail='" + profEmail + '\'' +
      ", profTextPost='" + profTextPost + '\'' +
      ", profPostTime='" + profPostTime + '\'' +
      ", profFile='" + profFile + '\'' +
      '}';
  }
}
