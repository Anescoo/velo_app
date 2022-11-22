package com.formation.velo.api.data.parking;

import com.formation.velo.api.OpenData;
import retrofit2.Call;
import retrofit2.http.GET;

public interface OpenDataNantesParking {
	@GET("/api/records/1.0/search/?dataset=244400404_parkings-publics-nantes-disponibilites&q=&facet=grp_nom&facet=grp_statut&rows=1000")
	Call<OpenData> getParkingDatas();
}
