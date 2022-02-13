package com.example.foodOrderApplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;


@Entity
public class Customer {
    @Id
    private String userName;
    @Column(nullable = false)
    private String name;
    private String address;
    private String password;
    @Column(nullable = false,unique = true)
    private String phoneNumber;
//    @OneToMany(mappedBy = "customer")
//    private List<Cart> cart;

    private String roles;

    public Customer() {
    }

    public Customer(String userName, String name, String address, String password,String phoneNumber,String roles) {
        this.userName = userName;
        this.name = name;
        this.address = address;
        this.password = password;
        this.phoneNumber=phoneNumber;
        this.roles=roles;
    }

//    public List<BookedSeats> getBookedSeats() {
//        return bookedSeats;
//    }
//
//    public void setBookedSeats(List<BookedSeats> bookedSeats) {
//        this.bookedSeats = bookedSeats;
//    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

//    public List<Cart> getCart() {
//        return cart;
//    }
//
//    public void setCart(List<Cart> cart) {
//        this.cart = cart;
//    }
}
