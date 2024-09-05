package com.algotechnica.springmicroservicejpa.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.algotechnica.springmicroservicejpa.entities.Vendor;

@Repository
public interface IVendorPersistence extends JpaRepository<Vendor, String> {

    List<Vendor> findByCompanyName(String companyName);

    @Query(nativeQuery = true, value = "SELECT * FROM public.vendors WHERE email  like 1?   ")
    List<Vendor> findByEmail(String email);

    

}
