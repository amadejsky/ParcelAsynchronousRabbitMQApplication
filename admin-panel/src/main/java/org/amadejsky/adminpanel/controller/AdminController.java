package org.amadejsky.adminpanel.controller;

import org.amadejsky.adminpanel.model.dto.Parcel;
import org.amadejsky.adminpanel.service.ParcelManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public List<Parcel> getParcels(@RequestParam(required = false) Parcel.Status status){
        return parcelManagerService.getParcels(status);
    }

    @GetMapping("/parcels/secure-operation")
    public ResponseEntity<String> secureOperation() {
       String response = parcelManagerService.performSecureOperation("true");
       return ResponseEntity.ok(response);
    }

    @GetMapping("/parcels/delete/{code}")
    public ResponseEntity<String> deleteParcel(@PathVariable String code) {
        String response = parcelManagerService.performDeleteOperation("true",code);
        return ResponseEntity.ok(response);
    }

}
