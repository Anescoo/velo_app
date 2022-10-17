package com.formation.velo.repository;

import com.formation.velo.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface StationRepository extends JpaRepository<Station, Integer> {
    Optional<Station> findByRecordId(String recordId);
}