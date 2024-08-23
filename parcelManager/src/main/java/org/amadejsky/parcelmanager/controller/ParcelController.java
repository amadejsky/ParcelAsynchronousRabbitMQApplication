package org.amadejsky.parcelmanager.controller;

import org.amadejsky.parcelmanager.model.Parcel;
import org.amadejsky.parcelmanager.repository.ParcelRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/parcels/{id}")
    public Optional<Parcel> getParcelById(@PathVariable Long id){
        return parcelRepository.findById(id);
    }
}
