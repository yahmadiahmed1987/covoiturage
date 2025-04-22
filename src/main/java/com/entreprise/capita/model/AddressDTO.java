package com.entreprise.capita.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private Long id;
    private String city;
    private String postalCode;
    private String gouvernorat;
    private String commune;
    private String description;
    private String country;


}
