package org.amadejsky.adminpanel.controller;

import org.amadejsky.adminpanel.model.dto.Parcel;
import org.amadejsky.adminpanel.service.ParcelManagerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manage")
public class AdminController {

    private final ParcelManagerService parcelManagerService;

    public AdminController(ParcelManagerService parcelManagerService) {
        this.parcelManagerService = parcelManagerService;
    }

    @GetMapping()
    public String connection(){
        return "Connection Test!";
    }

    @GetMapping("/parcels")
    public List<Parcel> getParcels(){
        return parcelManagerService.getParcels();
    }

}
