package com.fitness.project.entities;

import com.fitness.project.domain.UserProfileDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="profile")
public class UserProfile {

    @Column(name="name")
    private String name;

    @Column(name="email")
    @Id
    private String email;

    @Column(name="age")
    private Integer age;

    @Column(name="height")
    private Integer height;

    @Column(name="weight")
    private Integer weight;

    @Column(name="bmi")
    private Integer bmi;

    @Column(name="calories")
    private Integer calories;

    @Column(name="activity")
    private String activity;

    @Column(name="picture")
    private String picture;

    @Column(name="waterintaketarget")
    private Integer waterintaketarget;

    @Column(name="waterconsumed")
    private Integer  waterconsumed;

    public UserProfile() {
    }

    public UserProfile(UserProfileDto userProfileDto) {
        this.name = userProfileDto.getName();
        this.age = userProfileDto.getAge();
        this.height = userProfileDto.getHeight();
        this.weight = userProfileDto.getWeight();
        this.bmi = userProfileDto.getBmi();
        this.calories = userProfileDto.getCalories();
        this.activity = userProfileDto.getActivity();
        this.picture = userProfileDto.getPicture();
        this.waterintaketarget = userProfileDto.getWaterintaketarget();
        this.waterconsumed = userProfileDto.getWaterconsumed();
        this.email =userProfileDto.getEmail();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getBmi() {
        return bmi;
    }

    public void setBmi(Integer bmi) {
        this.bmi = bmi;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getWaterintaketarget() {
        return waterintaketarget;
    }

    public void setWaterintaketarget(Integer waterintaketarget) {
        this.waterintaketarget = waterintaketarget;
    }

    public Integer getWaterconsumed() {
        return waterconsumed;
    }

    public void setWaterconsumed(Integer waterconsumed) {
        this.waterconsumed = waterconsumed;
    }
}
