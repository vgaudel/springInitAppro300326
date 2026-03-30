package fr.dawan.springcore.beans;

import org.springframework.context.annotation.Scope;

import lombok.Data;

@Data
@Scope("prototype")
public class EmployeMapper {
	private String source;
}
