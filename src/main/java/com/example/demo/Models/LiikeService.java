package com.example.demo.Models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.LiikeRepository;

@Service
public class LiikeService {
	JsonArrayBuilder arrayBuilder;
	
	@Autowired
	private HttpSession httpSession; // recupere la session en cours
	@Autowired
	LiikeRepository lk;
	public LiikeService(){
		
	}
	
	
	public JsonObjectBuilder AjoutLike(String nom, String msg){
		Liike l = new Liike();
		l.setnomUsr(nom);
		l.setidMsg(msg);
		lk.save(l);
		JsonObjectBuilder objectBuilder2 = Json.createObjectBuilder(); // C o n s t r u i t un o b j e t j s o n
		
		int nbJaime = lk.findLiikeByidMsg(msg).size();
				objectBuilder2.add("nbJaime", nbJaime);
		objectBuilder2.add("nom", nom);
		//arrayBuilder.add(objectBuilder2);
				return objectBuilder2;
	}
	
	public String getNbLiike(String id){
		String nbJaime = String.valueOf(lk.findLiikeByidMsg(id).size());
				
				return nbJaime;
	}
	
	public JsonArrayBuilder getlikesJson() {
		System.out.println("fgetlikesJson");
		 arrayBuilder = Json.createArrayBuilder(); 
		JsonObjectBuilder objectBuilder = Json.createObjectBuilder(); 
		 List<Liike> likesL = (List<Liike>) lk.findAll();			
			for( Liike l : likesL) {
				objectBuilder.add(l.getIdMsg(), l.getnomUsr());
			
				arrayBuilder.add(objectBuilder);
			}
		return arrayBuilder;
		}
	
	public boolean checkUsr(String nom, String id) {
	
	    	   if(lk.findLiikeByIdMsgAndNomUsr(id, nom) != null) {
	    		   return false;
	    	
	    	 }
	       else {
			return true;
	       }
		}


	public JsonObjectBuilder deleteLiike(String nom, String jaime) {
		lk.deleteLiikeByNomUsrAndIdMsg(nom,jaime);
		JsonObjectBuilder objectBuilder2 = Json.createObjectBuilder();
		int nbJaime = lk.findLiikeByidMsg(jaime).size();
		objectBuilder2.add("nbJaime", nbJaime);
		objectBuilder2.add("nom", nom);
		
		return objectBuilder2;
	}
	
	}
	
