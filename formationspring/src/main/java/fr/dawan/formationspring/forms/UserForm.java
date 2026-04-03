package fr.dawan.formationspring.forms;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
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

public class UserForm {
   
    @NotBlank(message="{user.prenom.empty}")//message = "Le prénom est obligatoire")
    @Size(max=60, message="{user.prenom.sizemax}")
    private String prenom;

    @NotBlank(message="{user.nom.empty}")
    @Size(max=60, message="{user.nom.sizemax}")
    private String nom;

    @NotNull
    @Past
    private LocalDate naissance;

    @NotNull
    @Email
    private String email;

    @NotBlank
    @Size(min=6)
    private String password;

    @NotBlank
    @Size(min=6)
    private String confirmationPassword;
}
