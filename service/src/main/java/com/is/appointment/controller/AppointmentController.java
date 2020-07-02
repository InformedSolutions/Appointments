package com.is.appointment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.is.appointment.domain.Appointment;
import com.is.appointment.domain.AppointmentNotFoundException;
import com.is.appointment.service.AppointmentService;

import java.util.List;

@RestController
@RequestMapping("appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointment;

    @GetMapping("{id}")
    public Appointment getAppointment(@PathVariable String id) {
        System.out.println("AppointmentController.getAppointment(" + id + ")");
        return this.appointment.getAppointment(id);
    }

    @GetMapping("list/provider/{id}")
    public List<Appointment> getAppointmentsByProvider(@PathVariable String id) {
        System.out.println("AppointmentController.getAppointmentsByProvider(" + id + ")");
        System.out.println("Appointment: " + this.appointment.getAppointmentsByProvider(id));
        return this.appointment.getAppointmentsByProvider(id);
    }

    @GetMapping("list/client/{id}")
    public List<Appointment> getAppointmentsByClient(@PathVariable String id) {
        System.out.println("AppointmentController.getAppointmentsByClient(" + id + ")");
        return this.appointment.getAppointmentsByClient(id);
    }

    @GetMapping("list")
    public List<Appointment> getAllAppointments() {
        System.out.println("AppointmentController.getAllAppointments()");
        return appointment.getAllAppointments();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void addAppointment(@RequestBody Appointment appointment) {
        System.out.println("AppointmentController.addAppointment(" + appointment + ")");
        this.appointment.addAppointment(appointment);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateAppointment(@RequestBody Appointment appointment) {
        System.out.println("AppointmentController.updateAppointment(" + appointment + ")");
        this.appointment.updateAppointment(appointment);
    }

    @PostMapping("/cancel/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void cancelAppointment(@PathVariable String id) {
        System.out.println("AppointmentController.cancelAppointment(" + id + ")");
        appointment.cancelAppointment(id);
    }

    @ExceptionHandler(AppointmentNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Appointment not found")
    public void updateFailure() { }

}
