package com.example.demo.Models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
@Entity
public class User {
	@Id
	private String nom;
	private String password;
	

	//␣attention␣aux␣dependances␣!!
	
//	@ManyToOne(fetch=FetchType.LAZY)
//	@Cascade({CascadeType.SAVE_UPDATE,CascadeType.MERGE,CascadeType.REFRESH})//␣mise␣a␣jour␣des␣liikes␣du␣message
//	private Message id;
//	 
//	@OneToMany(fetch=FetchType.LAZY,mappedBy="id")//␣il␣faut␣indiquer␣le␣type␣de␣la␣classe␣parent␣dans␣mappedBy,etnonlapropriete␣id
//	@Cascade({CascadeType.REMOVE})//␣permet␣de␣supprimer␣en␣cascade␣les␣liikes␣associes
//	private Set<Liike>likes=new HashSet<Liike>(0);
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
