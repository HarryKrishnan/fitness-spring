package com.fitness.project.repository;

import com.fitness.project.entities.User;
import com.fitness.project.entities.UserProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends CrudRepository<User,String> {

}
