package com.example.springmaven.dto;

import lombok.*;


import java.util.Date;


public class UserDTO {

    private Long id;
    private String nameUser;
    private String addressUser;
    private String phoneUser;
    private Date birthdayUser;
    private String statusObject = "on";

    public UserDTO() {
    }

    public UserDTO(Long id, String nameUser, String addressUser, String phoneUser, Date birthdayUser, String statusObject) {
        this.id = id;
        this.nameUser = nameUser;
        this.addressUser = addressUser;
        this.phoneUser = phoneUser;
        this.birthdayUser = birthdayUser;
        this.statusObject = statusObject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getAddressUser() {
        return addressUser;
    }

    public void setAddressUser(String addressUser) {
        this.addressUser = addressUser;
    }

    public String getPhoneUser() {
        return phoneUser;
    }

    public void setPhoneUser(String phoneUser) {
        this.phoneUser = phoneUser;
    }

    public Date getBirthdayUser() {
        return birthdayUser;
    }

    public void setBirthdayUser(Date birthdayUser) {
        this.birthdayUser = birthdayUser;
    }

    public String getStatusObject() {
        return statusObject;
    }

    public void setStatusObject(String statusObject) {
        this.statusObject = statusObject;
    }
}
