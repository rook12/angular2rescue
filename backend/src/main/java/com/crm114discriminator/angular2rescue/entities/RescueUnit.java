package com.crm114discriminator.angular2rescue.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Steve on 22/09/2017.
 */
@Entity
public class RescueUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String registration;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    @ElementCollection
    @CollectionTable(name="pastMotorsportEvents")
    private List<MotorsportEvent> pastMotorsportEvents;

    @ElementCollection
    @CollectionTable(name="plannedMotorsportEvents")
    private List<MotorsportEvent> plannedMotorsportEvents;

    @Override
    public String toString() {
        return "RescueUnit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", registration='" + registration + '\'' +
                '}';
    }
}
