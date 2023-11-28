package com.example.gym.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "customer", schema = "pi_ag", catalog = "")
public class CustomerEntity {
    private Integer id;
//    @JsonIgnore
//    public CustomerEntity(Integer id, String firstname, String lastname, Date birthdate, Integer genderId) {
//        this.id = id;
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.birthdate = birthdate;
//        this.genderId = genderId;
//    }

    private String firstname;
    private String lastname;
    private Date birthdate;
    private Integer genderId;
    private GenderEntity gender;
    private CustomerSubscriptionEntity customerSubscription;



    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    @Column(name = "birthdate", nullable = true)
    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Basic
    @Column(name = "gender_id", nullable = false)
    public Integer getGenderId() {
        return genderId;
    }

    public void setGenderId(Integer genderId) {
        this.genderId = genderId;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity that = (CustomerEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(birthdate, that.birthdate) && Objects.equals(genderId, that.genderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, birthdate, genderId);
    }

    @ManyToOne()
    @JoinColumn(name = "gender_id", referencedColumnName = "id", nullable = false,insertable=false, updatable=false)
    public GenderEntity getGender() {
        return gender;
    }

    public void setGender(GenderEntity gender) {
        this.gender = gender;
    }

    @OneToOne(mappedBy = "customerByCustomerId",fetch = FetchType.LAZY)
    public CustomerSubscriptionEntity getCustomerSubscription() {
        return customerSubscription;
    }

    public void setCustomerSubscription(CustomerSubscriptionEntity customerSubscription) {
        this.customerSubscription = customerSubscription;
    }

}
