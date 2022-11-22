package com.formation.velo.controllers;

import com.formation.velo.model.Parking;
import com.formation.velo.service.ParkingService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class ParkingController {
	private final ParkingService parkingService;

	public ParkingController(ParkingService parkingService) {
		this.parkingService = parkingService;
	}

	@GetMapping("/parkings")
	public ResponseEntity<List<Parking>> getAll() {
		parkingService.getParkingDatas();
		List<Parking> parkings = parkingService.findAll();

		return ResponseEntity.ok(parkings);
	}

	@GetMapping("/parkings/{id}")
	public ResponseEntity<Optional<Parking>> getPersoneById(@PathVariable Integer id) {
		Optional<Parking> parking = parkingService.findById(id);

		return ResponseEntity.ok(parking);
	}

	@PostMapping("/parkings/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		parkingService.deleteById(id);
		return ResponseEntity.ok("deleted");
	}

	@PostMapping("/parkings/update")
	public ResponseEntity<String> update(@RequestBody Parking parking) {
		parkingService.save(parking);
		return ResponseEntity.ok("updated");
	}
}
