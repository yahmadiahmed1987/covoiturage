package com.entreprise.capita.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "VOYAGEUR")
public class Voyageur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "DATE_NAISSANCE")
	private Date dateNaissance;
	
	@Column(name = "IDENTITY")
	private String identity;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "TELEPHONE")
	private String telephone;

	@Lob
	@Column(name = "PHOTO")
	private byte[] photo;
	
	@Column(name = "IS_IDENTITY_VERFIYED")
	private boolean isIdentityVerifeyed ;

}
