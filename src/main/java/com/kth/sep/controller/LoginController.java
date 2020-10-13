package com.kth.sep.controller;


import com.kth.sep.entity.User;
import com.kth.sep.exception.UserNotFoundException;
import com.kth.sep.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {

    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("")
    public ResponseEntity<User> validateUser(@RequestBody User user){
        User user1= null;
        try {
            user1 = userRepository.getByUsernameAndPassword(user.getUsername(), user.getPassword()).orElseThrow(()->new UserNotFoundException("No such user exist"));
            return new ResponseEntity<>(user1, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(user1, HttpStatus.BAD_REQUEST);
        }
    }

}
