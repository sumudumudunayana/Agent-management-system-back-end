package edu.sliit.service.impl;

import edu.sliit.dto.Appointment;
import edu.sliit.entity.AppointmentEntity;
import edu.sliit.repository.AppointmentRepository;
import edu.sliit.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<Appointment> getAll() {
        List<Appointment> AppointmentArrayList = new ArrayList<>();
        repository.findAll().forEach(entity->{
            AppointmentArrayList.add(mapper.map(entity, Appointment.class));
        });
        return AppointmentArrayList;
    }

    @Override
    public void addAppointment(Appointment appointment) {
        System.out.println(appointment);
        repository.save(mapper.map(appointment, AppointmentEntity.class));
    }

    @Override
    public void deleteAppointmentById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Appointment searchAppointmentById(Integer id) {
        return mapper.map(repository.findById(id),Appointment.class);


    }

    @Override
    public void updateAppointmentById(Appointment appointment) {
        repository.save(mapper.map(appointment, AppointmentEntity.class));
    }
}
