package com.example.demo.Models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import com.example.demo.Models.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Message;
import com.example.demo.Repositories.LiikeRepository;
import com.example.demo.Repositories.MessageRepository;



@Service
public class MessageService{
	
	@Autowired
	MessageRepository ur ;
	
	@Autowired
	LiikeRepository lk;
	
			JsonArrayBuilder arrayBuilder;
	private LinkedHashMap<String,Message> messages = new LinkedHashMap<String,Message >();
		public  MessageService(){		
	}
	 

	  public ArrayList<Message> getAllmsg(){
		  return new ArrayList<Message>(this.messages.values());
	  }
	  
	  public int nbrMsg(){
		  return this.messages.size();
	  }
	  
	  public int indexof(Message m) {
		  int r = 0;
		  for(int i=0;i<messages.size();i++)  
	         {  
	            if(messages.get(i).equals(m))  
	            {  
	               r = i;
	            }  
	         }
		  return r;
	  }
	  
	  public void delMessage(String index) {
		    Object obj = messages.remove(index);
		    
	  }
	 	
	public JsonArrayBuilder getMessagesJson() {
		 arrayBuilder = Json.createArrayBuilder(); 
		 
		 ArrayList<Message> source = (ArrayList<Message>) ur.findAllByOrderByDateAsc();			
			
		 for(Iterator<Message> it = source.iterator();it.hasNext();){
		        Message m = it.next();		
		       
		JsonObjectBuilder objectBuilder = Json.createObjectBuilder(); 
				objectBuilder.add("id",m.getId());
				objectBuilder.add("msg",m.getMsg());
				objectBuilder.add("date",m.getDate());
				arrayBuilder.add(objectBuilder);
		}
		return arrayBuilder;
		}
	
	
	public List<Message> getAllmsgs(){
		Iterator<Message> source = (Iterator<Message>) ur.findAllByOrderByDateAsc();
		List<Message> listDeBeans = new ArrayList<>();
		source.forEachRemaining(listDeBeans::add);
		System.out.println(listDeBeans.size());
	
		return listDeBeans;

	}
	public void AjoutMsgbd(Message m){
		ur.save(m);
	}
	
	public void deleteById(String id) {
		ur.delete(id);
	}
	
}

	 
