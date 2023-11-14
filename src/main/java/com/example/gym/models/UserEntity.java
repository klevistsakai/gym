package com.example.gym.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "user", schema = "pi_ag", catalog = "")
public class UserEntity {
    private int id;
    private String username;
    private String passwordHash;
    private String firstname;
    private String lastname;
    private int genderId;
    private Byte validated;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 32)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password_hash", nullable = false, length = 64)
    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Basic
    @Column(name = "firstname", nullable = false, length = 20)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "lastname", nullable = false, length = 20)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "gender_id", nullable = false)
    public int getGenderId() {
        return genderId;
    }

    public void setGenderId(int genderId) {
        this.genderId = genderId;
    }

    @Basic
    @Column(name = "validated", nullable = true)
    public Byte getValidated() {
        return validated;
    }

    public void setValidated(Byte validated) {
        this.validated = validated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id == that.id && genderId == that.genderId && Objects.equals(username, that.username) && Objects.equals(passwordHash, that.passwordHash) && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(validated, that.validated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, passwordHash, firstname, lastname, genderId, validated);
    }
}
