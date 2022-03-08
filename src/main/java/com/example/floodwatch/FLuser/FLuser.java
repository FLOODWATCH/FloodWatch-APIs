package com.example.floodwatch.FLuser;

import javax.persistence.*;

@Entity
@Table
public class FLuser {
    @Id
    @SequenceGenerator(
            name = "fluser_sequence",
            sequenceName = "fluser_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "fluser_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private String mobile;
    private String address;
    private String password;

    //constructor with all parameters
    public FLuser(Long id, String name, String email, String mobile, String address, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.password = password;
    }

    //constructor with all, execpt id
    public FLuser(String name, String email, String mobile, String address, String password) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.password = password;
    }

    //constructor without parameter\
    public FLuser() {

    }


    //getters & setters below
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    //toString method below

    @Override
    public String toString() {
        return "FLuser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}//end of FLuser class
