package com.example.service;

import java.net.HttpURLConnection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.interfaceservice;
import com.example.entity.user;
import com.example.module.modele;
import com.example.myrepo.myrepo;
import com.example.reponsemessage.reponsemessage;

@Service
public class service implements interfaceservice {

	@Autowired
	myrepo myrepo;

	@Override
	public ResponseEntity<reponsemessage> newuser(user u) {
		try {
			user save = myrepo.save(u);
			if (save != null) {
				return ResponseEntity.ok(new reponsemessage(HttpURLConnection.HTTP_OK, modele.SUCUCESS.name(),
						"Registered SucessFully", save));
			} else {
				return ResponseEntity.ok(new reponsemessage(HttpURLConnection.HTTP_BAD_REQUEST, modele.FAILUER.name(),
						"Registered Fail", save));
			}
		} catch (Exception e) {
			return ResponseEntity.ok(new reponsemessage(HttpURLConnection.HTTP_INTERNAL_ERROR, modele.FAILED.name(),
					"nterNaml Error Fail"));
		}

	}

	@Override
	public ResponseEntity<reponsemessage> update(user ur) {
		try {

			user save = myrepo.save(ur);
			if (save != null) {
				return ResponseEntity.ok(new reponsemessage(HttpURLConnection.HTTP_OK, modele.SUCUCESS.name(),
						"update SucessFully", save));
			} else {
				return ResponseEntity.ok(new reponsemessage(HttpURLConnection.HTTP_BAD_REQUEST, modele.FAILUER.name(),
						"Update Fail", save));
			}
		} catch (Exception e) {
			return ResponseEntity.ok(new reponsemessage(HttpURLConnection.HTTP_INTERNAL_ERROR, modele.FAILED.name(),
					"nterNaml Error Fail"));
		}
	}

	@Override
	@Cacheable(value = "getAlL")
	public ResponseEntity<reponsemessage> getall() {
		try {
			List<user> save = myrepo.findAll();
			System.out.println("get all data");
			if (save != null) {
				return ResponseEntity.ok(new reponsemessage(HttpURLConnection.HTTP_OK, modele.SUCUCESS.name(),
						"GetAll SucessFully", save));
			} else {
				return ResponseEntity.ok(new reponsemessage(HttpURLConnection.HTTP_BAD_REQUEST, modele.FAILUER.name(),
						"GetAll Fail", save));
			}
		} catch (Exception e) {
			return ResponseEntity.ok(new reponsemessage(HttpURLConnection.HTTP_INTERNAL_ERROR, modele.FAILED.name(),
					"nterNaml Error Fail"));
		}
	}

	@Override
	public ResponseEntity<reponsemessage> getById(Long u) {
		try {
			user save = myrepo.getById(u);
			if (save != null) {
				return ResponseEntity.ok(new reponsemessage(HttpURLConnection.HTTP_OK, modele.SUCUCESS.name(),
						"getById SucessFully", save));
			} else {
				return ResponseEntity.ok(new reponsemessage(HttpURLConnection.HTTP_BAD_REQUEST, modele.FAILUER.name(),
						"GetById Fail", save));
			}
		} catch (Exception e) {
			return ResponseEntity.ok(new reponsemessage(HttpURLConnection.HTTP_INTERNAL_ERROR, modele.FAILED.name(),
					"nterNaml Error Fail"));
		}
	}

	@Override
	public ResponseEntity<reponsemessage> delete(Long u) {

		myrepo.deleteById(u);

		return ResponseEntity
				.ok(new reponsemessage(HttpURLConnection.HTTP_OK, modele.SUCUCESS.name(), "deleted SucessFully"));

	}

	@Override
	public ResponseEntity<reponsemessage> login(String name, String password) {
		try {
			if (name.isBlank() || password.isBlank()) {
				return ResponseEntity.ok(new reponsemessage(HttpURLConnection.HTTP_CREATED, modele.FAILUER.name(),
						"user Name Is not valid"));

			}
			user user = myrepo.findByUserNameAndPassword(name, password);
			if(user!=null) {
			return ResponseEntity.ok(
					new reponsemessage(HttpURLConnection.HTTP_CREATED, modele.SUCUCESS.name(), "login sucess", user));
		
			}
			else {
				return ResponseEntity.ok(
						new reponsemessage(HttpURLConnection.HTTP_BAD_REQUEST, modele.FAILUER.name(), "login fail", user));
			
			}
		} catch (Exception e) {
			return ResponseEntity.ok(
					new reponsemessage(HttpURLConnection.HTTP_INTERNAL_ERROR, modele.FAILED.name(), "Internael error"));

		}
	}

}
