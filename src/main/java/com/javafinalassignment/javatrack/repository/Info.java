package com.javafinalassignment.javatrack.repository;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


public class Info {


    private String unique_code;


    private String email;
    private String jobRole;

    public Info(String unique_code,String email,String jobRole)
    {
        this.email=email;
        this.unique_code=unique_code;
        this.jobRole=jobRole;

    }

    public String getUnique_code()
    {
        return unique_code;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public void setUnique_code(String unique_code)
    {
        this.unique_code = unique_code;
    }

    public String getEmail()
    {

        return email;
    }

    public void setEmail(String email)
    {

        this.email = email;
    }

}
