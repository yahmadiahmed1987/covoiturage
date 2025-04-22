package com.entreprise.capita.service;

import com.entreprise.capita.entities.Property;
import com.entreprise.capita.model.PropertyDTO;
import com.entreprise.capita.repository.PropertyRepository;
import com.entreprise.capita.tools.PropertyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyService {

    private final PropertyRepository propertyRepository;
    private final PropertyMapper propertyMapper;

    @Autowired
    public PropertyService(PropertyRepository propertyRepository, PropertyMapper propertyMapper) {
        this.propertyRepository = propertyRepository;
        this.propertyMapper = propertyMapper;
    }

    public List<PropertyDTO> getAllProperties() {
        return propertyRepository.findAll()
                .stream()
                .map(propertyMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PropertyDTO getPropertyById(Long id) {
        return propertyRepository.findById(id)
                .map(propertyMapper::toDTO)
                .orElse(null);
    }

    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        Property property = propertyMapper.toEntity(propertyDTO);
        Property savedProperty = propertyRepository.save(property);
        return propertyMapper.toDTO(savedProperty);
    }

    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }
}
