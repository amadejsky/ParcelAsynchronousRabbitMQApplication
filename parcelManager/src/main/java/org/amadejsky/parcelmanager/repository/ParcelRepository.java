package org.amadejsky.parcelmanager.repository;

import org.amadejsky.parcelmanager.model.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelRepository extends JpaRepository<Parcel,Long> {
    
}
