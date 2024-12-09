package com.blogapplication.Repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapplication.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {
     
}
