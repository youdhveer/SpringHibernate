package com.example.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.model.User;
import com.example.spring.service.UserService;

/**
 * This controller will do LDAP Authentication based on user 
 * @author Youdhveer
 *
 */
@RestController
public class UserRestController {

	@Autowired
	UserService userService;	
	
	@RequestMapping(value = "/userByRESTData/", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getUserProfileByEmail(@RequestParam("id") String id) {
		List<User> users = new ArrayList<User>();
		User user=userService.isValidUser(id);
		users.add(user);
		if(users.isEmpty()){
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	/**
	 * Pass URLs ...../userByREST/"abc@mail.com"
	 * OR   URLs ...../userByREST/'abc@mail.com'
	 * Invalid URL : URLs ...../userByREST/abc@mail.com
	 */
	@RequestMapping(value = "/userByREST/{emailId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserProfileByEmailViaParam(@PathVariable("emailId") String emailId) {
		System.out.println("Fetching User with emailId " + emailId);
		if(emailId!=null &&  (!emailId.contains(".com"))){ // Only for those string containing @ and containing ('' or "")
			emailId=emailId.replaceAll("\"", "");
			emailId=emailId.replaceAll("\'", "");
			emailId=emailId+".com";
		}
		User user = userService.isValidUser(emailId);
		if (user == null) {
			System.out.println("User with emailId " + emailId + " not found");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	
}
