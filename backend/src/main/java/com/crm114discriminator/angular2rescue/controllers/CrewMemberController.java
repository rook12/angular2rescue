package com.crm114discriminator.angular2rescue.controllers;

import com.crm114discriminator.angular2rescue.entities.CrewMember;
import com.crm114discriminator.angular2rescue.repositories.CrewMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Steve on 22/09/2017.
 */
@Controller
@RequestMapping(path="/crew")
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


}
