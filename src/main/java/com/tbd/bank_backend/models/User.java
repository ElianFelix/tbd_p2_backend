package com.tbd.bank_backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="users")
public class User {

	@Id
	String userName;
	String email;
	String firstName;
	String lastName;
	String password;
}
