package com.example.demo.Repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Models.Message;


public interface MessageRepository extends CrudRepository<Message,String>
{
	public List<Message> findAllByOrderByDateAsc();
//	 List<Message> findByLastname(String string);
	
}