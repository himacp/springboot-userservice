package com.stackroute.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
public class User {
    @Id
    int id;
    String firstName;
    String lastName;
    int age;
}


