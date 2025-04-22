package com.entreprise.capita.model;

import com.entreprise.capita.entities.PropertyType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDTO {

    private Long id;
    private String type;
    private Double price;
    private AddressDTO address;
    private String status;
    private int rooms;
    private String title;
    private String transactionType;
    private LocalDateTime creationDate;
    private String description;
    private Double surface;

}

