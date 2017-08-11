package com.indibu.indiBuserver.model;

import java.util.Set;

public class UpdateUserInfoRequestBody {

    private String firstName;
    private String lastName;
    private String oldPassword;
    private String newPassword;
    private boolean electronics;
    private boolean food;
    private boolean cosmetics;
    private boolean clothing;
    private Set<Category> interestSet;

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

    public boolean isCosmetics() {
        return cosmetics;
    }

    public void setCosmetics(boolean cosmetics) {
        this.cosmetics = cosmetics;
    }

    public boolean isClothing() {
        return clothing;
    }

    public void setClothing(boolean clothing) {
        this.clothing = clothing;
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

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public Set<Category> getInterestSet() {
        return interestSet;
    }

    public void setInterestSet(Set<Category> interestSet) {
        this.interestSet = interestSet;
    }
}
