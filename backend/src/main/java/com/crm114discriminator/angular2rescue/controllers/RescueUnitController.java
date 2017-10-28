package com.crm114discriminator.angular2rescue.controllers;

import com.crm114discriminator.angular2rescue.entities.RescueUnit;
import com.crm114discriminator.angular2rescue.repositories.RescueUnitRespository;
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
@RequestMapping(path="/unit")
public class RescueUnitController {
    @Autowired
    private RescueUnitRespository rescueUnitRespository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewRescueUnit(
            @RequestParam String name,
            @RequestParam String registration
    ) {

        RescueUnit rescueUnit = new RescueUnit();
        rescueUnit.setName(name);
        rescueUnit.setRegistration(registration);
        rescueUnitRespository.save(rescueUnit);
        return rescueUnit.toString();
    }
}
