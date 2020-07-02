package com.is.appointment.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.is.appointment.controller,com.is.appointment.service")
@EntityScan("com.is.appointment.domain")
@EnableJpaRepositories("com.is.appointment.repository")
public class AppointmentApplication {

    public static void main(String[] args) {
        System.out.println("Starting Appointments App setup");
        SpringApplication.run(AppointmentApplication.class, args);
        System.out.println("Finished Appointments App setup");
        System.out.println("For Service see - http://localhost:8080/appointments/list");
        System.out.println("For Website see - http://localhost:8080/index.html");
    }

}
