package com.formation.velo.service;

import com.formation.velo.model.Station;

import java.util.List;
import java.util.Optional;

public interface StationService {

  List<Station> findAll();

  Optional<Station> findById(Integer id);

  Station save(Station station);

  void deleteById(Integer id);

  void delete(Station station);

  void getRecords();

  Optional<Station> findByRecordId(String recordId);

}
