package com.example.ssasignmentuserservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.ssasignmentuserservice.VO.Department;
import com.example.ssasignmentuserservice.VO.ResponseTemplateVO;
import com.example.ssasignmentuserservice.entity.User;
import com.example.ssasignmentuserservice.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class UserService {
	
	 @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private RestTemplate restTemplate;

	    public User saveUser(User user) {
	        System.out.println("Inside saveUser of UserService");
	        return userRepository.save(user);
	    }

	    public ResponseTemplateVO getUserWithDepartment(Long userId) {
	        System.out.println("Inside getUserWithDepartment of UserService");
	        ResponseTemplateVO vo = new ResponseTemplateVO();
	        User user = userRepository.findByUserId(userId);

	        Department department =
	                restTemplate.getForObject("http://service1:9001/departments/" + user.getDepartmentId()
	                        ,Department.class);

	        department.setDepartmentId(user.getDepartmentId());
	        vo.setUser(user);
	        vo.setDepartment(department);

	        return  vo;
	    }

}
