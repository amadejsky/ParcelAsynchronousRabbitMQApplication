package org.amadejsky.parcelmanager.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class Parcel {
    @Id
    private String code;
    @NotBlank
    private String address;
    @NotBlank
    private String email;
    @Min(value = 0, message = "Weight must be positive number")
    private double weight;


}
