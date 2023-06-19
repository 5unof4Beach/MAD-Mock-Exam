package com.example.demau.repo.models;

public class Student {
    Integer id, year;
    String name, dob, home;

    public Student(Integer id, String name, String dob, String home, Integer year) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.home = home;
        this.year = year;
    }

    public Student(String name, String dob, String home,Integer year) {
        this.year = year;
        this.name = name;
        this.dob = dob;
        this.home = home;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", year=" + year +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", home='" + home + '\'' +
                '}';
    }
}
