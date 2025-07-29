package edu.sliit.service;

import edu.sliit.dto.Login;
import edu.sliit.dto.LoginResponse;

import java.util.List;

public interface LoginService {
    LoginResponse loginUser(Login login);
    String addLogin(Login login);

    List<Login> getAll();
}
