package com.litmus7.org.l7fcmockservices.config.security.repo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Getter
@Setter
public class AuthUser {

    @Id
    @Column(name = "user_name")
    private String username;
    @Column(name = "enc_password")
    private String encryptedPassword;
}
