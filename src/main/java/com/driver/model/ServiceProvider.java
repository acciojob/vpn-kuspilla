package com.driver.model;

import javax.persistence.*;
import java.util.List;

@Table
public class ServiceProvider {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,unique = true)
    private String name ;

    @ManyToMany
    @JoinColumn(name = "admin")
    Admin admin;

    @ManyToMany( mappedBy = "ServiceProvider",cascade = CascadeType.ALL)
    List<User> userList;

    @OneToMany(mappedBy = "ServiceProvider",cascade = CascadeType.ALL)
    List<Connection>  connectionList;

    @OneToMany(mappedBy = "ServiceProvider", cascade = CascadeType.ALL)
    List<Country> countryList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Connection> getConnectionList() {
        return connectionList;
    }

    public void setConnectionList(List<Connection> connectionList) {
        this.connectionList = connectionList;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }
}
