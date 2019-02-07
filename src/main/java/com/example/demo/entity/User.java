package com.example.demo.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column( name = "user_name")
    private String userName;

    @Column(name = "user_complete")
    private String userComplete;

    @Column(name = "birthdate")
    private String birthdate;

    @ManyToMany
    @JoinTable(name = "users_roles"
        ,joinColumns = @JoinColumn(name = "user_id")
        ,inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Rol> roles;

    public User() {
    }

    public User(String userName, String userComplete, String birthdate, Set<Rol> roles) {
        this.userName = userName;
        this.userComplete = userComplete;
        this.birthdate = birthdate;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserComplete() {
        return userComplete;
    }

    public void setUserComplete(String userComplete) {
        this.userComplete = userComplete;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userComplete='" + userComplete + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", roles=" + roles +
                '}';
    }
}
