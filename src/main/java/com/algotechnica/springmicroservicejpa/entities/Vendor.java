package com.algotechnica.springmicroservicejpa.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
@Table(name = "vendors")
public class Vendor {
    @SuppressWarnings("deprecation")
    @Id
    @Column(nullable = false, name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String code;
    @Column(nullable = false, name = "COMPANY_NAME")
    private String companyName;
    @Column(nullable = false, name = "CONTACT_PERSON")
    private String contactPerson;
    @Column(nullable = false, name = "FIRST_NAME")
    private String firstName;
    @Column(nullable = false, name = "LAST_NAME")
    private String lastName;
    @Column(nullable = false, name = "EMAIL")
    private String email;
    @Column(nullable = false, name = "WEBSITE")
    private String website;
    @Column(nullable = false, name = "STATUS")
    private Integer status;
    @Column(nullable = false, name = "REG_DATE")
    private Date regDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "VENDOR_ID", referencedColumnName = "ID")
    private List<Address> addresses = new ArrayList<Address>();

    public Vendor() {
        this.code = "code";
        this.companyName = "companyName";
        this.contactPerson = "contactPerson";
        this.firstName = "firstName";
        this.lastName = "lastName";
        this.email = "email";
        this.website = "website";
        this.status = 0;
        this.regDate = new Date();
        this.addresses = new ArrayList<Address>();
    }
    public Vendor(String code, String companyName, String contactPerson, String firstName, String lastName,
            String email, String website, Integer status, Date regDate, List<Address> addresses) {
        this.code = code;
        this.companyName = companyName;
        this.contactPerson = contactPerson;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.website = website;
        this.status = status;
        this.regDate = regDate;
        this.addresses = addresses;
    }


    public Vendor(String code, String companyName, String contactPerson, String firstName, String lastName) {
        this.code = code;
        this.companyName = companyName;
        this.contactPerson = contactPerson;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = this.firstName + "." + this.lastName + "@" + this.companyName + "gmail.com";
        this.website = "www." + this.companyName + ".com";
        this.status = 0;
        this.regDate = new Date();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "Vendor [ Code : " + getCode() + ",  CompanyName : " + getCompanyName()
                + ", getContactPerson : " + getContactPerson() + ", getFirstName :" + getFirstName()
                + ", getLastName : " + getLastName() + ", getEmail : " + getEmail() + ", getWebsite :"
                + getWebsite() + ", getStatus : " + getStatus() + ", getRegDate : " + getRegDate()
                + ", getClass : " + getClass() + "]";
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

}