package com.example.floodwatch.FLwaterLevelPost;

import javax.persistence.*;

@Entity
@Table
public class FLwaterLevelPost {
    @Id
    @SequenceGenerator(
            name = "flwaterlevelpost_sequence",
            sequenceName = "flwaterlevelpost_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "flwaterlevelpost_sequence"
    )
    private Long id;
    private String wlLevel;
    private String wlInfo;
    private String wlTime;
    private String wlMonth;
    private String wlColor;

    public FLwaterLevelPost(Long id, String wlLevel, String wlInfo, String wlTime, String wlMonth, String wlColor) {
        this.id = id;
        this.wlLevel = wlLevel;
        this.wlInfo = wlInfo;
        this.wlTime = wlTime;
        this.wlMonth = wlMonth;
        this.wlColor = wlColor;
    }

    public FLwaterLevelPost(String wlLevel, String wlInfo, String wlTime, String wlMonth, String wlColor) {
        this.wlLevel = wlLevel;
        this.wlInfo = wlInfo;
        this.wlTime = wlTime;
        this.wlMonth = wlMonth;
        this.wlColor = wlColor;
    }

    public FLwaterLevelPost() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWlLevel() {
        return wlLevel;
    }

    public void setWlLevel(String wlLevel) {
        this.wlLevel = wlLevel;
    }

    public String getWlInfo() {
        return wlInfo;
    }

    public void setWlInfo(String wlInfo) {
        this.wlInfo = wlInfo;
    }

    public String getWlTime() {
        return wlTime;
    }

    public void setWlTime(String wlTime) {
        this.wlTime = wlTime;
    }

    public String getWlMonth() {
        return wlMonth;
    }

    public void setWlMonth(String wlMonth) {
        this.wlMonth = wlMonth;
    }

    public String getWlColor() {
        return wlColor;
    }

    public void setWlColor(String wlColor) {
        this.wlColor = wlColor;
    }

    @Override
    public String toString() {
        return "FLwaterLevelPost{" +
                "id=" + id +
                ", wlLevel='" + wlLevel + '\'' +
                ", wlInfo='" + wlInfo + '\'' +
                ", wlTime='" + wlTime + '\'' +
                ", wlMonth='" + wlMonth + '\'' +
                ", wlColor='" + wlColor + '\'' +
                '}';
    }
}
