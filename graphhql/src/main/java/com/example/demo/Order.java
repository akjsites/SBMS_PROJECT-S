package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product;
    private double price;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

	public Order(String product, double price, User user) {
		super();
		this.product = product;
		this.price = price;
		this.user = user;
	}

	public Order() {
		super();
	}
    
}
