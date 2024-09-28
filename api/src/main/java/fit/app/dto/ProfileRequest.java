package fit.app.dto;

public class ProfileRequest {

    private String email;
    private String name;
    private int age;
    private double height;  // in cm
    private double weight;  // in kg
    private double bmi;
    private int calories;   // calories per day
    private String activity;
    private String picture;  // can be a URL or a file path
    private double waterintaketarget;  // in ml
    private double waterconsumed;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassWord() {
        return password;
    }


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

    public void setEmail(String email) {
        this.email = email;
    }

    public double getWaterintaketarget() {
        return waterintaketarget;
    }

    public void setWaterintaketarget(double waterintaketarget) {
        this.waterintaketarget = waterintaketarget;
    }

    public double getWaterconsumed() {
        return waterconsumed;
    }

    public void setWaterconsumed(double waterconsumed) {
        this.waterconsumed = waterconsumed;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }


}
