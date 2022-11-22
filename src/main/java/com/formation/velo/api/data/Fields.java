package com.formation.velo.api.data;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fields {

    @SerializedName("grp_disponible")
    private int grpDisponible;
    @SerializedName("grp_nom")
    private String grpNom;
    @SerializedName("grp_statut")
    private int grpStatut;
    @SerializedName("grp_identifiant")
    private String grpIdentifiant;
    private int disponibilite;
    private String idobj;
    @SerializedName("grp_complet")
    private int grpComplet;
    @SerializedName("grp_exploitation")
    private String grpExploitation;
    private double[] location;


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

