package com.is.appointment.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "provider")
public class Provider {

    @Id
    private String id;
    private String name;
    private String areaOfExpertise;

    public Provider() {
    }

    public Provider(String id, String name, String areaOfExpertise) {
        this.id = id;
        this.name = name;
        this.areaOfExpertise = areaOfExpertise;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAreaOfExpertise() {
        return areaOfExpertise;
    }

    public void setAreaOfExpertise(String areaOfExpertise) {
        this.areaOfExpertise = areaOfExpertise;
    }

    @Override
    public String toString() {
        return String.format("Provider [id=%s, name=%s, areaOfExpertise=%s]", id, name, areaOfExpertise);
    }
}