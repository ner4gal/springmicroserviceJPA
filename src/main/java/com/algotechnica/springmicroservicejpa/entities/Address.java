package com.algotechnica.springmicroservicejpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Address {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(nullable = false, name = "ID")
    private String addressId;
    @Column(nullable = false, name = "ADDRESSTYPE")
    private String addressType;
    @Column(nullable = false, name = "STREET")
    private String street;
    @Column(nullable = false, name = "CITY")
    private String city;
    @Column(nullable = false, name = "STATE")
    private String state;
    @Column(nullable = false, name = "ZIP")
    private String zip;
    @Column(nullable = false, name = "COUNTRY")
    private String country;

    public Address() {
        this.addressId = "addressId";
        this.addressType = "addressType";
        this.street = "street";
        this.city = "city";
        this.state = "state";
        this.zip = "zip";
        this.country = "country";
    }

    public Address(String addressId, String street, String city, String state, String zip, String country ,String addressType) {
        this.addressId = addressId;
        this.addressType = addressType;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

}
