package com.algotechnica.springmicroservicejpa.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.algotechnica.springmicroservicejpa.entities.Address;
import com.algotechnica.springmicroservicejpa.services.AddressService;





@RestController
public class AdressController {

        @Autowired
        AddressService addressService;

        @RequestMapping("/addresses")
        public List<Address> getAll() {
                            return addressService.getAddresses();
            }
        @RequestMapping("/addresses/{addressId}")
                public Optional<Address> getAddressbyId(@RequestParam("addressId") String addressId) {
                    try {
                            return  addressService.getAddressById(addressId);
                         
                    } catch (Exception e) {
                            return null;
                    }
                   
                }
        @PostMapping("/addresses")
        public Address creatAddress(@RequestBody Address myAddress) {
            try {
                return addressService.creatAddress(myAddress);
            } catch (Exception e) {
                return null;
            }
        }
}