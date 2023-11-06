package com.example.models;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class CustomerSubscriptionEntityPK implements Serializable {
    private int customerId;
    private int subscriptionId;

    @Column(name = "customer_id", nullable = false)
    @Id
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Column(name = "subscription_id", nullable = false)
    @Id
    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerSubscriptionEntityPK that = (CustomerSubscriptionEntityPK) o;
        return customerId == that.customerId && subscriptionId == that.subscriptionId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, subscriptionId);
    }
}
