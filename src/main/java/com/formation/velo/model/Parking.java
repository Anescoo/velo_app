package com.formation.velo.model;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
// import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "parkings")

public class Parking implements Serializable{

    	@Id
    	@GeneratedValue(strategy = GenerationType.IDENTITY)

    	private Integer id;
	private Integer grpDisponible;
	private String grpNom;
	private Integer grpStatut;
	private String grpIdentifiant;
	private Integer disponibilite;
	private String idobj;
	private Integer grpComplet;
	private String grpExploitation;
	private Double latitude;
	private Double longitude;
	private String recordId;
}
