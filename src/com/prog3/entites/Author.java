package com.prog3.entites;

public class Author {
    private String id;
    private String name;
    private String sex;
    
    public Author(String id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }
    // Getters and setters 
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    @Override
    public String toString() {
        return "Author{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
