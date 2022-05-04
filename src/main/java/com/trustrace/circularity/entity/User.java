package com.trustrace.circularity.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {

    @Id
    private Long id;
    private String password;
    private String role;
    private String username;
}
