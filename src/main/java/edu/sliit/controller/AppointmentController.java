package edu.sliit.controller;

import edu.sliit.dto.Appointment;
import edu.sliit.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class AppointmentController {
    @Autowired
    final AppointmentService service;

    @GetMapping("/get-all")
    public List<Appointment> getAppointment(){
        return service.getAll();
    }

    @PostMapping("/add-appointment")
    public void addAppointment(@RequestBody Appointment appointment){
        log.info("updated-> {}",appointment);
        service.addAppointment(appointment);
    }

    @GetMapping("/search-by-id/{id}")
    public Appointment getAppointmentById(@PathVariable Integer id){
        return service.searchAppointmentById(id);
    }

    @DeleteMapping("/delete-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteAppointmentById(@PathVariable Integer id){
        service.deleteAppointmentById(id);
    }
    @PutMapping("/update-appointment")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateAppointment(@RequestBody Appointment appointment){
        service.updateAppointmentById(appointment);
    }
}
