package com.fitness.project.entities;


import com.fitness.project.domain.UserDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class User {

    @Column(name="username")
    @Id
    private String userName;

    @Column(name="password")
    private String passWord;

    public User(){

    }
    public User(UserDto userDto){
        this.userName = userDto.getEmail();
        this.passWord = userDto.getPassword();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

}
