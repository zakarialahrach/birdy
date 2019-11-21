package com.example.demo.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Liike {
	private String nomUsr;
	private String idMsg;
@Id
	private String id = UUID.randomUUID().toString();
@ManyToOne(fetch = FetchType.LAZY)
@Cascade({CascadeType.SAVE_UPDATE, CascadeType.MERGE, CascadeType.REFRESH})
private Message message;
//@OneToMany(fetch=FetchType.LAZY,mappedBy="idMsg")//␣il␣faut␣indiquer␣le␣type␣de␣la␣classe␣parent␣dans␣mappedBy,etnonlapropriete␣id
//@Cascade({CascadeType.REMOVE})//␣permet␣de␣supprimer␣en␣cascade␣les␣liikes␣associes	    
//        private List<Liike> likes = new ArrayList<>();

	public Liike() {
		
	}
	public String getnomUsr() {
		return nomUsr;
	}
	public void setnomUsr(String nom) {
		this.nomUsr = nom;
	}
	public String getIdMsg() {
		return idMsg;
	}
	public void setidMsg(String msg) {
		this.idMsg = msg;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}