package fr.dawan.springcore.lombok;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//Constructeurs
@NoArgsConstructor // -> Création d'un constructeur sans paramètre
@AllArgsConstructor // -> Création d'un constructeur avec un paramètre pour chaque variable d'instance
//@NoArgsConstructor(access=AccessLevel.PRIVATE) // avec acces, on peut modifier la visibilité du constructeur (par défaut public)

@Getter // -> Si on place @Getter sur la classe, un getter est créé pour chaque variable d'instance
@Setter // -> Si on place @Setter sur la classe, un setter est créé pour chaque variable d'instance

@EqualsAndHashCode(/* callSuper=true */)
//@EqualsAndHashCode -> Par défaut, les méthodes equals et hashCode s'appliquent à toutes les variables d'instance 
//On peut ignorer une variable d'instance avec @EqualsAndHashCode.Exclude  
@ToString(callSuper = true)
//@ToString -> Par défaut, toutes les variables d'instance sont utilisées pour toString 
//On peut ignorer une variable d'instance avec @ToString.Exclude

//L'attribut callSuper = true permet :
//- Pour @EqualsAndHashCode, d'appeler la méthode equals et la méthode hashCode de la classe parente (sauf si la classe hérite de Object -> erreur de compilation)
//- Pour @ToString, d'appeler la méthode toString de la classe parente
public class Article {

// @Getter -> On peut aussi placer les annotations @Getter et @Setter sur la variable d'instance
// pour générer les getters et/ou les setters correspondants.
 @ToString.Exclude
 @Setter(value = AccessLevel.NONE) // On peut ne pas générer le setter et/ou le getter pour une variable d'instance
 // si les annotations sont placées sur la classe, en spécifiant AccessLevel.NONE dans l'annotation.
 private String description;

 @EqualsAndHashCode.Exclude
 private double prix;

 // On peut ajouter ses propres constructeurs
 public Article(String description) {
     this.description = description;
 }
	
}
