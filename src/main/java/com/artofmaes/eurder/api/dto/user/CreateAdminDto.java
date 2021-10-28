package com.artofmaes.eurder.api.dto.user;

public class CreateAdminDto {
    private final String firstName;
    private final String lastName;
    private final String mailAddress;
    private final String street;
    private final String streetNumber;
    private final String postalCode;
    private final String city;
    private final String phoneNumber;

    public CreateAdminDto(String firstName, String lastName, String mailAddress, String street, String streetNumber, String postalCode, String city, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mailAddress = mailAddress;
        this.street = street;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
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
}
