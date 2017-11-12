package com.crm114discriminator.angular2rescue.entities;

import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Steve on 22/09/2017.
 */
@Entity
@Table(name="event")
public class MotorsportEvent extends ResourceSupport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

//    @JsonProperty("event_name")
    private String name;

//    @JsonProperty("units_required")
    private Integer unitsRequired;

//    @JsonProperty("crew_required")
    private Integer crewRequired;

//    @JsonProperty("start_date")
    private Date startDate;

//    @JsonProperty("end_date")
    private Date endDate;

   /* @ElementCollection
    @CollectionTable(name = "unitsAssigned")
    private List<RescueUnit> unitsAssigned;*/

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "event_crew",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "crew_member_id")
    )
    private List<CrewMember> crew;

    public List<CrewMember> getCrew() {
        return crew;
    }

    public void addCrewMember(CrewMember crewMember) {
        this.crew.add(crewMember);
    }

    public Integer getMotorsportEventId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUnitsRequired() {
        return unitsRequired;
    }

    public void setUnitsRequired(Integer unitsRequired) {
        this.unitsRequired = unitsRequired;
    }

    public Integer getCrewRequired() {
        return crewRequired;
    }

    public void setCrewRequired(Integer crewRequired) {
        this.crewRequired = crewRequired;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "MotorsportEvent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unitsRequired=" + unitsRequired +
                ", crewRequired=" + crewRequired +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
