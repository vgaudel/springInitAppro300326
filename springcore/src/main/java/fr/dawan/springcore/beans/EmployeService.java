package fr.dawan.springcore.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.ToString;

@ToString
@Component("empService1")
public class EmployeService {

	private EmployeRepository repo;
	private EmployeMapper empMap;
	
	@Autowired
	public EmployeService(EmployeRepository repo,@Qualifier("empMapper2") EmployeMapper empMap) {
		this.repo=repo;
		this.empMap=empMap;
	}
	
}
