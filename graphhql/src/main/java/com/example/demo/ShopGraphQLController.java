package com.example.demo;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ShopGraphQLController {

    private final UserRepository userRepo;
    private final OrderRepository orderRepo;

    public ShopGraphQLController(UserRepository userRepo,
                                 OrderRepository orderRepo) {
        this.userRepo = userRepo;
        this.orderRepo = orderRepo;
    }

    @QueryMapping
    public List<User> users() {
        return userRepo.findAll();
    }

    @QueryMapping
    public User user(@Argument Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @MutationMapping
    public User createUser(@Argument String name,
                           @Argument String email) {
        return userRepo.save(new User(name, email));
    }

    @MutationMapping
    public Order createOrder(@Argument Long userId,
                             @Argument String product,
                             @Argument double price) {
        User user = userRepo.findById(userId).orElseThrow();
        Order order = new Order(product, price, user);
        return orderRepo.save(order);
    }
}
