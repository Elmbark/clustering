package com.fdev.clustering.model;

import jakarta.persistence.*;


import java.io.Serializable;

@Entity
public class Cluster implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
