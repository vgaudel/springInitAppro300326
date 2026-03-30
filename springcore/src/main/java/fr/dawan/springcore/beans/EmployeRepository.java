package fr.dawan.springcore.beans;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("empRepository1")
public class EmployeRepository {
	private String dataSource;
}
