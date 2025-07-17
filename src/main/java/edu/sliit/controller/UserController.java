package edu.sliit.controller;

import edu.sliit.dto.User;
import edu.sliit.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class UserController {
    @Autowired
    final UserService service;

    @GetMapping("/get-all")
    public List<User> getUser(){
        return service.getAll();
    }

    @PostMapping("/add-user")
    public void addUser(@RequestBody User user){
        log.info("updated-> {}",user);
        service.addUser(user);
    }

    @GetMapping("/search-by-id/{id}")
    public User getUserById(@PathVariable Integer id){
        return service.searchUserById(id);
    }

    @DeleteMapping("/delete-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteUserById(@PathVariable Integer id){
        service.deleteUserById(id);
    }
    @PutMapping("/update-user")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateUser(@RequestBody User user){
        service.updateUserById(user);
    }
}
