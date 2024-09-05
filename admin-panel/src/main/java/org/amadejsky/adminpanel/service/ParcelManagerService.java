package org.amadejsky.adminpanel.service;

import org.amadejsky.adminpanel.model.dto.Parcel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="PARCEL-MANAGER", url="http://localhost:9000/")
public interface ParcelManagerService {

    @GetMapping("/parcels")
    List<Parcel> getParcels(@RequestParam(required = false) Parcel.Status status);


    @GetMapping("/parcels/secure-operation")
    String performSecureOperation(@RequestHeader("Feign-Client") String feignClientHeader);

    @DeleteMapping("/parcels/delete/{code}")
    String performDeleteOperation(@RequestHeader("Feign-Client") String feignClientHeader,
                                  @PathVariable String code);


}


//@GetMapping("/parcels")
//public List<Parcel> getParcels(){
//    return parcelManagerService.getParcels();
//}
//"/delete/{code}")

//@GetMapping("/secure-operation")
//spring.application.name=PARCEL-MANAGER
//server.port=9000