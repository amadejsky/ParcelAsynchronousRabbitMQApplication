package org.amadejsky.adminpanel.controller;

import org.amadejsky.adminpanel.model.dto.Parcel;
import org.amadejsky.adminpanel.service.ParcelManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/manage")
public class CustomerController {

    private final ParcelManagerService parcelManagerService;

    public CustomerController(ParcelManagerService parcelManagerService) {
        this.parcelManagerService = parcelManagerService;
    }
    @RequestMapping(path="/app")
    public String appPage(Model model){
        model.addAttribute("parcel", new Parcel());
        return "App";
    }
    @GetMapping("/parcels/{code}")
    public Parcel connection(@PathVariable String code){
        return parcelManagerService.getParcelById(code);
    }
    @PostMapping("/parcels")
    public ResponseEntity<String> sendParcel(@RequestBody Parcel parcel){
        parcelManagerService.performPostOperation(parcel);
        return ResponseEntity.status(HttpStatus.CREATED).body("Parcel created successfully");
    }

}

//    @GetMapping("/parcels")
//    public List<Parcel> getParcels(@RequestParam(required = false) Parcel.Status status){
//        return parcelManagerService.getParcels(status);
//    }

//    @GetMapping("/parcels/secure-operation")
//    public ResponseEntity<String> secureOperation() {
//       String response = parcelManagerService.performSecureOperation("true");
//       return ResponseEntity.ok(response);
//    }
//
//    @GetMapping("/parcels/delete/{code}")
//    public ResponseEntity<String> deleteParcel(@PathVariable String code) {
//        String response = parcelManagerService.performDeleteOperation("true",code);
//        return ResponseEntity.ok(response);
//    }