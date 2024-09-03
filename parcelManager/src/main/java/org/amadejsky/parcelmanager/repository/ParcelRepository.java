package org.amadejsky.parcelmanager.repository;

import org.amadejsky.parcelmanager.model.Parcel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelRepository extends MongoRepository<Parcel,String> {
    
}
