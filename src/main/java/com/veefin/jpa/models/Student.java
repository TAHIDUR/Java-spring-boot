package com.veefin.jpa.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "student")
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String StudentName;
    @Column(name = "class")
    private Integer StudentClass;
    private String Division;
    private LocalDateTime JoiningDate;
    private Integer isActive;
}
