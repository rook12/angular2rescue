package com.crm114discriminator.angular2rescue.controllers;

import com.crm114discriminator.angular2rescue.entities.MotorsportEvent;
import com.crm114discriminator.angular2rescue.repositories.MotorsportEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by Steve on 22/09/2017.
 */
@Controller
@RequestMapping(path="/api/event")
public class MotorsportEventController {

    private MotorsportEventRepository motorsportEventRepository;

    @Autowired
    public MotorsportEventController(MotorsportEventRepository motorsportEventRepository) {
        this.motorsportEventRepository = motorsportEventRepository;
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

    @PostMapping(path="/add")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody String addNewEvent(
            @RequestParam String name,
            @RequestParam @DateTimeFormat(pattern = "ddmmyyyy") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "ddmmyyyy") Date endDate,
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
