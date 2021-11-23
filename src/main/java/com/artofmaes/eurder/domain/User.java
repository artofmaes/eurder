package com.artofmaes.eurder.domain;

import java.util.Objects;
import java.util.UUID;

import com.artofmaes.eurder.domain.exceptions.InvalidMailException;
import org.apache.commons.validator.routines.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

@Entity
@Table(name = "eurder_user")
public class User {

    @Transient
    private final Logger logger = LoggerFactory.getLogger(User.class);

    @Id
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    private int userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "add_street")
    private String street;

    @Column(name = "add_housenumber")
    private String streetNumber;

    @Column(name = "add_postcode")
    private String postalCode;

    @Column(name = "add_city")
    private String city;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email_add")
    private String mailAddress;

    @Column(name = "is_admin")
    private boolean admin;

    public User() {
    }

    public User(String firstName, String lastName, String mailAddress, String street, String streetNumber, String postalCode, String city, String phoneNumber, boolean admin) {
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

    public Logger getLogger() {
        return logger;
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


    public static final class Builder {
        private String street;
        private String streetNumber;
        private String city;
        private String phoneNumber;
        private boolean admin;
        private String firstName;
        private String lastName;
        private String postalCode;
        private String mailAddress;

        public Builder withStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder withStreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
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

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder withMailAddress(String mailAddress) {
            this.mailAddress = mailAddress;
            return this;
        }

        public User build() {
            return new User(firstName, lastName, mailAddress, street, streetNumber, postalCode, city, phoneNumber, admin);
        }
    }
}
