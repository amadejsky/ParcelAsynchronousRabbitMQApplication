package org.amadejsky.adminpanel.service;

import org.amadejsky.adminpanel.model.dto.Parcel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="PARCEL-MANAGER", url="http://localhost:9000/")
public interface ParcelManagerService {
    @GetMapping("/parcels/{code}")
    Parcel getParcelById(@PathVariable String code);

    @PostMapping("/parcels")
    String performPostOperation(@RequestBody Parcel parcel);

}


// These methods have been commented out because the application's design has changed.
// As a result, they are no longer needed for the current stage of development.
// They may be removed or restored in the future if necessary.
// They are left here as a reference for future testing or changes.

//@GetMapping("/parcels")
//List<Parcel> getParcels(@RequestParam(required = false) Parcel.Status status);
//
//
//@GetMapping("/parcels/secure-operation")
//String performSecureOperation(@RequestHeader("Feign-Client") String feignClientHeader);
//
//@DeleteMapping("/parcels/delete/{code}")
//String performDeleteOperation(@RequestHeader("Feign-Client") String feignClientHeader,
//                              @PathVariable String code);
//@PostMapping()
//public void post(@RequestBody Parcel parcel){
//    parcelService.addParcel(parcel);
//}

//@GetMapping("/parcels")
//public List<Parcel> getParcels(){
//    return parcelManagerService.getParcels();
//}
//"/delete/{code}")

//@GetMapping("/secure-operation")
//spring.application.name=PARCEL-MANAGER
//server.port=9000