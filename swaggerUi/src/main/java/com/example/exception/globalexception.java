package com.example.exception;

import java.net.HttpURLConnection;
import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.module.modele;
import com.example.reponsemessage.reponsemessage;

@ControllerAdvice
public class globalexception {

	@ExceptionHandler(idnotFound.class)
	public ResponseEntity<Object> getExceptionData(idnotFound id) {
		ArrayList<String> list = new ArrayList<>();
		list.add("id not founds");
		return ResponseEntity
				.ok(new reponsemessage(HttpURLConnection.HTTP_BAD_REQUEST, modele.FAILED.name(), "Fail", list));
	}

}
