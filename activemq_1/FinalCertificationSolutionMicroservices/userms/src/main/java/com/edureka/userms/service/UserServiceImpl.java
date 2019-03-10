package com.edureka.userms.service;

import com.edureka.userms.model.User;
import com.edureka.userms.repository.UserRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RestTemplate restTemplate;

    public UserServiceImpl(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getSingleUser(Long userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    @HystrixCommand(fallbackMethod = "getAllOrdersFromCache")
    public Object getAllOrders() {
        Object orders = restTemplate.getForObject("http://orderms/orders", Object.class);
        return orders;
    }

    private Object getAllOrdersFromCache() {
        return "Orderms is not responsive";
    }
}
