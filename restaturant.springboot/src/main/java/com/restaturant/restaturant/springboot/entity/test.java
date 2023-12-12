package com.restaturant.restaturant.springboot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "test")
public class test {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private  String name;

    private String address;

    private String email;

    private String phone;

    private String password;

    private String role;

    private String status;
}
