package org.amadejsky.parcelmanager.controller;

import org.amadejsky.parcelmanager.model.Parcel;
import org.amadejsky.parcelmanager.repository.ParcelRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParcelController {
    private final ParcelRepository parcelRepository;

    public ParcelController(ParcelRepository parcelRepository) {
        this.parcelRepository = parcelRepository;
    }

    @GetMapping("/parcels")
    public List<Parcel> getAll(){
        return parcelRepository.findAll();
    }

    @PostMapping("/parcels")
    public void post(@RequestBody Parcel parcel){
        parcelRepository.save(parcel);
    }
}
