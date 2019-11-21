package com.example.demo.Controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jboss.jandex.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DemoApplication;
import com.example.demo.Models.Message;
import com.example.demo.Models.MessageService;
import com.example.demo.Models.UserService;
import com.example.demo.Repositories.LiikeRepository;
import com.example.demo.Repositories.UserRepository;
import com.example.demo.Models.Liike;
import com.example.demo.Models.LiikeService;

//import com.example.demo.Models.MessageService;
//@WebServlet(name = "api", urlPatterns = { "/api" })
@RestController
public class ApiController extends HttpServlet {
	@Autowired
	private HttpSession httpSession; // recupere la session en cours
	private static final long serialVersionUID = 1L;
	@Autowired
	private MessageService msgs = DemoApplication.msgs;
	@Autowired
	private UserService usrs = DemoApplication.usrs;
	@Autowired
	private LiikeService likes = DemoApplication.likes;
	@Autowired
	UserRepository us;
	@Autowired
	LiikeRepository lk;
	
	@RequestMapping(value = "/api", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String doGet(@RequestParam(value = "content", required = false) String content,
	@RequestParam(value = "msgAjt", required = false) String ajtMsg,
	@RequestParam(value = "delById", required = false) String delMsg,
	@RequestParam(value = "usr", required = false) String usr,
	@RequestParam(value = "jaime", required = false) String jaime,
	@RequestParam(value = "pass", required = false) String pass,
	@RequestParam(value = "likess", required = false) String likess,
	@RequestParam(value = "lik", required = false) String lik,
	@RequestParam(value = "charger", required = false) String charger,
	@RequestParam(value = "showlikers", required = false) String showlikers,
	@RequestParam(value = "deconn", required = false) String deconn,
	@RequestParam(value = "id", required = false) String id){
		JsonObjectBuilder obj = null;
		Message ms = null;
		
		if (ajtMsg != null) {
			System.out.println(ajtMsg);
			System.out.println(LocalDateTime.now().toString());
			 ms = new Message();
			ms.setMsg(ajtMsg);
			ms.setDate(LocalDateTime.now().toString());
			msgs.AjoutMsgbd(ms);
			return ms.toJson().build().toString();

			//obj = msgs.addMessage(ms);
		}
		
		else if (charger != null) {
			
			return msgs.getMessagesJson().build().toString();
			 
		}
		else if (likess != null) {
			return likes.getlikesJson().build().toString();
			 
		}
		else if (showlikers != null) {
			String users = "/";

			List<Liike> usersL = lk.findLiikeByIdMsg(showlikers);
			for(Liike user : usersL) {
				users += " "+user.getnomUsr();
			}
			JsonObjectBuilder u =Json.createObjectBuilder();
			u.add("users", users);
			return u.build().toString();
			 
		}
		else if (delMsg != null) {
			msgs.deleteById(delMsg);
			lk.deleteLiikeByIdMsg(delMsg);
		}
		else if (deconn != null) {
			System.out.println("deconnnnnnnnnn");
			this.httpSession.invalidate();			 
		}

		else if (jaime != null) {
			
			String nom = (String) httpSession.getAttribute("user") ;
			if(likes.checkUsr(nom, jaime)) {
			JsonObjectBuilder obj2 =Json.createObjectBuilder();
			obj2 = likes.AjoutLike(nom, jaime);
			// On renvoi le résultat
			return obj2.build().toString();
			}
			else {
				
				JsonObjectBuilder obj2 =Json.createObjectBuilder();
						obj2 = likes.deleteLiike(nom,jaime);

				return obj2.build().toString();
			}
			 
		}
		else if (lik != null) {
			System.out.println("ana f lik");
		String nom = (String) httpSession.getAttribute("user") ;
		
		System.out.println("ana f lik nom session : "+nom);
		
		JsonObjectBuilder obj3 = Json.createObjectBuilder();
		obj3.add("nbJaime", likes.getNbLiike(lik));
//		System.out.println("ana f lik nblikes = "+likes.getNbLiike(lik)+" obj3 : "+obj3.build().toString());
		return obj3.build().toString();
		
		}
		else if (usr != null) {
			String res;
			usrs.init();
			if(us.findUserByNomAndPassword(usr, pass) != null){
				System.out.println("connexion reussi");
				String sessionUser= (String) httpSession.getAttribute("user") ; // check l ' utilisateur ␣en␣cours
				httpSession.setAttribute("user", usr);
				//resp.getWriter().write("{'user':"+session.getAttribute("user")+"}");
			    obj = Json.createObjectBuilder();
				obj.add("res", true);
				return obj.build().toString();
				}
			else {
				 obj = Json.createObjectBuilder();
					obj.add("res", false);
					return obj.build().toString();
					}
			
			
		}
		return null;
		
		
	}

	


	public String index() {
		return "twitter"; // equivalent du forward
	}
}
