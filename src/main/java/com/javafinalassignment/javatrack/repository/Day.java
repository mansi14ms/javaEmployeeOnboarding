package com.javafinalassignment.javatrack.repository;

public class Day {
    private Integer date_of_leaving;
    private String id;

    public Day(int date_of_leaving, String id) {
        this.date_of_leaving = date_of_leaving;
        this.id = id;
    }

    public Integer getDate_of_leaving()
    {
        return date_of_leaving;
    }

    public void setDate_of_leaving(Integer date_of_leaving)
    {
        this.date_of_leaving = date_of_leaving;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

}