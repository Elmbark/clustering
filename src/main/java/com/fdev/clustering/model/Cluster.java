package com.fdev.clustering.model;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Cluster")
public class Cluster implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}

