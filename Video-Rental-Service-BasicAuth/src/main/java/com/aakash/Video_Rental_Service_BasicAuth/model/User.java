package com.aakash.Video_Rental_Service_BasicAuth.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.aakash.Video_Rental_Service_BasicAuth.model.enums.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="User_Details")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

     /*
     * Indicates whether the user's account has expired.
     * In this case, it always returns true, meaning the account is not expired.
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

     /*
     * Checks if the user's account is locked (e.g., due to multiple failed login attempts).
     * Returning true means the account is not locked and the user can log in.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

     /*
     * Indicates whether the user's credentials (password) have expired.
     * In this case, it always returns true, meaning the credentials are not expired.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

     /*
     * Indicates whether the user's account is enabled and can be used for authentication.
     * Returning true means the account is enabled, and the user is allowed to log in.
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
