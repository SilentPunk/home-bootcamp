package com.example.homebootcamp.repository;

import com.example.homebootcamp.persistence.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
