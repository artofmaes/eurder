package com.artofmaes.eurder.domain;

import java.util.Objects;
import java.util.UUID;

import com.artofmaes.eurder.domain.exceptions.InvalidMailException;
import org.apache.commons.validator.routines.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {

    private final String userId;
    private final String street;
    private final String streetNumber;
    private final String city;
    private final String phoneNumber;
    private final Logger logger = LoggerFactory.getLogger(User.class);

    private boolean admin;
    private String firstName;
    private String lastName;
    private String postalCode;
    private String mailAddress;

    public User(String firstName, String lastName, String mailAddress, String street, String streetNumber, String postalCode, String city, String phoneNumber, boolean admin) {
        this.userId = UUID.randomUUID().toString();
        this.street = street;
        this.streetNumber = streetNumber;
        this.city = city;
        this.phoneNumber = phoneNumber;
        setAdminStatus(admin);
        setFirstName(firstName);
        setLastName(lastName);
        setPostalCode(postalCode);
        setMailAddress(mailAddress);
    }

    public void setMailAddress(String mailAddress) {
        if (!EmailValidator.getInstance().isValid(mailAddress)) {
            logger.error("Mail is incorrect!");
            throw new InvalidMailException("Invalid Email");
        }
        this.mailAddress = mailAddress;
    }

    public void setFirstName(String firstName) {
        checkIfEmpty(firstName, "First name");
        this.firstName = firstName;
    }


    public void setLastName(String lastName) {
        checkIfEmpty(lastName, "Last name");
        this.lastName = lastName;
    }

    public void setPostalCode(String postalCode) {
        checkIfEmpty(postalCode, "Postal code");
        this.postalCode = postalCode;
    }

    public void setAdminStatus(boolean adminStatus){
        this.admin = adminStatus;
    }

    private void checkIfEmpty(String itemToValidate, String item) {
        if (itemToValidate.isEmpty() || itemToValidate.isBlank()) {
            logger.error(item + " required!");
            throw new IllegalArgumentException(item + " required");
        }
    }

    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public String getStreet() {
        return street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isAdmin() {
        return admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(mailAddress, user.mailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mailAddress);
    }
}
