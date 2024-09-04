package org.amadejsky.parcelmanager.service;

import org.amadejsky.parcelmanager.model.Parcel;
import org.amadejsky.parcelmanager.repository.ParcelRepository;

import java.util.List;

public interface ParcelService {
    List<Parcel> getAllParcels();
    Parcel addParcel(Parcel parcel);
    Parcel getParcelbyId(String code);
    void deleteParcel(String code);


}
