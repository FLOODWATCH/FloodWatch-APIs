package com.example.floodwatch.FLmonthly;

import javax.persistence.*;

@Entity
@Table
public class FLmonthly {
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
    private String month;

    public FLmonthly(Long id, String month) {
        this.id = id;
        this.month = month;
    }

    public FLmonthly(String month) {
        this.month = month;
    }

    public FLmonthly() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }


    @Override
    public String toString() {
        return "FLmonthly{" +
                "id=" + id +
                ", month='" + month + '\'' +
                '}';
    }
}
