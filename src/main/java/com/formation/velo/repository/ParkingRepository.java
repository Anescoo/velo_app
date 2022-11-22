package com.formation.velo.repository;

import com.formation.velo.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface ParkingRepository extends JpaRepository<Parking, Integer> {

    Optional<Parking> findByRecordId(String recordId);
}

	
