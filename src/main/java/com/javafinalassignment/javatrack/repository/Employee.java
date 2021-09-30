package com.javafinalassignment.javatrack.repository;

import com.javafinalassignment.javatrack.entity.User;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.lang.String;



@Entity
@Table(name="employee")
public class Employee extends User {

    @Id
    private String code;

    @Column
    private String generated_email;

    @Column
    private String employment_type;

    @Column
    private String notice_period;

    @Column
    private String end_period;

    @Column
    private String job_type;



    public Employee()
    {

    }

    public Employee(String first_name, String last_name, String address, Long pincode, String state, String city, Long primary_contact_number, Long secondary_contact_number, Integer experience, String year_graduation, String previous_company, String year_post_graduation, String degree_graduation, String degree_post_graduation, String college_of_graduation, String college_of_post_graduation, String date_of_join, String month_of_join, String year_of_join,String generated_email,String code,String employment_type,String notice_period,String end_period,String job_type)
    {
        super(first_name, last_name, address, pincode, state, city, primary_contact_number, secondary_contact_number, experience, year_graduation, previous_company, year_post_graduation, degree_graduation, degree_post_graduation, college_of_graduation, college_of_post_graduation, date_of_join, month_of_join, year_of_join);
       this.generated_email=generated_email;
       this.code=code;
       this.employment_type=employment_type;
       this.notice_period=notice_period;
       this.end_period=end_period;
       this.job_type=job_type;

    }

    public String getJob_type() {
        return job_type;
    }

    public void setJob_type(String job_type) {
        this.job_type = job_type;
    }

    public String getEnd_period() {
        return end_period;
    }

    public void setEnd_period(String end_period) {
        this.end_period = end_period;
    }

    public String getEmployment_type() {
        return employment_type;
    }

    public String getNotice_period() {
        return notice_period;
    }

    public void setNotice_period(String notice_period) {
        this.notice_period = notice_period;
    }

    public void setEmployment_type(String employment_type) {
        this.employment_type = employment_type;
    }


    public String getGenerated_email() {
        return generated_email;
    }

    public void setGenerated_email(String generated_email) {
        this.generated_email = generated_email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

