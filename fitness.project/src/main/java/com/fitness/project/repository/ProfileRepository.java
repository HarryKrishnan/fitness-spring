package com.fitness.project.repository;

import com.fitness.project.entities.UserProfile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<UserProfile, String> {


}
