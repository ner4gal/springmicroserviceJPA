package com.algotechnica.springmicroservicejpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algotechnica.springmicroservicejpa.entities.Vendor;
import com.algotechnica.springmicroservicejpa.services.VendorService;


@RestController
public class VendorController {
                @Autowired
                private VendorService vendorService;

                @RequestMapping("/vendors")
                public List<Vendor> getAll() {
                                return vendorService.getVendors();
                }

               @PostMapping("/vendors")
                public ResponseEntity<Vendor> creatVendor(@RequestBody Vendor myVendor) {
                    try {
                        Vendor creaVendor = vendorService.creatVendor(myVendor);
                        return new ResponseEntity<>(creaVendor, HttpStatus.CREATED);
                    } catch (Exception e) {
                        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                    }
                }
                

                
                
}
