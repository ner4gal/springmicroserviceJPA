package com.algotechnica.springmicroservicejpa.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algotechnica.springmicroservicejpa.entities.Vendor;

@Repository
public interface IVendorPersistence extends JpaRepository<Vendor, String> {

}
