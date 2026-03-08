package com.example.Momskitchen.Repositories;

import com.example.Momskitchen.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


//The jpa repository will allow us to use all pre-defined method crub method ex:- save
//findbyId and findall etc these type of methods can be available directly to the user.
public interface UserRepo extends JpaRepository<User,Integer> {
}
