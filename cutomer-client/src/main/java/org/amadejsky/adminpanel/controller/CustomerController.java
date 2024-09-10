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
        return "app";
    }
    @RequestMapping(path="/tracker")
    public String trackerPage(Model model){
        model.addAttribute("parcel", new Parcel());
        return "tracker";
    }
    @GetMapping("/search")
    public String searchParcelByCode(@RequestParam("code") String code, Model model) {
        return "redirect:/manage/parcels/" + code;
    }
    @GetMapping("/parcels/{code}")
    public String trackParcelbyCode(@PathVariable String code, Model model){
        Parcel parcel = parcelManagerService.getParcelById(code);
        System.out.println("Code received: " + code);  // Debugging line
        if(parcel!=null){
            model.addAttribute("parcel", parcel);
            return "parcelDetails";
        }else{
            model.addAttribute("error", "Parcel not found");
            return "tracker";
        }
    }
//    @GetMapping("/parcels/view/{code}")
//    public String getParcelDetails(@PathVariable String code, Model model) {
//        Parcel parcel = parcelManagerService.getParcelById(code);
//        model.addAttribute("parcel", parcel);
//        return "parcelDetails";
//    }


    @PostMapping("/parcels")
    public String sendParcel(@ModelAttribute Parcel parcel){
        parcelManagerService.performPost(parcel);
        return "redirect:/manage/app";
    }
    @PostMapping("/parcels/json")
    public ResponseEntity<String> sendParcelViaPostman(@RequestBody Parcel parcel){
        parcelManagerService.performPostmanPost(parcel);
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