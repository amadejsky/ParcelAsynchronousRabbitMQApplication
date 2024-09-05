package org.amadejsky.parcelmanager.service;

import org.amadejsky.parcelmanager.model.Parcel;
import org.amadejsky.parcelmanager.repository.ParcelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ParcelServiceImpl implements ParcelService{

    private final ParcelRepository parcelRepository;

    public ParcelServiceImpl(ParcelRepository parcelRepository) {
        this.parcelRepository = parcelRepository;
    }

    @Override
    public List<Parcel> getParcels() {
        return parcelRepository.findAll();
    }

    @Override
    public Parcel getParcel(String code) {
        return parcelRepository.findById(code)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Parcel addParcel(Parcel parcel) {
        return parcelRepository.save(parcel);
    }



    @Override
    public void deleteParcel(String code) {
        Parcel parcel = parcelRepository.findById(code)
                .orElseThrow(IllegalArgumentException::new);
        parcelRepository.deleteById(code);

    }
}
