package com.formation.velo.api.client.velo;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Field {

    @SerializedName("available_bike_stands")
    private int availableBikeStands;
    @SerializedName("available_bike")
    private int availableBike;
    @SerializedName("bike_stands")
    private int bikeStands;
    private String name;
    private int number;
    private String address;
    private String status;
    //index 0 latitude, index 1 longitude
    private double[] position;
}
