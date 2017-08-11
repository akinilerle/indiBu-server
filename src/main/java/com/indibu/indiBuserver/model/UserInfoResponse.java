package com.indibu.indiBuserver.model;

import com.indibu.indiBuserver.data.entity.User;

import java.util.Date;
import java.util.Set;

public class UserInfoResponse {

    private Date dateOfCreation;
    private Date dateOfUpdate;
    private String firstName;
    private String lastName;
    private String nickname;
    private String email;
    private boolean electronics;
    private boolean food;
    private boolean clothing;
    private boolean cosmetics;
    private double averageRating;
    private Set<Category> interestSet;
    private int reviewNumberCounter;


    public UserInfoResponse() {
    }

    public UserInfoResponse(User user) {

        dateOfCreation = user.getDateOfCreation();
        dateOfUpdate = user.getDateOfUpdate();
        firstName = user.getFirstName();
        lastName = user.getLastName();
        nickname = user.getNickname();
        email = user.getEmail();
        averageRating = user.getAverageRating();
        reviewNumberCounter = user.getReviewNumberCounter();
        Set<Category> interestSet = user.getInterestSet();
        electronics = interestSet.contains(Category.ELECTRONICS);
        food = interestSet.contains(Category.FOOD);
        clothing = interestSet.contains(Category.CLOTHING);
        cosmetics = interestSet.contains(Category.COSMETICS);

    }

    public static UserInfoResponse userInfoFactory(User user) {

        UserInfoResponse infoResponse = new UserInfoResponse();

        infoResponse.firstName = user.getFirstName();
        infoResponse.lastName = user.getLastName();
        infoResponse.nickname = user.getNickname();
        infoResponse.averageRating = user.getAverageRating();
        infoResponse.reviewNumberCounter = user.getReviewNumberCounter();

        return infoResponse;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public Date getDateOfUpdate() {
        return dateOfUpdate;
    }

    public void setDateOfUpdate(Date dateOfUpdate) {
        this.dateOfUpdate = dateOfUpdate;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public int getReviewNumberCounter() {
        return reviewNumberCounter;
    }

    public void setReviewNumberCounter(int reviewNumberCounter) {
        this.reviewNumberCounter = reviewNumberCounter;
    }

    public Set<Category> getInterestSet() {
        return interestSet;
    }

    public void setInterestSet(Set<Category> interestSet) {
        this.interestSet = interestSet;
    }
}
