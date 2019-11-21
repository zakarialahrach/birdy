package com.example.demo.Models;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement; 
import javax.xml.bind.annotation.XmlRootElement; 
@Entity
public class Userr implements Serializable {  
   private static final long serialVersionUID = 1L; 
   @Id
   private int id; 
   private String name; 
   private String profession;  
   public Userr(){} 
    
   public Userr(int id, String name, String profession){  
      this.id = id; 
      this.name = name; 
      this.profession = profession; 
   }  
   public int getId() { 
      return id; 
   }  
   @XmlElement 
   public void setId(int id) { 
      this.id = id; 
   } 
   public String getName() { 
      return name; 
   } 
   @XmlElement
   public void setName(String name) { 
      this.name = name; 
   } 
   public String getProfession() { 
      return profession; 
   } 
   @XmlElement 
   public void setProfession(String profession) { 
      this.profession = profession; 
   }   
}