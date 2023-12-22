package org.example.model;

public class Girl {
    private Integer id;
    private String name;
    private Integer age;
    private Integer userId;

    public Girl(Integer id, String name, Integer age, Integer userId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.userId = userId;
    }

    public Girl() {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
