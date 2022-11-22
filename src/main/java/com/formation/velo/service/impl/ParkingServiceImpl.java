package com.formation.velo.service.impl;

import com.formation.velo.model.Parking;
import com.formation.velo.repository.ParkingRepository;
import com.formation.velo.api.data.parking.OpenDataNantesParking;
import com.formation.velo.service.ParkingService;
import com.formation.velo.api.OpenData;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;
import java.util.Optional;
import java.util.Arrays;
import java.io.IOException;


@Service
@Log
public class ParkingServiceImpl implements ParkingService {
	private final ParkingRepository parkingRepository;
	
	public ParkingServiceImpl(ParkingRepository repository) {
		this.parkingRepository = repository;
	}

	@Override
	public List<Parking> findAll() {
		return parkingRepository.findAll();
	}

	@Override
	public Optional<Parking> findById(Integer id){
		return parkingRepository.findById(id);
	}

	@Override
	public Parking save(Parking parking) {
		return parkingRepository.save(parking);
	}

	@Override
	public void deleteById(Integer id) {
		parkingRepository.deleteById(id);
	}

	@Override
	public void delete(Parking parking) {
		parkingRepository.delete(parking);
	}

	@Override
	public void getParkingDatas() {
		String baseUrl = "https://data.nantesmetropole.fr/";
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(baseUrl)
				.addConverterFactory(GsonConverterFactory.create())
				.build();

		OpenDataNantesParking data = retrofit.create(OpenDataNantesParking.class);
		Call<OpenData> openDataVeloNantesCall = data.getParkingDatas();

		try {
			OpenData openDataVeloNantes = openDataVeloNantesCall.execute().body();
			log.info(openDataVeloNantes.toString());

			Arrays.stream(openDataVeloNantes.getRecords()).forEach(record -> {
				Optional<Parking> parkingToUpdate = findByRecordId(record.getRecordId());

				if(parkingToUpdate.isPresent()) {

					parkingToUpdate.get()
					.setGrpDisponible(record.getFields().getGrpDisponible());

					parkingToUpdate.get()
					.setGrpStatut(record.getFields().getGrpStatut());

					parkingToUpdate.get()
					.setGrpExploitation(record.getFields().getGrpExploitation());

					parkingToUpdate.get()
					.setGrpComplet(record.getFields().getGrpComplet());

					save(parkingToUpdate.get());
				} else {
					Parking newParking = Parking.builder()
					.recordId(record.getRecordId())
					.grpDisponible(record.getFields().getGrpDisponible())
					.grpStatut(record.getFields().getGrpStatut())
					.grpExploitation(record.getFields().getGrpExploitation())
					.disponibilite(record.getFields().getDisponibilite())
					.idobj(record.getFields().getIdobj())
					.grpComplet(record.getFields().getGrpComplet())
					.grpNom(record.getFields().getGrpNom())
					.grpIdentifiant(record.getFields().getGrpIdentifiant())
					.build();

					if (record.getFields().getLocation() != null) {
						newParking.setLatitude(record.getFields().getLocation()[0]);
						newParking.setLongitude(record.getFields().getLocation()[1]);
						save(newParking);
					} else {
						newParking.setLatitude(0.0);
						newParking.setLongitude(0.0);
						save(newParking);
					}

					save(newParking);
				}
			});

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Optional<Parking> findByRecordId(String recordId) {
		return parkingRepository.findByRecordId(recordId);
				
	}
}
