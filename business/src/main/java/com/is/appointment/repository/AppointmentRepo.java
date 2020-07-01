package com.is.appointment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.is.appointment.domain.Appointment;

@Repository
public interface AppointmentRepo extends CrudRepository<Appointment, String> {}
