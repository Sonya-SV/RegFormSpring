package com.training.regform.spring.config.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

@Entity
@Table(name = "users",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Pattern(regexp = "^[a-zA-Z0-9]{3,20}$",
            message = "Username  must  be  between  3  and  20  characters  long")
    @Column(name = "username", nullable = false)
    private String username;


    @Pattern(regexp = "([А-ЩЬЮЯЇІЄҐа-щьюяїієґ']{3,20})|([A-Za-z]{3,20})",
            message = "First name  must  be  between  3  and  20  characters  long")
    @Column(name = "first_name", nullable = false)
    private String firstName;


    @Pattern(regexp = "([А-ЩЬЮЯЇІЄҐа-щьюяїієґ']{3,20})|([A-Za-z]{3,20})",
            message = "Last  name must  be  between  3  and  20  characters  long")
    @Column(name = "last_name", nullable = false)
    private String lastName;


//    @Pattern(regexp = "^(?=.*\\d)(?=.*[A-Za-z])[0-9a-zA-Z]{6,}$",
//@Pattern(regexp = "^[a-zA-zА-ЩЬЮЯЇІЄҐа-щьюяїієґ0-9]{6,}$",
//            message = "Password should contain at least 6 characters," +
//            "at least 1 digit, and 1 letter")
    @NotBlank(message = "Password cannot be empty")
    @Column(name = "password", nullable = false)
    private String password;

    @Transient
    @NotBlank(message = "Password cannot be empty")
    private String password2;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
