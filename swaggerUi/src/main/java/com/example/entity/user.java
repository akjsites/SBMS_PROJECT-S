package com.example.entity;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import io.micrometer.common.lang.NonNull;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name="swaggeruser")
public class user {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
//	@NotBlank(message = "userName Not blank")
//	@Schema(description = "userName",example = "enter")
	String userName;
	String firstName;
	@NotBlank(message = "password Not blank")
	@Schema(description = "password",example = "enter")
	String password;
	String phno;
	@CreationTimestamp
	Date registerdate;
	
	@UpdateTimestamp
	Date updateDate;
}
