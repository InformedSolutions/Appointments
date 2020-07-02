package com.is.appointment.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    private String id;
    private Date datetime;
    private float duration;
    private String provider; //Provider
    private String client; // Client
    private float cost;
    private String description;
    private char flag;

    public Appointment() {}

    public Appointment(String id, Date datetime, float duration, String provider, String client, float cost, String description, char flag) {
        super();
        this.id = id;
        this.datetime = datetime;
        this.duration = duration;
        this.provider = provider;
        this.client = client;
        this.cost = cost;
        this.description = description;
        this.flag = flag;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public Date getDatetime() { return datetime;
    }

    public void setDatetime(Date datetime) { this.datetime = datetime; }

    public float getDuration() { return duration; }

    public void setDuration(float duration) { this.duration = duration; }

    public String getProvider() { return provider; }

    public void setProvider(String provider) { this.provider = provider; }

    public String getClient() { return client; }

    public void setClient(String client) { this.client = client; }

    public float getCost() { return cost; }

    public void setCost(float cost) { this.cost = cost; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public char getFlag() { return flag; }

    public void setFlag(char flag) { this.flag = flag; }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", datetime=" + datetime +
                ", duration=" + duration +
                ", provider=" + provider +
                ", client=" + client +
                ", cost=" + cost +
                ", description='" + description + '\'' +
                ", flag=" + flag +
                '}';
    }
}
