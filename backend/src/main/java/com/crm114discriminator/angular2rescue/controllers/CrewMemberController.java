package com.crm114discriminator.angular2rescue.controllers;

import com.crm114discriminator.angular2rescue.entities.CrewMember;
import com.crm114discriminator.angular2rescue.repositories.CrewMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by Steve on 22/09/2017.
 */
@Controller
@RequestMapping(path="/api/crew")
public class CrewMemberController {
    @Autowired
    private CrewMemberRepository crewMemberRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewCrewMember(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String phoneNumber,
            @RequestParam String licenseNumber) {

        CrewMember crewMember = new CrewMember();
        crewMember.setFirstName(firstName);
        crewMember.setLastName(lastName);
        crewMember.setLicenseNumber(licenseNumber);
        crewMember.setPhoneNumber(phoneNumber);
        crewMemberRepository.save(crewMember);

        return crewMember.toString();
    }

    @GetMapping(path="/list")
    public @ResponseBody  Iterable<CrewMember> list() {
        Iterable<CrewMember> crewMembers = crewMemberRepository.findAll();

        for (CrewMember crewMember: crewMembers) {
            crewMember.add(linkTo(MotorsportEventController.class).slash(crewMember.getCrewMemberId()).withSelfRel());
        }

        return crewMembers;
    }

}
