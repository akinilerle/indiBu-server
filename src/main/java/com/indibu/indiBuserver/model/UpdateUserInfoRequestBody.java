package com.indibu.indiBuserver.model;

public class UpdateUserInfoRequestBody {

    private String firstName;
    private String lastName;
    private String oldPassword;
    private String newPassword;
    private boolean electronics;
    private boolean clothing;
    private boolean food;
    private boolean cosmetics;

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

    public boolean isElectronics() {
        return electronics;
    }

    public void setElectronics(boolean electronics) {
        this.electronics = electronics;
    }

    public boolean isClothing() {
        return clothing;
    }

    public void setClothing(boolean clothing) {
        this.clothing = clothing;
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
}
