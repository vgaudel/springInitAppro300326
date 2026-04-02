package fr.dawan.formationspring.repositories;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import fr.dawan.formationspring.entities.Article;
import fr.dawan.formationspring.entities.Emballage;

@Repository
public class FakeArticleRepository {

	private static Map<Long, Article> articlesDb = new HashMap<Long, Article>();

	private long nextId = 13L;

	static {

		articlesDb.put(1L, new Article(1L,"One Piece", 7.45, "Manga très populaire", LocalDate.now(), Emballage.SANS));
		articlesDb.put(2L,
				new Article(2L,"Les furtifs", 25.50, "Un chef d'oeuvre d'Alain Damasio", LocalDate.now(), Emballage.SANS));
		articlesDb.put(3L, new Article(3L,"Adidas d'occasion", 17.45, "Usées", LocalDate.now(), Emballage.CARTON));
		articlesDb.put(4L, new Article(4L,"Ramette", 10.99, "Papier de bonne qualité", LocalDate.now(), Emballage.PAPIER));
		articlesDb.put(5L, new Article(5L,"Jeu", 40.00, "c'est un jeu", LocalDate.now(), Emballage.PLASTIQUE));
		articlesDb.put(6L, new Article(6L,"Film", 20.00, "c'est un film", LocalDate.now(), Emballage.PLASTIQUE));
		articlesDb.put(7L, new Article(7L,"Boite", 90.00, "c'est une boite", LocalDate.now(), Emballage.CARTON));
		articlesDb.put(8L, new Article(8L,"Rien", 00.00, "c'est rien", LocalDate.now(), Emballage.SANS));
		articlesDb.put(9L, new Article(9L,"Souris sans-fils", 70.0, "Souris 100% Gaming", LocalDate.of(2024, 4, 3),
				Emballage.CARTON));
		articlesDb.put(10L, new Article(10L,"Clavier Mécanique", 100.0, "Clavier mécanique Gaming",
				LocalDate.of(2022, 10, 23), Emballage.CARTON));
		articlesDb.put(11L, new Article(11L,"Clé USB 64 Go", 11.0, "Clé USB 64 Go USB3", LocalDate.of(2025, 7, 6),
				Emballage.PLASTIQUE));
		articlesDb.put(12L, new Article(12L,"Multiprise parafoudre", 25.0, "Multiprise parafoudre 6 prises cordon 2m",
				LocalDate.of(2020, 12, 9), Emballage.SANS));
	}
	
	public void remove(long id) throws Exception {
		if(!articlesDb.containsKey(id)) {
			throw new Exception();
		}
		articlesDb.remove(id);
	}
	
	public List<Article> findAll(){
		return articlesDb.values().stream().toList();
	}
}
