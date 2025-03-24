package com.maven_smart_logistics.smart_logistics.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "role")
@Getter
@Setter
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, unique = true)
    private Long id;


    @Column(nullable = false)
    private String name;


    private String description;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;


}
