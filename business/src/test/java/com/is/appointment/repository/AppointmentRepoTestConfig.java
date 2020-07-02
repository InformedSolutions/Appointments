package com.is.appointment.repository;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.is.appointment.domain")
@EnableJpaRepositories("com.is.appointment.repository")
@EnableAutoConfiguration
public class AppointmentRepoTestConfig {
}
