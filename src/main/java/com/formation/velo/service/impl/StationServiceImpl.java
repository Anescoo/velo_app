package com.formation.velo.service.impl;

import com.formation.velo.api.client.OpenDataNantesClient;
import com.formation.velo.api.OpenData;
import com.formation.velo.model.Station;
import com.formation.velo.repository.StationRepository;
import com.formation.velo.service.StationService;

import lombok.extern.java.Log;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Log
public class StationServiceImpl implements StationService {

  private final StationRepository stationRepository;

  public StationServiceImpl(StationRepository repository) {
    this.stationRepository = repository;
  }

  @Override
  public List<Station> findAll() {
    return stationRepository.findAll();
  }

  @Override
  public Optional<Station> findById(Integer id) {
    return stationRepository.findById(id);
  }

  @Override
  public Station save(Station station) {
    return stationRepository.save(station);
  }

  @Override
  public void deleteById(Integer id) {
    stationRepository.deleteById(id);
  }

  @Override
  public void delete(Station station) {
    stationRepository.delete(station);
  }

  @Override
  public void getRecords() {
    // 1- appel a openData
    String baseUrl = "https://data.nantesmetropole.fr/";
    Retrofit retrofit = new Builder().baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

    OpenDataNantesClient client = retrofit.create(OpenDataNantesClient.class);
    Call<OpenData> openDataVeloNantesCall = client.getRecords();

    try{
      OpenData openDataVeloNantes = openDataVeloNantesCall.execute().body();
      log.info(openDataVeloNantes.toString());

      Arrays.stream(openDataVeloNantes.getRecords()).forEach(record -> {
        Optional<Station> stationToUpdate = findByRecordId(record.getRecordId());

        if(stationToUpdate.isPresent()){
          //On update la station
          stationToUpdate.get()
                  .setBikeStands(record.getField().getBikeStands());
          stationToUpdate.get()
                  .setAvailableBikes(record.getField().getAvailableBike());
          stationToUpdate.get()
                  .setAvailableBikeStands(record.getField().getAvailableBikeStands());
          stationToUpdate.get()
                  .setStatus(record.getField().getStatus());

          //on save
          save(stationToUpdate.get());
        }else {
          // on crée la station
          Station newStation = Station.builder()
                  .recordId(record.getRecordId())
                  .name(record.getField().getName())
                  .availableBikes(record.getField().getAvailableBike())
                  .bikeStands(record.getField().getBikeStands())
                  .availableBikeStands(record.getField().getAvailableBikeStands())
                  .latitude(record.getField().getPosition()[0])
                  .longitude(record.getField().getPosition()[1])
                  .status(record.getField().getStatus())
                  .build();

          //on save
          save(newStation);
        }
      });
      // 2- Save records dans notre table station

    } catch(IOException e){
      throw new RuntimeException(e);
    }
  }

  @Override
  public Optional<Station> findByRecordId(String recordId) {
    return stationRepository.findByRecordId(recordId);
  }

}
