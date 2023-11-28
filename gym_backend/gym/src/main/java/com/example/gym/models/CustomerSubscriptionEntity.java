package com.example.gym.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "customer_subscription", schema = "pi_ag")
public class CustomerSubscriptionEntity {
    private Integer customerId;
    private Integer subscriptionId;
    private Date startDate;
    private Date endDate;
    private CustomerEntity customerByCustomerId;
    private SubscriptionEntity subscriptionBySubscriptionId;

    @Id
    @Column(name = "customer_id", nullable = false)
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "subscription_id", nullable = false)
    public Integer getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Integer subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    @Basic
    @Column(name = "start_date", nullable = true)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date", nullable = true)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerSubscriptionEntity that = (CustomerSubscriptionEntity) o;
        return Objects.equals(customerId, that.customerId) && Objects.equals(subscriptionId, that.subscriptionId) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, subscriptionId, startDate, endDate);
    }

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false,insertable=false, updatable=false)
    public CustomerEntity getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(CustomerEntity customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "subscription_id", referencedColumnName = "id", nullable = false,insertable=false, updatable=false)
    public SubscriptionEntity getSubscriptionBySubscriptionId() {
        return subscriptionBySubscriptionId;
    }

    public void setSubscriptionBySubscriptionId(SubscriptionEntity subscriptionBySubscriptionId) {
        this.subscriptionBySubscriptionId = subscriptionBySubscriptionId;
    }
}
