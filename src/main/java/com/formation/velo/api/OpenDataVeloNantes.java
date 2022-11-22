package com.formation.velo.api;

import com.formation.velo.api.OpenDataVeloNantes;
import retrofit2.Call;
import retrofit2.http.GET;

public interface OpenDataVeloNantes {
    @GET("api/records/1.0/search/?dataset=244400404_stations-velos-libre-service-nantes-metropole-disponibilites&q=&facet=banking&facet=bonus&facet=status&facet=contract_name")
    Call<OpenDataVeloNantes> getAllVelos();

}
