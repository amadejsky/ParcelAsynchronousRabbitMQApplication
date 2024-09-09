package org.amadejsky.adminpanel.model.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Parcel {
    private String code;
    @NotBlank
    private String address;
    @NotBlank
    private String email;
    @Min(value = 0, message = "Weight must be positive number")
    private double weight;
    private Status status = Status.PENDING;


    public enum Status{
        PENDING,
        SHIPPED,
        SENT_FROM_FACILITY,
        OUT_FOR_DELIVERY,
        DELIVERED,
        DELAYED,
        INACTIVE

    }

}

