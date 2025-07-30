package com.example.wafaapp.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Setter
@MappedSuperclass
@Getter
@ToString
public class BaseEntity2 extends BaseEntity {
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public AadharCard getAadharCard() {
        return aadharCard;
    }

    public void setAadharCard(AadharCard aadharCard) {
        this.aadharCard = aadharCard;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "first-name", length=20)
    private String firstName;
    @Column(name = "last_name" , length = 20)
    private String lastName;
    @Column(name = "date_of_birth" , length = 20)
    private LocalDate dob;
    @Column(length = 20)
    private String gender;
    @Column(length = 30, unique = true)
    private String email;
    @Column
    private String password;
    @Column(name = "mobile_number" , length = 30)
    private String mobileNumber;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    @Embedded
    @JoinColumn(name = "aadhar_number")
    private AadharCard aadharCard;
    @Embedded
    @JoinColumn(name = "address")
    private Address address;

    private String imagePath;
//	 @Setter(value = AccessLevel.NONE)
//	 @OneToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
//		@JoinColumn(name = "address_id")
//	   	private Address address;

    public void addAddress(Address adr)
    {
        this.address=adr;
    }
}
