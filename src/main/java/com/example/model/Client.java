package com.example.model;

import java.util.List;

public class Client {

    private String name;
    private List<Project> projects;

    public List<Project> getProjects() {
        return projects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
