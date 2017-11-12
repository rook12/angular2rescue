package com.crm114discriminator.angular2rescue.entities;

import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Steve on 22/09/2017.
 */
@Entity
@Table(name="crew")
public class CrewMember extends ResourceSupport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String licenseNumber;

    private String firstName;
    private String lastName;
    private String phoneNumber;

    //mappedBy eventCrew - eventCrew is the name of the variable in the MotorsportEvent class in this relationship
    @ManyToMany(mappedBy="crew")
    private List<MotorsportEvent> motorsportEvents = new ArrayList<>();

    public Integer getCrewMemberId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "CrewMember{" +
                "id=" + id +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
