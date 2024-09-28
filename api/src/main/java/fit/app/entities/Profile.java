package fit.app.entities;

import fit.app.dto.ProfileRequest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Profile {

    @Id
    private String email;
    private String name;
    private int age;
    private double height;  // in cm
    private double weight;  // in kg
    private double bmi;
    private int calories;   // calories per day
    private String activity;
    private String picture;  // can be a URL or a file path
    @Column(name = "waterintaketarget")// in ml
    private double waterIntakeTarget;
    @Column(name = "waterconsumed")// in ml
    private double waterConsumed;

    public Profile() {
    }

    public Profile(ProfileRequest profileRequest) {
        this.email = profileRequest.getEmail();
        this.name = profileRequest.getName();
        this.age = profileRequest.getAge();
        this.height = profileRequest.getHeight();
        this.weight = profileRequest.getWeight();
        this.bmi = profileRequest.getBmi();
        this.calories = profileRequest.getCalories();
        this.activity = profileRequest.getActivity();
        this.picture = profileRequest.getPicture();
        this.waterIntakeTarget = profileRequest.getWaterintaketarget();
        this.waterConsumed = profileRequest.getWaterconsumed();
    }

    // Getters and Setters
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
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

    public double getWaterIntakeTarget() {
        return waterIntakeTarget;
    }

    public void setWaterIntakeTarget(double waterIntakeTarget) {
        this.waterIntakeTarget = waterIntakeTarget;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", bmi=" + bmi +
                ", calories=" + calories +
                ", activity='" + activity + '\'' +
                ", picture='" + picture + '\'' +
                ", waterIntakeTarget=" + waterIntakeTarget +
                ", waterConsumed=" + waterConsumed +
                '}';
    }

    public double getWaterConsumed() {
        return waterConsumed;
    }

    public void setWaterConsumed(double waterConsumed) {
        this.waterConsumed = waterConsumed;
    }

    // Utility to calculate BMI if not provided
    public void calculateBmi() {
        if (height > 0 && weight > 0) {
            this.bmi = weight / ((height / 100) * (height / 100));
        }
    }
}
