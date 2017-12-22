package com.crm114discriminator.angular2rescue.controllers;

import com.crm114discriminator.angular2rescue.entities.CrewMember;
import com.crm114discriminator.angular2rescue.entities.MotorsportEvent;
import com.crm114discriminator.angular2rescue.repositories.CrewMemberRepository;
import com.crm114discriminator.angular2rescue.repositories.MotorsportEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by Steve on 22/09/2017.
 */
@Controller
@RequestMapping(path="/api/event")
public class MotorsportEventController {

    private CrewMemberRepository crewMemberRepository;

    private MotorsportEventRepository motorsportEventRepository;

    @Autowired
    public MotorsportEventController(MotorsportEventRepository motorsportEventRepository, CrewMemberRepository crewMemberRepository) {
        this.motorsportEventRepository = motorsportEventRepository;
        this.crewMemberRepository = crewMemberRepository;
    }

    @GetMapping(path="/search")
    public @ResponseBody String eventSearch(
            @RequestParam(value="name") String eventName) {
        MotorsportEvent event = motorsportEventRepository.findByName(eventName);
        if(event == null) {
            return "no match for - " + eventName;
        }
        else {
            return "the ID was - " + event.toString();
        }
    }

    @GetMapping(path="/count")
    public @ResponseBody String getCount() {

        return Long.toString(motorsportEventRepository.count());
    }

    @GetMapping(path="/list")
    public @ResponseBody  Iterable<MotorsportEvent> list() {
        Iterable<MotorsportEvent> motorsportEvents = motorsportEventRepository.findAll();

        for (MotorsportEvent motorsportEvent : motorsportEvents) {
            motorsportEvent.add(linkTo(MotorsportEventController.class).slash(motorsportEvent.getMotorsportEventId()).withSelfRel());
        }

        return motorsportEvents;
    }

    @GetMapping(path="/{eventid}")
    public @ResponseBody MotorsportEvent getEventById(
            @PathVariable(value="eventid") String id) {

        MotorsportEvent motorsportEvent = motorsportEventRepository.findById(Integer.parseInt(id));
        Link link = linkTo(MotorsportEventController.class).slash(motorsportEvent.getMotorsportEventId()).withSelfRel();

        motorsportEvent.add(link);

        return motorsportEvent;
    }

    @GetMapping(path="/{eventid}/crew")
    public @ResponseBody Iterable<CrewMember> getEventCrewMembers(
            @PathVariable(value="eventid") String id) {
        MotorsportEvent motorsportEvent = motorsportEventRepository.findById(Integer.parseInt(id));
        return motorsportEvent.getCrew();
    }

    @PutMapping(path="/{eventid}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateMotorsportEvent(
            @RequestBody MotorsportEvent motorsportEvent, @PathVariable("eventid") String id) {

        MotorsportEvent existingEvent = motorsportEventRepository.findById(Integer.parseInt(id));

        List<String> updatedFields = new ArrayList<>();

        if(motorsportEvent.getName() != null && !motorsportEvent.getName().equals(existingEvent.getName())) {
            existingEvent.setName(motorsportEvent.getName());
            updatedFields.add("name");
        }

        if(motorsportEvent.getUnitsRequired() != null && !motorsportEvent.getUnitsRequired().equals(existingEvent.getUnitsRequired())) {
            existingEvent.setUnitsRequired(motorsportEvent.getUnitsRequired());
            updatedFields.add("unitsrequired");
        }

        if(motorsportEvent.getCrewRequired() != null && !motorsportEvent.getCrewRequired().equals(existingEvent.getCrewRequired())) {
            existingEvent.setCrewRequired(motorsportEvent.getCrewRequired());
            updatedFields.add("crewrequired");
        }

        if(motorsportEvent.getStartDate() != null && !motorsportEvent.getStartDate().equals(existingEvent.getStartDate())) {
            existingEvent.setStartDate(motorsportEvent.getStartDate());
            updatedFields.add("startdate");
        }

        if(motorsportEvent.getEndDate() != null && !motorsportEvent.getEndDate().equals(existingEvent.getEndDate())) {
            existingEvent.setEndDate(motorsportEvent.getEndDate());
            updatedFields.add("enddate");
        }

        if(updatedFields.size() > 0) {
            motorsportEventRepository.save(existingEvent);
            return ResponseEntity.ok(String.format("{\"message\":\"event updated fields [%s] \"}", String.join(", ", updatedFields)));
        }
        else {
            return ResponseEntity.ok("{\"message\":\"no changes detected\"}");
        }


    }

   /* @PatchMapping(path="/{eventid}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> partialUpdateName(
            @RequestBody MotorsportEventNameOnly partialUpdate, @PathVariable("eventid") String id) {
        motorsportEventRepository.save(partialUpdate);
        return ResponseEntity.ok("event name updated");
    }*/


    @PostMapping(path="/{eventid}/crew/add")
    public ResponseEntity<?> addCrewMember(
            @PathVariable(value="eventid") String id,
            @RequestParam Integer crewMemberId) {
        MotorsportEvent motorsportEvent = motorsportEventRepository.findById(Integer.parseInt(id));
        CrewMember cm = crewMemberRepository.findById(crewMemberId);
        if (cm == null) {
            throw new IllegalArgumentException("could not find crew member with id "  + crewMemberId);
        }

        motorsportEvent.addCrewMember(cm);
        motorsportEventRepository.save(motorsportEvent);
        return ResponseEntity.ok(String.format("added crew member with id - %s. total crew members - %s", crewMemberId, motorsportEvent.getCrew().size() ));
    }

    @PostMapping(path="/{eventid}")
    public @ResponseBody MotorsportEvent updateEvent(
            @RequestBody MotorsportEvent motorsportEvent,
            @PathVariable(value="eventid") String id) {


        //MotorsportEvent motorsportEvent = motorsportEventRepository.findById(Integer.parseInt(id));

        String one = "1";
        String one2 = "2";

        MotorsportEvent motorsportEvent1 = motorsportEventRepository.findById(Integer.parseInt(id));


        //motorsportEventRepository.save(motorsportEvent);
        return motorsportEventRepository.findById(Integer.parseInt(id));
    }

    @PostMapping(path="/add")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody String addNewEvent(
            @RequestParam String name,
            @RequestParam @DateTimeFormat(pattern = "ddMMyyyy") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "ddMMyyyy") Date endDate,
            @RequestParam Integer crewRequired,
            @RequestParam Integer unitsRequired
            ) {
        MotorsportEvent motorsportEvent = new MotorsportEvent();
        motorsportEvent.setName(name);
        motorsportEvent.setCrewRequired(crewRequired);
        motorsportEvent.setStartDate(startDate);
        motorsportEvent.setEndDate(endDate);
        motorsportEvent.setUnitsRequired(unitsRequired);
        motorsportEventRepository.save(motorsportEvent);
        return motorsportEvent.toString();
    }
}
