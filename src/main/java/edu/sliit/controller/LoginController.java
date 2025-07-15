package edu.sliit.controller;

import edu.sliit.dto.Login;
import edu.sliit.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/login")
@RestController
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class LoginController {
    @Autowired
    final LoginService service;

    @GetMapping("/get-all")
    public List<Login> getLogin(){
        return service.getAll();
    }

    @PostMapping(path = "/save")
    public String saveLogin(@RequestBody Login login){
        return service.addLogin(login);
    }
}
