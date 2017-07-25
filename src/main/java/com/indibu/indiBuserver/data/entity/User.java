package com.indibu.indiBuserver.data.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Set;
import com.indibu.indiBuserver.data.entity.Coupon;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Column(unique = true)
    @NotNull
    private String nickName;

    @Column(unique = true)
    @NotNull
    private String email;

    @NotNull
    private String password;
    private String photoUrl;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<String> interests;
    private PersonalInfo personalInfo;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Coupon> couponList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Deal> dealList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Reference> referenceList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<BankAccount> bankAccountList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Long> hotVotedCouponIds;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Long> hotVotedDealIds;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Long> coldVotedCouponIds;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Long> coldVotedDealIds;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    public Set<String> getInterests() {
        return interests;
    }

    public void setInterests(Set<String> interests) {
        this.interests = interests;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
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

    public Set<Long> getHotVotedCouponIds() {
        return hotVotedCouponIds;
    }

    public void setHotVotedCouponIds(Set<Long> hotVotedCouponIds) {
        this.hotVotedCouponIds = hotVotedCouponIds;
    }

    public Set<Long> getHotVotedDealIds() {
        return hotVotedDealIds;
    }

    public void setHotVotedDealIds(Set<Long> hotVotedDealIds) {
        this.hotVotedDealIds = hotVotedDealIds;
    }

    public Set<Long> getColdVotedCouponIds() {
        return coldVotedCouponIds;
    }

    public void setColdVotedCouponIds(Set<Long> coldVotedCouponIds) {
        this.coldVotedCouponIds = coldVotedCouponIds;
    }

    public Set<Long> getColdVotedDealIds() {
        return coldVotedDealIds;
    }

    public void setColdVotedDealIds(Set<Long> coldVotedDealIds) {
        this.coldVotedDealIds = coldVotedDealIds;
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
