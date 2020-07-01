package com.is.appointment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import com.is.appointment.domain.Appointment;
import com.is.appointment.domain.AppointmentNotFoundException;
import com.is.appointment.repository.AppointmentRepo;

@Component
public class AppointmentService {

    @Autowired
    AppointmentRepo repository;

    public AppointmentService() {
        System.out.println("AppointmentService.<init>()");
    }

    public List<Appointment> getAllAppointments() {
        System.out.println("AppointmentService.getAllBooks()");
        return (List<Appointment>) repository.findAll();
    }

    public void addAppointment(Appointment appointment) {
        System.out.println("AppointmentService.addAppointment(" + appointment + ")");
        this.repository.save(appointment);
    }

    public void updateAppointment(Appointment newVersionOfAppointment) {
        System.out.println("AppointmentService.updateAppointment(" + newVersionOfAppointment + ")");
        this.repository.save(newVersionOfAppointment);
    }

    public void deleteAppointment(String id) {
        System.out.println("AppointmentService.deleteAppointment(" + id + ")");
        repository.deleteById(id);
    }

    public Appointment getAppointment(String id) {
        System.out.println("AppointmentService.getAppointment(" + id + ")");
        Optional<Appointment> optionalBook = repository.findById(id);
        return optionalBook.orElseThrow(() -> new AppointmentNotFoundException("Couldn't find an appointment with id: " + id));
    }
}