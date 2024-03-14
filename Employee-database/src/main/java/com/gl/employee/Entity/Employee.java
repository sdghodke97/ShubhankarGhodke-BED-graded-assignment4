package com.gl.employee.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
	@Column	
	private int id;

	@Column
	private String firstName;
	
	@Column
	private String lastName;

	@Column
	private String Email;
	
	@Column
	private String Role;

}
