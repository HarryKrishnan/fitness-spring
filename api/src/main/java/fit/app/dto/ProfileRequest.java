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
    private double waterIntakeTarget;  // in ml
    private double waterConsumed;
    private String passWord;

    public String getEmail() {
        return email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public double getWaterConsumed() {
        return waterConsumed;
    }

    public void setWaterConsumed(double waterConsumed) {
        this.waterConsumed = waterConsumed;
    }
}
