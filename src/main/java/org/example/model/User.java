package org.example.model;

import java.util.List;

public class User {
    private Integer id;
    private String name;
    private List<Girl> girls;
    private List<Car> cars;

    public User() {
    }

    public User(Integer id, String name, List<Girl> girls, List<Car> cars) {
        this.id = id;
        this.name = name;
        this.girls = girls;
        this.cars = cars;
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


    public List<Girl> getGirls() {
        return girls;
    }

    public void setGirls(List<Girl> girls) {
        this.girls = girls;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}


