package fr.dawan.formationspring.entities;

import java.time.LocalDate;

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

public class User extends BaseEntity {
	
    private String prenom;

    private String nom;

    private LocalDate naissance;

    private String email;

    private String password;

}