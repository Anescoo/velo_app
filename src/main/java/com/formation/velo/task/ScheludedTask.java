package com.formation.velo.task;

import com.formation.velo.service.StationService;
import lombok.extern.java.Log;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Log
public class ScheludedTask {

    private final StationService stationService;

    public ScheludedTask(StationService stationService) {
        this.stationService = stationService;
    }

    @Scheduled(fixedRate = 60000)
    public void searchextMatchByCompetition(){
        log.info(" Update stations");
        stationService.getRecords();
    }

}
