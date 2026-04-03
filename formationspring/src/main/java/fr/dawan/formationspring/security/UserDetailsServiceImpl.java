package fr.dawan.formationspring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.dawan.formationspring.entities.User;
import fr.dawan.formationspring.repositories.FakeUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private FakeUserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = repository.findByEmail(username);
		return new UserDetailsImpl(user);
		
	}
	
}
