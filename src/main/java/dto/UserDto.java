package dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class UserDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	@Column(unique = true)
	String email;
	String password;
	long mnumber;
	String gender;
	LocalDate dob;
	int age;
	
	@OneToMany
	List<Task> tasks;
}
