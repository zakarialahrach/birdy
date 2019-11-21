package com.example.demo.Models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Message {
		private String date;
		private String msg;
		@Id
		private String id = UUID.randomUUID().toString();
//		@ManyToOne(fetch=FetchType.LAZY)
//		@Cascade({CascadeType.SAVE_UPDATE,CascadeType.MERGE,CascadeType.REFRESH})//␣mise␣a␣jour␣des␣liikes␣du␣message
//		private Message message;
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "message")
		@Cascade({CascadeType.REMOVE})
		private Set<Liike> likes = new HashSet<Liike>(0);

	  
		public Message(){
			
		}
		public Message(String msg){
			this.msg = msg;
		}
		
		
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public JsonValue getAuthor() {
			// TODO Auto-generated method stub
			return null;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
		
		public JsonObjectBuilder toJson(){
			JsonObjectBuilder obj = Json.createObjectBuilder();
			obj.add("msg", msg);
			obj.add("id", id);
			obj.add("date", date);
			return obj;
		}
		
	}

