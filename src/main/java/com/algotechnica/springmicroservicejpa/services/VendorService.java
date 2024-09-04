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
        Vendor vn = null;
        try {
            vendorDB.findById(vendorId).get();
            vn =  vendorDB.save(vendor);

        } catch (Exception e) {
        }
          return vn;
    }

    public String deleteVendor(String vendorID) {

        String message ;
        try {
            vendorDB.deleteById(vendorID);
            message = "Vendor deleted successfully";
            
        } catch (Exception e) {
            message = "Vendor not found";
        }
        return message;
        
    
    }
}
