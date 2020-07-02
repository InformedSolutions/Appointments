package com.is.appointment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        Optional<Appointment> optionalAppointment = repository.findById(id);
        return optionalAppointment.orElseThrow(() -> new AppointmentNotFoundException("Couldn't find an appointment with id: " + id));
    }

    public List<Appointment> getAppointmentsByProvider(String id) {
        System.out.println("AppointmentService.getAppointmentsByProvider(" + id + ")");
        List<Appointment> allAppointments = (List<Appointment>) repository.findAll();
        List<Appointment> providerAppointments = allAppointments.stream().filter(b -> b.getProvider() == id).collect(Collectors.toList());
        if (providerAppointments.size() < 1)
        {
            throw new AppointmentNotFoundException("Couldn't find any appointments for Provider with id: " + id);
        }
       return providerAppointments;
    }

    public List<Appointment> getAppointmentsByClient(String id) {
        System.out.println("AppointmentService.getAppointmentsByClient(" + id + ")");
        List<Appointment> allAppointments = (List<Appointment>) repository.findAll();
        List<Appointment> clientAppointments = allAppointments.stream().filter(b -> b.getClient() == id).collect(Collectors.toList());
        System.out.println(clientAppointments);
        if (clientAppointments.size() < 1)
        {
            throw new AppointmentNotFoundException("Couldn't find any appointments for Client with id: " + id);
        }
        return clientAppointments;
    }

    public void cancelAppointment(String id) {
        System.out.println("AppointmentService.cancelAppointment(" + id + ")");
        Appointment appointment = getAppointment(id);
        appointment.setFlag('C');
        updateAppointment(appointment);
        if (appointment == null) {
            throw new AppointmentNotFoundException("Couldn't find an appointment with id: " + id);
        } else {
            System.out.println("Appointment: " + id + " was cancelled.");
        }
    }
}