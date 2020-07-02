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

    @Test
    public void testAppointmentGetAppointmentsByProvider() {
        String id = "1";
        List<Appointment> listAppointment = appointment.getAppointmentsByProvider(id);
        // Check non-empty list
        assertTrue(listAppointment.size() > 0, "List appointment should not be empty");
        // Check list matches
        boolean result = AppointmentServiceTestUtility.matchIdList(id, "provider", listAppointment);
        assertTrue(result, "ID list matches " + id);
    }

    @Test
    public void testAppointmentGetAppointmentsByClient() {
        String id = "1";
        List<Appointment> listAppointment = appointment.getAppointmentsByClient(id);
        // Check non-empty list
        assertTrue(listAppointment.size() > 0, "List appointment should not be empty");
        // Check list matches
        boolean result = AppointmentServiceTestUtility.matchIdList(id, "client", listAppointment);
        assertTrue(result, "ID list matches " + id);
    }
}

class AppointmentServiceTestUtility {

    static boolean matchIdList(String id, String idType, List<Appointment> listAppointment) {
        boolean result = true;
        int numberOfIds = listAppointment.size();
        switch(idType) {
            case "provider":
                List<String> providerIds = listAppointment.stream().map(Appointment::getProvider).collect(Collectors.toList());
                if (providerIds.size() != numberOfIds) {
                    result = false;
                } else {
                    for (String providerId : providerIds) {
                        if (!providerId.equals(id)) {
                            result = false;
                        }
                    }
                }
                break;
            case "client":
                List<String> clientIds = listAppointment.stream().map(Appointment::getClient).collect(Collectors.toList());
                if (clientIds.size() != numberOfIds) {
                    result = false;
                } else {
                    for (String clientId : clientIds) {
                        if (!clientId.equals(id)) {
                            result = false;
                        }
                    }
                }
                break;
        }

        return result;

    }
}