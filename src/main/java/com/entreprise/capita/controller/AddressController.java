package com.entreprise.capita.controller;

import com.entreprise.capita.model.AddressDTO;
import com.entreprise.capita.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<AddressDTO> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @GetMapping("/{id}")
    public AddressDTO getAddressById(@PathVariable Long id) {
        return addressService.getAddressById(id);
    }

    @PostMapping
    public AddressDTO createAddress(@RequestBody AddressDTO addressDTO) {
        return addressService.saveAddress(addressDTO);
    }

    @PutMapping("/{id}")
    public AddressDTO updateAddress(@PathVariable Long id, @RequestBody AddressDTO addressDTO) {
        addressDTO.setId(id);
        return addressService.saveAddress(addressDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
    }
}
