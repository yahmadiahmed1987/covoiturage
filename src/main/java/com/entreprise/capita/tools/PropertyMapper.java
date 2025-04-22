package com.entreprise.capita.tools;

import com.entreprise.capita.entities.*;
import com.entreprise.capita.model.AddressDTO;
import com.entreprise.capita.model.PropertyDTO;
import org.springframework.stereotype.Component;

@Component
public class PropertyMapper {

    public PropertyDTO toDTO(Property property) {
        PropertyDTO dto = new PropertyDTO();
        dto.setId(property.getId());
        dto.setType(property.getType().name());
        dto.setPrice(property.getPrice());
        dto.setRooms(property.getRooms());
        dto.setStatus(property.getStatus().name());
        dto.setCreationDate(property.getCreationDate());
        dto.setTitle(property.getTitle());
        dto.setDescription(property.getDescription());

        if(property.getAddress()!= null) {
            AddressDTO addressDTO = new AddressDTO();
            addressDTO.setId(property.getAddress().getId());
            addressDTO.setCity(property.getAddress().getCity());
            addressDTO.setPostalCode(property.getAddress().getPostalCode());
            addressDTO.setCity(property.getAddress().getCity());
            addressDTO.setCommune(property.getAddress().getCommune());
            addressDTO.setDescription(property.getAddress().getDescription());
            addressDTO.setGouvernorat(property.getAddress().getGouvernorat().name());
            dto.setAddress(addressDTO);
        }
        return dto;
    }

    public Property toEntity(PropertyDTO dto) {
        Property property = new Property();
        property.setId(dto.getId());
        property.setType(PropertyType.valueOf(dto.getType()));
        property.setPrice(dto.getPrice());
        property.setDescription(dto.getDescription() );
        property.setCreationDate(dto.getCreationDate());
        property.setStatus(PropertyStatus.valueOf(dto.getStatus()));
        property.setRooms(dto.getRooms());
        property.setSurface(dto.getSurface());
        property.setTitle(dto.getTitle());
        property.setTransactionType(TransactionType.valueOf(dto.getTransactionType()));

        if (dto.getAddress() != null) {
            var address = new Address();
            address.setId(dto.getAddress().getId());
            address.setCity(dto.getAddress().getCity());
            address.setPostalCode(dto.getAddress().getPostalCode());
            address.setCommune(dto.getAddress().getCommune());
            address.setDescription(dto.getAddress().getDescription());
            address.setGouvernorat(GOUVERNORAT.valueOf(dto.getAddress().getGouvernorat()));
            property.setAddress(address);
        }
        return property;
    }
}
