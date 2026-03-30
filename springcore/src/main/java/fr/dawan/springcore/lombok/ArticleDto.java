package fr.dawan.springcore.lombok;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
// @RequiredArgsConstructor -> génère un constructeur avec un paramètre pour toutes les variables d'instance :
// final non initialisées ou marquées comme @NonNull

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
// Avec le paramètre onlyExplicitlyIncluded = true -> Par défaut, aucune variable d'instance n'est sélectionnée.
// Il faut ajouter les variables avec @Include.

//@Data => Équivalent à @ToString, @Getter/@Setter, @EqualsAndHashCode et @RequiredArgsConstructor

//@Value => Équivalent à @Data, mais pour créer des classes immuables.
public class ArticleDto {

    @EqualsAndHashCode.Include
    private final long id;

    // On peut modifier le nom utilisé pour identifier la variable d'instance avec
    // name
    @ToString.Include(name = "description de l'article", rank = 1)
    @NonNull
    private String description;

    // On peut modifier l'ordre dans lequel les variables d'instance sont affichées avec rank
    // Les valeurs supérieurs sont affichés en premier, et pour un même rang, c'est
    // l'ordre d'apparition dans le fichier source qui est utilisé (par défaut, le rang = 0).
    @ToString.Include(rank = 2)
    private final double prix;
}