package com.algotechnica.springmicroservicejpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algotechnica.springmicroservicejpa.entities.Vendor;

@Component
public class VendorService {
    
    @Autowired
    IVendorPersistence vendorDB = null;


    public VendorService(IVendorPersistence vendorDB) {
       this.vendorDB =  vendorDB;
    }

    public List<Vendor> getVendors() {
             return (List<Vendor>) vendorDB.findAll();
    }
    public Optional<Vendor> getVendorById(String vendorId) {
        return vendorDB.findById(vendorId);   
    }
    public  Vendor creatVendor(Vendor vendor) {
       return vendorDB.save(vendor);
    }

    public Vendor updateVendorById(String vendorId, Vendor vendor) {
        
        try {
            vendorDB.findById(vendorId).get();
            return vendorDB.save(vendor);

        } catch (Exception e) {
            return null;
        }
          
    }

    public String deleteVendor(String vendorID) {

        
        try {
            vendorDB.deleteById(vendorID);
            return "Vendor deleted successfully";
            
        } catch (Exception e) {
            return  "Vendor not found";
        }
    }
    public List<Vendor> getVendorByEmail(String email) {
        return vendorDB.findByEmail(email);
    }
    public List<Vendor> getVendorByCompanyName(String companyName) {
        return vendorDB.findByCompanyName(companyName);
    }   
    
}
