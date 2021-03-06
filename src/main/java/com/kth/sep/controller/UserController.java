package com.kth.sep.controller;


import com.kth.sep.entity.User;
import com.kth.sep.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @PostMapping("create")
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("set_seed_data")
    public List<User> createUserData(){
        List<User> users = new ArrayList<>();
        User user= new User();
        user.setPassword("admin");
        user.setUsername("admin");
        user.setRole("ADMIN");

        User user1= new User();
        user1.setPassword("hr");
        user1.setUsername("hr");
        user1.setRole("HR");

        User user2= new User();
        user2.setPassword("cso");
        user2.setUsername("cso");
        user2.setRole("CUSTOMER_SERVICE_OFFICER");

        User user3= new User();
        user3.setPassword("scso");
        user3.setUsername("scso");
        user3.setRole("SENIOR_CUSTOMER_SERVICE_OFFICER");

        User user4= new User();
        user4.setPassword("financialManager");
        user4.setUsername("financialManager");
        user4.setRole("FINANCIAL_MANAGER");

        User user5= new User();
        user5.setPassword("productionManager");
        user5.setUsername("productionManager");
        user5.setRole("PRODUCTION_MANAGER");

        User user6= new User();
        user6.setPassword("subteam");
        user6.setUsername("subteam");
        user6.setRole("SUBTEAM");

        users.add(user);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);

        userRepository.saveAll(users);
        return users;



    }

}
