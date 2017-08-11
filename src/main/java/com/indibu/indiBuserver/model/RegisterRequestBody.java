package com.indibu.indiBuserver.model;

import java.util.Set;

public class RegisterRequestBody {

    private String firstName;
    private String lastName;
    private String email;
    private String nickname;
    private String password;
    private boolean electronics;
    private boolean food;
    private boolean clothing;
    private boolean cosmetics;
    private Set<Category> interestSet;

    public Set<Category> getInterestSet() {
        return interestSet;
    }

    public void setInterestSet(Set<Category> interestSet) {
        this.interestSet = interestSet;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isElectronics() {
        return electronics;
    }

    public void setElectronics(boolean electronics) {
        this.electronics = electronics;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isClothing() {
        return clothing;
    }

    public void setClothing(boolean clothing) {
        this.clothing = clothing;
    }

    public boolean isCosmetics() {
        return cosmetics;
    }

    public void setCosmetics(boolean cosmetics) {
        this.cosmetics = cosmetics;
    }
}
