package com.example.demo.Models;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Controller.UserrController;  
@Service
public class UserrService {  
	UserrController userDao = new UserrController();  

   public List<Userr> getUsers(){ 
      return userDao.getAllUserrs(); 
   }  
}