package com.formation.velo.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = -7670709104974486420L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank(message = "name is mandatory")
	private String name;
	@NotBlank(message = "Surname is mandatory")
	private String surname;

}
