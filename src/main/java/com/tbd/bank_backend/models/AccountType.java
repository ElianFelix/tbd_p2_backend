package com.tbd.bank_backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AccountType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String type;
}
