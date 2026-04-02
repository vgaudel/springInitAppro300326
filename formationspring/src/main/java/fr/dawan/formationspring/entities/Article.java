package fr.dawan.formationspring.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Article {

	private long id;	
	
    private String nom;
    
    private double prix;

    private String description;
  
    private LocalDate dateProduction;
    
    private Emballage emballage;
    
}
