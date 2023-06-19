package com.example.demau.repo.models;

public class Class {
    Integer id;
    String name, des;

    public Class(Integer id, String name, String des) {
        this.id = id;
        this.name = name;
        this.des = des;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
