package com.example.floodwatch.FLfile;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table
public class FLfile {
    @Id
    @SequenceGenerator(
            name = "flfile_sequence",
            sequenceName = "flfile_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "flfile_sequence"
    )
    private Long id;
    private String filename;
    private String fileType;
    @Lob
    private  byte[] data;

    public FLfile(Long id, String filename, String fileType, byte[] data) {
        this.id = id;
        this.filename = filename;
        this.fileType = fileType;
        this.data = data;
    }

    public FLfile(String filename, String fileType, byte[] data) {
        this.filename = filename;
        this.fileType = fileType;
        this.data = data;
    }

    public FLfile() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "FLfile{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", fileType='" + fileType + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}

