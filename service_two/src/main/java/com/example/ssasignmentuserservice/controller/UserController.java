package com.example.ssasignmentuserservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ssasignmentuserservice.VO.ResponseTemplateVO;
import com.example.ssasignmentuserservice.entity.User;
import com.example.ssasignmentuserservice.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
	
	
	  @Autowired
	    private UserService userService;

	    @PostMapping("/")
	    public User saveUser(@RequestBody User user) {
	        System.out.println("Inside saveUser of UserController");
	        return userService.saveUser(user);
	    }

	    @GetMapping("/{id}")
	    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
	        System.out.println("Inside getUserWithDepartment of UserController");
	        return userService.getUserWithDepartment(userId);
	    }
	    
	    @GetMapping("/test")
	    public String getString()
	    {
	    	return "It's hitting the api";
	    	
	    }

}
