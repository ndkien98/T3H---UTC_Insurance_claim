
package com.t3h.insuranceclaim.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customer")
@Getter
@Setter
public class CustomerEntity extends BaseEntity {

    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String bankNumber;
    private String bankName;

    public CustomerEntity() {

    }


    // Getters and Setters
}
