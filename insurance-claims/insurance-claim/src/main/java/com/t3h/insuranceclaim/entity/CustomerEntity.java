
package com.t3h.insuranceclaim.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "customer")
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
