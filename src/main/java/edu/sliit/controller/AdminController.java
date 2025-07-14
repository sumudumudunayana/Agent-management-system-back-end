package edu.sliit.controller;

import edu.sliit.dto.Admin;
import edu.sliit.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping ("/admin")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class AdminController {
    @Autowired
    final AdminService service;

    @GetMapping("/get-all")
    public List<Admin> getAdmin(){
        return service.getAll();
    }

    @PostMapping("/add-admin")
//    @ResponseStatus(HttpStatus.CREATED)
    public void addAdmin(@RequestBody Admin admin){
        log.info("updated-> {}",admin);
        service.addAdmin(admin);
    }

    @GetMapping("/search-by-id/{id}")
    public Admin getAdminById(@PathVariable Integer id){
        return service.searchAdminById(id);
    }

    @DeleteMapping("/delete-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteAdminById(@PathVariable Integer id){
        service.deleteAdminById(id);
    }
    @PutMapping("/update-admin")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateAdmin(@RequestBody Admin admin){
        service.updateAdminById(admin);
    }
}
