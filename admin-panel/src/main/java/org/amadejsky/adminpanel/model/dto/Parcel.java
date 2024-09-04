package org.amadejsky.adminpanel.model.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Parcel {
    @NotBlank
    private String address;
    @NotBlank
    private String email;
    @Min(value = 0, message = "Weight must be positive number")
    private double weight;

}

