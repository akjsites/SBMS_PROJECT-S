package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.interfaceservice;
import com.example.entity.user;
import com.example.exception.idnotFound;
import com.example.myrepo.myrepo;
import com.example.reponsemessage.reponsemessage;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;


@Tag(name = "swaggeruiregiser", description = "register,login")
@RestController
public class myController {

	@Autowired
	interfaceservice interfaceservice;
	@Autowired
	myrepo myrepo;

	@Operation(summary = "registerAPI",description = "new userAdd APi")
	@ApiResponses({
		@ApiResponse(responseCode = "201",description = "register sucess")
		,
		@ApiResponse(responseCode = "400",description = "failed register"),
		@ApiResponse(responseCode = "500",description = "internal error")
	})
	@PostMapping("registerUserInMakeMytrio")
	public ResponseEntity<reponsemessage> postMethodName(@RequestBody user u) {

		ResponseEntity<reponsemessage> newuser = interfaceservice.newuser(u);

		return newuser;
	}
	@Operation(summary = "login",description = "login user")
	@ApiResponses({
		@ApiResponse(responseCode = "201",description = "login sucess"),
		@ApiResponse(responseCode = "400",description = "username and password valid"),
		@ApiResponse(responseCode = "500",description = "internal error")
	})
	@PostMapping("LoginUserInMakeMytrio")
	public ResponseEntity<reponsemessage> postMethodNameLogin(@RequestParam("userName") String name,@RequestParam("password") String password ) {

		if(name.isBlank())
		{
			throw new idnotFound("user must be enter");
		}
		ResponseEntity<reponsemessage> newuser = interfaceservice.login(name,password);

		return newuser;
	}
	@PostMapping("LoginUserInMakeMytrio/{id}")
	public  Object postMethodNameLoginfind(Long id ) {

		
	  user user = myrepo.findById(id).orElseThrow(()->new idnotFound("id is not availeble"));

	   
		return user;
	}
	
	
	@GetMapping("getall")
	public  ResponseEntity<reponsemessage> getMethodName() {
		ResponseEntity<reponsemessage> getall = interfaceservice.getall();
		return getall;
	}
	

	

}
