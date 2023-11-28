package com.example.gym.models;

import jakarta.persistence.*;

import java.math.BigInteger;

import java.util.Objects;

@Entity
@Table(name = "subscription", schema = "pi_ag")
public class SubscriptionEntity {
    private Integer id;
    private String planName;
    private Integer duration;
    private BigInteger cost;



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
    @Column(name = "plan_name", nullable = false, length = 32)
    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    @Basic
    @Column(name = "duration", nullable = false)
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "cost", nullable = false, precision = 0)
    public BigInteger getCost() {
        return cost;
    }

    public void setCost(BigInteger cost) {
        this.cost = cost;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscriptionEntity that = (SubscriptionEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(planName, that.planName) && Objects.equals(duration, that.duration) && Objects.equals(cost, that.cost);
    }



}
