package com.example.demo.Controller;


import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException;  
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
import java.util.ArrayList; 
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Models.Userr;  
@Controller
public class UserrController { 
	@GetMapping("/lon")
   public  List<Userr> getAllUserrs(){ 
      
      List<Userr> UserrList = null; 
      try { 
         File file = new File("Userrs.dat"); 
         if (!file.exists()) { 
            Userr Userr = new Userr(1, "Mahesh", "Teacher"); 
            UserrList = new ArrayList<Userr>(); 
            UserrList.add(Userr); 
            saveUserrList(UserrList); 
         } 
         else{ 
            FileInputStream fis = new FileInputStream(file); 
            ObjectInputStream ois = new ObjectInputStream(fis); 
            UserrList = (List<Userr>) ois.readObject(); 
            ois.close(); 
         } 
      } catch (IOException e) { 
         e.printStackTrace(); 
      } catch (ClassNotFoundException e) { 
         e.printStackTrace(); 
      }   
      return UserrList; 
   } 
   private void saveUserrList(List<Userr> UserrList){ 
      try { 
         File file = new File("Userrs.dat"); 
         FileOutputStream fos;  
         fos = new FileOutputStream(file); 
         ObjectOutputStream oos = new ObjectOutputStream(fos); 
         oos.writeObject(UserrList); 
         oos.close(); 
      } catch (FileNotFoundException e) { 
         e.printStackTrace(); 
      } catch (IOException e) { 
         e.printStackTrace(); 
      } 
   }    
}