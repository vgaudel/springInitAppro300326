package fr.dawan.formationspring.forms;

import java.time.LocalDate;

import fr.dawan.formationspring.entities.Emballage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ArticleForm {

	@NotBlank(message = "Le nom doit être renseigné")
	@Size(max=80)
	private String nom;
	
	@NotBlank
	@Size(min=15,max=150)
	private String description;
	
	@NotNull
	@Past(message = "La date doit être antérieure à celle d'aujourd'hui")
	private LocalDate dateProduction;
	
	@NotNull
	private Emballage emballage;
	
	@NotNull
	@Positive
	private double prix;
	
}
