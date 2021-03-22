package com.example.itsresttime.models;

import org.springframework.stereotype.Component;

@Component
public class StuTeaRelation {

    private String name;
    private String course;

    public StuTeaRelation(String name, String course) {
        this.name = name;
        this.course = course;
    }

    public StuTeaRelation() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
