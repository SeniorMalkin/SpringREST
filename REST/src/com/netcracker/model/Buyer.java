package com.netcracker.model;

import javax.persistence.*;

@Entity
@Table(name = "buyer")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private int id;
    @Column(name = "surname",nullable = false)
    private String surname;
    @Column(name = "district", nullable = false)
    private String district;
    @Column(name = "discount",nullable = false)
    private int discount;

    public Buyer() {
    }

    public Buyer(String surname, String district, int discount) {
        this.surname = surname;
        this.district = district;
        this.discount = discount;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
