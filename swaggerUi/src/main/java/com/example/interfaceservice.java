package com.example;

import org.springframework.http.ResponseEntity;

import com.example.entity.user;
import com.example.reponsemessage.reponsemessage;

public interface interfaceservice {

	ResponseEntity<reponsemessage> newuser(user u);

	ResponseEntity<reponsemessage> update(user ur);

	ResponseEntity<reponsemessage> getall();

	ResponseEntity<reponsemessage> getById(Long u);

	ResponseEntity<reponsemessage> delete(Long u);

	ResponseEntity<reponsemessage> login(String name, String password);

}
