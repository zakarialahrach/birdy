package com.example.demo.Models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.jws.soap.SOAPBinding.Use;
import javax.persistence.Entity;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.MessageRepository;
import com.example.demo.Repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository usr;

	JsonArrayBuilder arrayBuilder;

	public void UserService() {
		
	}
	
	public void init() {
		User u = new User();
		u.setNom("aa");
		u.setPassword("aa");
		ajoutUsr(u);

		User u2 = new User();
		u2.setNom("bb");
		u2.setPassword("bb");
		ajoutUsr(u2);
	}
	public void ajoutUsr(User u) {
		usr.save(u);
	}

	public boolean checkUsr(String nom, String password) {
		System.out.println("ana fchkuser");
		ArrayList<User> source = (ArrayList<User>) usr.findAll();
		System.out.println(source.toString()+" size = "+source.size());

		for (Iterator<User> it = source.iterator(); it.hasNext();) {
			User u = it.next();
			System.out.println("nom = "+u.getNom());
			if (u.getNom().equals(nom) && u.getPassword().equals(password)) {
					return true;
					
			}
		}

		return false;

	}

}
