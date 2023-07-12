package com.example.SampleSpringBoot.RestAPI.Repo;

import com.example.SampleSpringBoot.RestAPI.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long > {

}
