package com.entreprise.capita.tools;

import com.entreprise.capita.entities.*;
import com.entreprise.capita.model.AddressDTO;
import com.entreprise.capita.model.PropertyDTO;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public AddressDTO toDTO(Address address) {

            AddressDTO addressDTO = new AddressDTO();
            addressDTO.setId(address.getId());
            addressDTO.setCity(address.getCity());
            addressDTO.setPostalCode(address.getPostalCode());
            addressDTO.setCommune(address.getCommune());
            addressDTO.setDescription(address.getDescription());
            addressDTO.setGouvernorat(address.getGouvernorat().name());

        return addressDTO;
    }

    public Address toEntity(AddressDTO dto) {

            var address = new Address();
            address.setId(dto.getId());
            address.setCity(dto.getCity());
            address.setPostalCode(dto.getPostalCode());
            address.setCommune(dto.getCommune());
            address.setDescription(dto.getDescription());
            address.setGouvernorat(GOUVERNORAT.valueOf(dto.getGouvernorat()));
        return address;
    }
}
