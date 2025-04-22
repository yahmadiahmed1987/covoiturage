package com.entreprise.capita.controller;

import com.entreprise.capita.model.PropertyDTO;
import com.entreprise.capita.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    private final PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping
    public List<PropertyDTO> getAllProperties() {
        return propertyService.getAllProperties();
    }

    @GetMapping("/{id}")
    public PropertyDTO getPropertyById(@PathVariable Long id) {
        return propertyService.getPropertyById(id);
    }

    @PostMapping
    public PropertyDTO createProperty(@RequestBody PropertyDTO propertyDTO) {
        return propertyService.saveProperty(propertyDTO);
    }

    @PutMapping("/{id}")
    public PropertyDTO updateProperty(@PathVariable Long id, @RequestBody PropertyDTO propertyDTO) {
        propertyDTO.setId(id);
        return propertyService.saveProperty(propertyDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProperty(@PathVariable Long id) {
        propertyService.deleteProperty(id);
    }
}