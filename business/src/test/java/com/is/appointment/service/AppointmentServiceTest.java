package com.is.appointment.service;

import com.is.appointment.domain.Appointment;
import com.is.appointment.repository.AppointmentRepoTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootTest(classes= {AppointmentRepoTestConfig.class, AppointmentServiceTestConfig.class})
public class AppointmentServiceTest {

    @Autowired
    private AppointmentService appointment;

    @Test
    public void testAppointmentGetAllAppointments() {
        List<Appointment> appointments = appointment.getAllAppointments();
        assertTrue(appointments.size() > 0, "Should be 1 or more appointments returned");
    }
}
