package com.fitness.project;

import com.fitness.project.domain.UserDto;
import com.fitness.project.domain.UserProfileDto;
import com.fitness.project.entities.User;
import com.fitness.project.entities.UserProfile;
import com.fitness.project.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FitnessController {


    @Autowired
    private ProfileService profileService;

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody UserDto userDto) throws Exception {
        return ResponseEntity.ok(profileService.getUserForLogin(userDto));
    }

    @CrossOrigin
    @PostMapping("/user")
    public ResponseEntity<String> createProfile(@RequestBody UserProfileDto userProfileDto) {
        return ResponseEntity.ok(profileService.createUserProfile(userProfileDto));
    }

    @CrossOrigin
    @GetMapping("/profile")
    public ResponseEntity<UserProfile> getprofile(@RequestParam String email) throws Exception {
        return ResponseEntity.ok(profileService.getUserProfile(email));
    }
}
