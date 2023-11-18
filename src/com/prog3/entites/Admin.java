package com.prog3.entites;

public class Admin extends User {
    private String adminRole; 

    // Constructeur 
    public Admin(int userId, String username, String password, String adminRole) {
        super(userId, username, password); 
        this.adminRole = adminRole; 
    }

    // Getter et setter 
    public String getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(String adminRole) {
        this.adminRole = adminRole;
    }
    @Override
    public String toString() {
        return "Admin{" +
                "username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", adminRole='" + adminRole + '\'' +
                '}';
    }
}
