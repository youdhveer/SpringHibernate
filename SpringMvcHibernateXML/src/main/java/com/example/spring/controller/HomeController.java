package com.example.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring.dao.ApplicationDAO;
import com.example.spring.dao.UserAuthDAO;
import com.example.spring.model.Application;
import com.example.spring.model.User;
import com.example.spring.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired	
	private UserAuthDAO userDAO;
	
	@Autowired
	private ApplicationDAO applicationDAO;
	
	
	@Autowired
	private UserService userService;
	
	
	/**
	 * LDAP authentication
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.GET)	
    public @ResponseBody User getUserViaQueryParam(@RequestParam("name") String name) {
		System.out.println("getUserViaQueryParam  by id : "+name);
        User user=userService.isValidUser(name);
        return user;
    }
	
	@RequestMapping(value="/")
	public ModelAndView home() {
		List<User> listUsers = new ArrayList<User>();
		ModelAndView model = new ModelAndView("home");
		model.addObject("userList", listUsers);
		return model;
	}
	
		
	@RequestMapping(value = "/rest/applications", method = RequestMethod.GET)
    public  @ResponseBody List<Application> getAllAplications() {    	
        //List<Application> appList=applicationDAO.list();      
        List<Application> appList=new ArrayList<Application>();
        
        return appList;
    }
	
}
