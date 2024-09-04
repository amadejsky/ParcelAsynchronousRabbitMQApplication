package org.amadejsky.adminpanel.service;

import org.amadejsky.adminpanel.model.dto.Parcel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name="PARCEL-MANAGER", url="http://localhost:9000/")
public interface ParcelManagerService {

    @GetMapping("/parcels")
    List<Parcel> getParcels();


    @GetMapping("/secure-operation")
    String performSecureOperation(@RequestHeader("Feign-Client") String feignClientHeader);

}


//@GetMapping("/secure-operation")
//spring.application.name=PARCEL-MANAGER
//server.port=9000