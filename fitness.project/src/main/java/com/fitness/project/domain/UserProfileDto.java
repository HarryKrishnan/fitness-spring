package com.fitness.project.domain;

import java.util.Objects;

public class UserProfileDto {

    private String name;

    private String email;

    private String password;

    private Integer age;

    private Integer height;

    private Integer weight;

    private Integer bmi;

    private Integer calories;

    private String activity;

    private String picture;

    private Integer waterintaketarget;

    private Integer  waterconsumed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getWaterconsumed() {
        return waterconsumed;
    }

    public void setWaterconsumed(Integer waterconsumed) {
        this.waterconsumed = waterconsumed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfileDto that = (UserProfileDto) o;
        return Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(age, that.age) && Objects.equals(height, that.height) && Objects.equals(weight, that.weight) && Objects.equals(bmi, that.bmi) && Objects.equals(calories, that.calories) && Objects.equals(activity, that.activity) && Objects.equals(picture, that.picture) && Objects.equals(waterintaketarget, that.waterintaketarget) && Objects.equals(waterconsumed, that.waterconsumed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, password, age, height, weight, bmi, calories, activity, picture, waterintaketarget, waterconsumed);
    }

    @Override
    public String toString() {
        return "UserProfileDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", bmi=" + bmi +
                ", calories=" + calories +
                ", activity='" + activity + '\'' +
                ", picture='" + picture + '\'' +
                ", waterintaketarget=" + waterintaketarget +
                ", waterconsumed=" + waterconsumed +
                '}';
    }
}
