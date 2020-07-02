package com.is.appointment.repository;

import com.is.appointment.domain.Appointment;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes=AppointmentRepoTestConfig.class)
public class AppointmentRepoTest {
    @Autowired
    AppointmentRepo repository;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        System.out.println("setUpBeforeClass");
    }
    @AfterAll
    static void tearDownAfterClass() throws Exception {
        System.out.println("tearDownAfterClass");
    }

    @BeforeEach
    public void setUp() throws Exception {
        System.out.println("In setup");
    }

    @AfterEach
    public void tearDown() throws Exception {
        System.out.println("In tearDown");
    }

    @Test
    public void testFindByID() {
        String id = "1";
        Optional<Appointment> optionalAppointment = repository.findById(id);
        assertEquals(optionalAppointment.get().getId(), id, "ID should be " + id);
    }

    @Test
    public void testFindAllAppointments() {
        List<Appointment> appointments = (List<Appointment>) repository.findAll();
        assertTrue(appointments.size() > 0, "Should be 1 or more appointments returned");
    }
}
