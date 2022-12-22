package com.tbd.bank_backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TransactionType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String type;
}
