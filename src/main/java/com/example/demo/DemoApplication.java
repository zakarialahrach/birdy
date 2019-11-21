package com.example.demo;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Models.MessageService;
import com.example.demo.Models.User;
import com.example.demo.Models.UserService;
import com.example.demo.Models.LiikeService;

//import com.example.demo.Models.MessageService;

@SpringBootApplication
public class DemoApplication {
	public static MessageService msgs = new MessageService();
	public static UserService usrs = new UserService();
		public static LiikeService likes = new LiikeService();

	//public static MessageService messageService;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
	}
}
