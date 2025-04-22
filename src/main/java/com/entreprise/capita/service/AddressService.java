package com.entreprise.capita.service;

import com.entreprise.capita.entities.Address;
import com.entreprise.capita.model.AddressDTO;
import com.entreprise.capita.repository.AddressRepository;
import com.entreprise.capita.tools.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Autowired
    public AddressService(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    public List<AddressDTO> getAllAddresses() {
        return addressRepository.findAll()
                .stream()
                .map(addressMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AddressDTO getAddressById(Long id) {
        return addressRepository.findById(id)
                .map(addressMapper::toDTO)
                .orElse(null);
    }

    public AddressDTO saveAddress(AddressDTO addressDTO) {
        Address address = addressMapper.toEntity(addressDTO);
        Address savedAddress = addressRepository.save(address);
        return addressMapper.toDTO(savedAddress);
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }

}
