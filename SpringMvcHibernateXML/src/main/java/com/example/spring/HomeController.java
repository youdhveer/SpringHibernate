package com.example.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring.dao.ApplicationDAO;
import com.example.spring.dao.UserDAO;
import com.example.spring.model.Application;
import com.example.spring.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private ApplicationDAO applicationDAO;
	
	@RequestMapping(value="/")
	public ModelAndView home() {
		List<User> listUsers = userDao.list();
		ModelAndView model = new ModelAndView("home");
		model.addObject("userList", listUsers);
		return model;
	}
	
	@RequestMapping(value = "/rest/applications", method = RequestMethod.GET)
    public  @ResponseBody List<Application> getAllAplications() {    	
        List<Application> appList=applicationDAO.list();      
        return appList;
    }
    
	
}
