package com.example.myrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.user;
import java.util.List;


public interface myrepo extends JpaRepository<user, Long>{

	user findByUserNameAndPassword(String userName, String password);
}
