package com.entreprise.capita.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VoyageurDto {

	private long id;

	private String name;

	private String lastName;

	private Date dateNaissance;

	private String identity;

	private String email;

	private String telephone;

	private byte[] photo;

	private boolean isIdentityVerifeyed;

}
