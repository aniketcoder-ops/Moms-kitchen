package com.example.Momskitchen.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity  //The entity annotation is used to declare that this particular class should be store in DB.
@Table(name="users")  //This can be used to name the table.
@Getter  //As if the Attributes defined under would be private hence we would require getter setter.
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id   //This will make this particular attribute as the Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //Auto_incrementation of the UserId
    private int userId;

    @Column(name="User_name",nullable=false)  //No username cannot be null
    private String name;

    @Column(unique = true, nullable=false)  //It means every user email will be unique and cannot be null.
    private String email;

    @Column(nullable=false) //Means the password cannot be null.
    private String password;

    private String phone;

    private LocalDate dob;

    private String profilePhoto;

    private LocalDateTime createdAt;

    private boolean isActive;

    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
        this.isActive = true;
    }

    @ManyToMany(fetch = FetchType.EAGER)  //this fetches the id immediately as if we
    @JoinTable(                           //we it instant for security login
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

}
