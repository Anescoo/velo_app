package com.formation.task;

import com.formation.velo.service.ParkingService;
import lombok.extern.java.Log;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@Log
public class ScheludedTask {

	private final ParkingService parkingService;
	public ScheludedTask(ParkingService parkingService) {
		this.parkingService = parkingService;
	}

	@Scheduled(fixedRate = 60000)
	public void searchNewMatchStation() {
		log.info("mise à jour...");

		parkingService.getParkingDatas();

		// try {
		// 	parkingService.getParkingDatas();
		// 	log.info("✅ parking update");
		// } catch (Exception e) {
		// 	log.info("❌ parking not update" + e.getMessage());
		// }
	}	
	
}
