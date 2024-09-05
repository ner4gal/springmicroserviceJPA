package com.algotechnica.springmicroservicejpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algotechnica.springmicroservicejpa.entities.Address;

@Component
public class AddressService {
        @Autowired
        IAddressPersistence addressDB = null;
        public List<Address> getAddresses() {
                 return (List<Address>) addressDB.findAll();
        }
        public Optional<Address> getAddressById(String addressId) {
            return addressDB.findById(addressId );
        }
        public Address creatAddress(Address address) {
           return addressDB.save(address);
        }
}
