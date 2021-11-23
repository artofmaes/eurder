package com.artofmaes.eurder.api.dto.user;

public class UserDto {
    private final int userId;
    private final String firstName;
    private final String lastName;
    private final String mailAddress;
    private final String street;
    private final String streetNumber;
    private final String postalCode;
    private final String city;
    private final String phoneNumber;
    private final boolean admin;

    public UserDto(int userId, String firstName, String lastName, String mailAddress, String street, String streetNumber, String postalCode, String city, String phoneNumber, boolean admin) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mailAddress = mailAddress;
        this.street = street;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.admin = admin;
    }

    public int getUserId() {
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


    public static final class Builder {
        private int userId;
        private String firstName;
        private String lastName;
        private String mailAddress;
        private String street;
        private String streetNumber;
        private String postalCode;
        private String city;
        private String phoneNumber;
        private boolean admin;

        public Builder withUserId(int userId) {
            this.userId = userId;
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withMailAddress(String mailAddress) {
            this.mailAddress = mailAddress;
            return this;
        }

        public Builder withStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder withStreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public Builder withPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder withCity(String city) {
            this.city = city;
            return this;
        }

        public Builder withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder withAdmin(boolean admin) {
            this.admin = admin;
            return this;
        }

        public UserDto build() {
            return new UserDto(userId, firstName, lastName, mailAddress, street, streetNumber, postalCode, city, phoneNumber, admin);
        }
    }
}
