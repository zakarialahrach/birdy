package com.example.demo.Controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.DemoApplication;

@Controller
public class TwitterController {
	@Autowired
	private HttpSession httpSession; // recupere la session en cours

	@GetMapping("/twitter")
	public String index(Model model) {
		String sessionUser= (String) httpSession.getAttribute("user") ; // check l ' utilisateur ␣en␣cours
		
		if( sessionUser != null && !sessionUser.isEmpty()) {
			model.addAttribute("nom", sessionUser);
			return "twitter";
		}
			
		else
				return "login"; // equivalent du forward
		}
	}

