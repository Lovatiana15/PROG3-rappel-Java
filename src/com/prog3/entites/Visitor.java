package com.prog3.entites;

public class Visitor extends User {
    private String matriculeNumber; 

    // Constructeur 
    public Visitor(int userId, String username, String password, String matriculeNumber) {
        super(userId, username, password);
        this.matriculeNumber = matriculeNumber; 
    }

    // Getter et setter 
    public String getMatriculeNumber() {
        return matriculeNumber;
    }

    public void setMatriculeNumber(String matriculeNumber) {
        this.matriculeNumber = matriculeNumber;
    }
    @Override
    public String toString() {
        return "Visitor{" +
                "username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", matriculeNumber='" + matriculeNumber + '\'' +
                '}';
    }
}
