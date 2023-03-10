package com.practice.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Sell implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int date;
    private int time;
    private int sumOfPrice;

    @OneToMany( mappedBy = "sell", cascade = CascadeType.ALL)
    @JsonManagedReference
    List<SellDetail> sellDetails;

    public Sell() {
    }

    public Sell(long id, int date, int time, int sumOfPrice, List<SellDetail> sellDetails) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.sumOfPrice = sumOfPrice;
        this.sellDetails = sellDetails;
    }

    public long getId() {
        return id;
    }

    public void setId(long sellId) {
        this.id = sellId;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getSumOfPrice() {
        return sumOfPrice;
    }

    public void setSumOfPrice(int sumOfPrice) {
        this.sumOfPrice = sumOfPrice;
    }

    public List<SellDetail> getSellDetails() {
        return sellDetails;
    }

    public void setSellDetails(List<SellDetail> sellDetails) {
        this.sellDetails = sellDetails;
    }
}
