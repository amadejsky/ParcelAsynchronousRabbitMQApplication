package org.amadejsky.parcelmanager.controller;

import org.amadejsky.parcelmanager.model.Parcel;
import org.amadejsky.parcelmanager.repository.ParcelRepository;
import org.amadejsky.parcelmanager.service.ParcelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/parcels")
public class ParcelController {
    private final ParcelService parcelService;

    public ParcelController(ParcelService parcelService) {
        this.parcelService = parcelService;
    }

    @GetMapping()
    public List<Parcel> getAll(){
        return parcelService.getAllParcels();
    }

    @PostMapping()
    public void post(@RequestBody Parcel parcel){
        parcelService.addParcel(parcel);
    }

    @GetMapping("/{code}")
    public Parcel getParcelById(@PathVariable String code){
        return parcelService.getParcelbyId(code);
    }

    @DeleteMapping("/{code}")
    public void deleteParcel(@PathVariable String code){
        parcelService.deleteParcel(code);
    }

    @GetMapping("/secure-operation")
    public ResponseEntity<String> secureOperation(@RequestHeader(value = "Feign-Client", required = false) String feignClient) {
        if (!"true".equals(feignClient)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied");
        }
        return ResponseEntity.ok("This operation is only accessible via Feign client.");
    }



}
