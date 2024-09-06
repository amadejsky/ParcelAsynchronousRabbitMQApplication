package org.amadejsky.parcelmanager.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Notification {
    private String Code;
    private String address;
    private Parcel.Status status;
}
