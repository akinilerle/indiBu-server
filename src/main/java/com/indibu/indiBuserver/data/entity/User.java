package com.indibu.indiBuserver.data.entity;

import com.indibu.indiBuserver.model.Category;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfCreation;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfUpdate;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Column(unique = true)
    @NotNull
    private String nickname;

    @Column(unique = true)
    @NotNull
    private String email;

    @NotNull
    private String password;

    private String photoUrl;

    private double averageRating;

    private int reviewNumberCounter;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    List<Message> newMessageList;

    @ElementCollection
    @CollectionTable(name = "User_interest", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Category> interestSet;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Coupon> couponList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Deal> dealList;

    @ElementCollection
    @CollectionTable(name = "User_reference", joinColumns = @JoinColumn(name = "user_id"))
    private List<Reference> referenceList;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<BankAccount> bankAccountList;

    @ElementCollection
    @CollectionTable(name = "User_hotVotedCoupon", joinColumns = @JoinColumn(name = "user_id"))
    private Set<Long> hotVotedCouponIdSet;

    @ElementCollection
    @CollectionTable(name = "User_hotVotedDeal", joinColumns = @JoinColumn(name = "user_id"))
    private Set<Long> hotVotedDealIdSet;

    @ElementCollection
    @CollectionTable(name = "User_coldVotedCoupon", joinColumns = @JoinColumn(name = "user_id"))
    private Set<Long> coldVotedCouponIdSet;

    @ElementCollection
    @CollectionTable(name = "User_coldVotedDeal", joinColumns = @JoinColumn(name = "user_id"))
    private Set<Long> coldVotedDealIdSet;

    public void addReference(Reference reference) {
        referenceList.add(reference);
        averageRating = ((averageRating * reviewNumberCounter) + reference.getRating().ordinal()) / (reviewNumberCounter + 1);
        reviewNumberCounter++;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Set<Category> getInterestSet() {
        return interestSet;
    }

    public void setInterestSet(Set<Category> interestSet) {
        this.interestSet = interestSet;
    }

    public List<Deal> getDealList() {
        return dealList;
    }

    public void setDealList(List<Deal> dealList) {
        this.dealList = dealList;
    }

    public List<BankAccount> getBankAccountList() {
        return bankAccountList;
    }

    public void setBankAccountList(List<BankAccount> bankAccountList) {
        this.bankAccountList = bankAccountList;
    }

    public Set<Long> getHotVotedCouponIdSet() {
        return hotVotedCouponIdSet;
    }

    public void setHotVotedCouponIdSet(Set<Long> hotVotedCouponIdSet) {
        this.hotVotedCouponIdSet = hotVotedCouponIdSet;
    }

    public List<Message> getNewMessageList() {
        return newMessageList;
    }

    public void setNewMessageList(List<Message> newMessageList) {
        this.newMessageList = newMessageList;
    }

    public Set<Long> getHotVotedDealIdSet() {
        return hotVotedDealIdSet;
    }

    public void setHotVotedDealIdSet(Set<Long> hotVotedDealIdSet) {
        this.hotVotedDealIdSet = hotVotedDealIdSet;
    }

    public Set<Long> getColdVotedCouponIdSet() {
        return coldVotedCouponIdSet;
    }

    public void setColdVotedCouponIdSet(Set<Long> coldVotedCouponIdSet) {
        this.coldVotedCouponIdSet = coldVotedCouponIdSet;
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

    public Set<Long> getColdVotedDealIdSet() {
        return coldVotedDealIdSet;
    }

    public void setColdVotedDealIdSet(Set<Long> coldVotedDealIdSet) {
        this.coldVotedDealIdSet = coldVotedDealIdSet;
    }

    public List<Coupon> getCouponList() {
        return couponList;
    }

    public void setCouponList(List<Coupon> couponList) {
        this.couponList = couponList;
    }

    public List<Reference> getReferenceList() {
        return referenceList;
    }

    public void setReferenceList(List<Reference> referenceList) {
        this.referenceList = referenceList;
    }


}
