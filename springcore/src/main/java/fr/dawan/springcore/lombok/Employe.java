package fr.dawan.springcore.lombok;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Employe {

	private String prenom;

	private String nom;
	@ToString.Exclude
	private LocalDate dateNaissance;

	@Setter
	private double salaire;
	@ToString.Exclude
	@Setter
	@EqualsAndHashCode.Include
	private String email;
}
