package com.javafinalassignment.javatrack.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class User {

    private String first_name;
    private String last_name;
    private String address;
    private Long pincode;
    private String state;
    private String city;
    private Long primary_contact_number;
    private Long secondary_contact_number;
    private Integer experience;
    private String previous_company;
    private String year_graduation;
    private String year_post_graduation;
    private String degree_graduation;
    private String degree_post_graduation;
    private String college_of_graduation;
    private String college_of_post_graduation;
    private String date_of_join;
    private String month_of_join;
    private String year_of_join;

    public User()
    {

    }
    public User(String first_name,String last_name,String address,Long pincode,String state,String city,Long primary_contact_number,Long secondary_contact_number,Integer experience,String year_graduation, String previous_company,String year_post_graduation,String degree_graduation,String degree_post_graduation,String college_of_graduation,String college_of_post_graduation,String date_of_join,String month_of_join,String year_of_join)
    {
        this.first_name=first_name;
        this.last_name=last_name;
        this.address=address;
        this.pincode=pincode;
        this.state=state;
        this.city=city;
        this.primary_contact_number=primary_contact_number;
        this.secondary_contact_number=secondary_contact_number;
        this.experience=experience;
        this.previous_company=previous_company;
        this.year_graduation=year_graduation;
        this.year_post_graduation=year_post_graduation;
        this.degree_graduation=degree_graduation;
        this.degree_post_graduation=degree_post_graduation;
        this.college_of_graduation=college_of_graduation;
        this.college_of_post_graduation=college_of_post_graduation;
        this.date_of_join=date_of_join;
        this.month_of_join=month_of_join;
        this.year_of_join=year_of_join;



    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPincode() {
        return pincode;
    }

    public void setPincode(Long pincode) {
        this.pincode = pincode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getPrimary_contact_number() {
        return primary_contact_number;
    }

    public void setPrimary_contact_number(Long primary_contact_number) {
        this.primary_contact_number = primary_contact_number;
    }

    public Long getSecondary_contact_number() {
        return secondary_contact_number;
    }

    public void setSecondary_contact_number(Long secondary_contact_number) {
        this.secondary_contact_number = secondary_contact_number;
    }

    public String getPrevious_company() {
        return previous_company;
    }

    public void setPrevious_company(String previous_company) {
        this.previous_company = previous_company;
    }

    public String getYear_graduation() {
        return year_graduation;
    }

    public void setYear_graduation(String year_graduation) {
        this.year_graduation = year_graduation;
    }

    public String getYear_post_graduation() {
        return year_post_graduation;
    }

    public void setYear_post_graduation(String year_post_graduation) {
        this.year_post_graduation = year_post_graduation;
    }

    public String getDegree_graduation() {
        return degree_graduation;
    }

    public void setDegree_graduation(String degree_graduation) {
        this.degree_graduation = degree_graduation;
    }

    public String getDegree_post_graduation() {
        return degree_post_graduation;
    }

    public void setDegree_post_graduation(String degree_post_graduation) {
        this.degree_post_graduation = degree_post_graduation;
    }

    public String getCollege_of_graduation() {
        return college_of_graduation;
    }

    public void setCollege_of_graduation(String college_of_graduation) {
        this.college_of_graduation = college_of_graduation;
    }

    public String getCollege_of_post_graduation() {
        return college_of_post_graduation;
    }

    public void setCollege_of_post_graduation(String college_of_post_graduation) {
        this.college_of_post_graduation = college_of_post_graduation;
    }

    public String getDate_of_join() {
        return date_of_join;
    }

    public void setDate_of_join(String date_of_join) {
        this.date_of_join = date_of_join;
    }

    public String getMonth_of_join() {
        return month_of_join;
    }

    public void setMonth_of_join(String month_of_join) {
        this.month_of_join = month_of_join;
    }

    public String getYear_of_join() {
        return year_of_join;
    }

    public void setYear_of_join(String year_of_join) {
        this.year_of_join = year_of_join;
    }
}
