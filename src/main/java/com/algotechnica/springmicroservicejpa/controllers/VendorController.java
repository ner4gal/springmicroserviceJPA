package com.algotechnica.springmicroservicejpa.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
                @RequestMapping("/vendors/{vendorId}")
                    public Optional<Vendor> getVendorbyId(@PathVariable("vendorId") String vendorId) {
                        try {
                                return  vendorService.getVendorById(vendorId);
                             
                        } catch (Exception e) {
                                return null;
                        }
                       
                    }
                @RequestMapping(method = RequestMethod.PUT, value = "/vendors/{vendorId}")
                    public Vendor updateVendor(@RequestBody Vendor myVendor, @PathVariable("vendorId") String vendorId) {
                        try {
                            return vendorService.updateVendorById(vendorId, myVendor);
                        } catch (Exception e) {
                            return null;
                        }
                    }
                @RequestMapping(method = RequestMethod.DELETE, value = "/vendors/{vendorId}")
                    public void deleteVendor(@PathVariable("vendorId") String vendorId) {
                        try {
                            vendorService.deleteVendor(vendorId);
                        } catch (Exception e) {
                        }
                    }
                
                @RequestMapping("/vendors/search")
                public List<Vendor> searchByCompany(@RequestParam String companyName) {
                    return vendorService.getVendorByCompanyName(companyName);
                }

                @RequestMapping("/vendors/lookup/{email}")
                public List<Vendor> searchByEmail(@PathVariable("email") String email) {
                    return vendorService.getVendorByEmail(email);
                }
}
