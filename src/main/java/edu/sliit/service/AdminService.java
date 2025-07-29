package edu.sliit.service;

import edu.sliit.dto.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> getAll();

    void addAdmin(Admin admin);

    void deleteAdminById(Integer id);

    Admin searchAdminById(Integer id);

    void updateAdminById(Admin admin);
}
