package com.algotechnica.springmicroservicejpa.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algotechnica.springmicroservicejpa.entities.Address;


@Repository
public interface IAddressPersistence extends JpaRepository<Address, String> {

}
