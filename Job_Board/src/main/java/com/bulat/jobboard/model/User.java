package com.bulat.jobboard.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Just a registered user
 * @author Bulat Bilalov
 * @version 1.0
 * @see com.bulat.jobboard.model.BaseEntity
 * @see db.changelog/db.changelog-1.0.xml
 */
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User extends BaseEntity{

    /** User display name */
    @Column(name = "nickname")
    private String nickname;

    /** Contact information (mail) */
    @Column(name = "email")
    private String email;

    /** Hashed user password */
    @Column(name = "password")
    private String password;

    /** Unique key to verify your account */
    @Column(name = "token", length = 500)
    private String token;

    /** Role having users */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;

    /**
     * Constructor for testing spring security
     * @param email The mail that the user specified during registration
     * @param password Hashed password specified during registration
     */
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
