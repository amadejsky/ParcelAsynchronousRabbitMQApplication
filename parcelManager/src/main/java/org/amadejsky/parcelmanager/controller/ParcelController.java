package org.amadejsky.parcelmanager.controller;

import org.amadejsky.parcelmanager.model.Parcel;
import org.amadejsky.parcelmanager.repository.ParcelRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Optional<Parcel> getParcelById(@PathVariable String code){
        return parcelRepository.findById(code);
    }

    @GetMapping("/secure-operation")
    public ResponseEntity<String> secureOperation(@RequestHeader(value = "Feign-Client", required = false) String feignClient) {
        if (!"true".equals(feignClient)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied");
        }
        return ResponseEntity.ok("This operation is only accessible via Feign client.");
    }

}
