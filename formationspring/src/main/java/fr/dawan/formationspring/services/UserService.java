package fr.dawan.formationspring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import fr.dawan.formationspring.entities.User;
import fr.dawan.formationspring.repositories.FakeUserRepository;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class UserService {

	@Autowired
	FakeUserRepository fakeUserRepository;
	
	public boolean mailExist(String mail) {
		
		User user = fakeUserRepository.getUserByMail(mail);
		System.out.println("probleme mau=il égaux" + user);
		return (user!=null);
	}
	 
}
 