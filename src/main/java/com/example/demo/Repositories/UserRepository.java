package com.example.demo.Repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Models.User;


public interface UserRepository extends CrudRepository<User,String>
{
	User findUserByNomAndPassword(String nom,String password);
	
}