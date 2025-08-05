package com.example.wafaapp.dto.req;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.example.wafaapp.customValidator.AgeConstraint;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountReqDto {
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public long getBranchId() {
        return branchId;
    }

    public void setBranchId(long branchId) {
        this.branchId = branchId;
    }

    public double getMaxTransactionAmount() {
        return maxTransactionAmount;
    }

    public void setMaxTransactionAmount(double maxTransactionAmount) {
        this.maxTransactionAmount = maxTransactionAmount;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    @NotBlank(message = "First name data must be required")
    @Length(max = 30,min = 3)
    private String firstName;
    @Length(max = 30)
    private String lastName;
    @NotBlank(message = "phone number data must be required")
    @Length(max = 12)
    @Pattern(regexp = "^(?:(?:\\+|0{0,2})91(\\s*[\\-]\\s*)?|[0]?)?[789]\\d{9}$")
    private String mobileNumber;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull
    @Past(message = "Date of Birth must be in the past")
    @AgeConstraint(value = 16, message = "Sorry!! You must be atleast 16 years old")
    private LocalDate dob;
    @NotBlank(message = "Gender must required")
    private String gender;
    @Email
    @NotBlank
    private String email;
    @Pattern(regexp = "/^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/")
    private String password;

    private double balance;
    @NotBlank(message =  "Account type should not be left blank")
    private String accountType;

    private MultipartFile image;
    @NotNull
    private long branchId;
    @Max(value = 25000,message = "Max one time transafer is 250000 only")
    private double maxTransactionAmount = 10000.00;

    @NotBlank(message = "street data must be required")
    @Length(max = 30,min = 3)
    private String street;
    @NotBlank(message = "city data must be required")
    @Length(max = 10,min = 3)
    private String city;
    @NotBlank(message = "state data must be required")
    @Length(max = 10,min = 3)
    private String state;
    @NotBlank(message = "country data must be required")
    @Length(max = 10,min = 3)
    private String country;
    @NotBlank
    @Pattern(regexp = "^\\d{6}(?:[-\\s]\\d{4})?$")
    private String zipCode;
    @NotBlank(message  = "Must be filled")
    @Pattern(regexp = "^[2-9]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4}$")
    private String cardNumber;
    @NotBlank(message = "Location as per aadhar card")
    private String location;
    @NotNull
    @Past(message = "Aadhar card must be created in past")
    private LocalDate createdOn;
}
