package com.fitness.project.service;

import com.fitness.project.domain.UserDto;
import com.fitness.project.domain.UserProfileDto;
import com.fitness.project.entities.User;
import com.fitness.project.entities.UserProfile;
import com.fitness.project.repository.LoginRepository;
import com.fitness.project.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private ProfileRepository profileRepository;

    public User getUserForLogin(UserDto user) throws Exception {
        User userObject = loginRepository.findById(user.getEmail()).orElseThrow(()->new Exception("No User found"));
        return userObject;
    }

    public String createUserProfile(UserProfileDto userProfileDto){
        UserDto userDto =new UserDto(userProfileDto.getEmail(),userProfileDto.getPassword());
        createUser(userDto);
        sendPassword(userDto.getPassword());
        UserProfile profile = profileRepository.save(new UserProfile(userProfileDto));
        if(Objects.nonNull(profile)){
            return "Profile Created please check inbox for password";
        }
        else{
            return "Profile Creation Failed";
        }

    }

    public User createUser(UserDto userDto){
       return loginRepository.save(new User(userDto));
    }

    public UserProfile getUserProfile(String emailId) throws Exception {
        UserProfile userProfile =profileRepository.findById(emailId).orElseThrow(()->new Exception("No profile found"));
        return userProfile;
    }

    public void sendPassword(String password){

    }

}
