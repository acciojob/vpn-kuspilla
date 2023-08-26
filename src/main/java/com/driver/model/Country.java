package com.driver.model;


import javax.persistence.*;

@Table
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String companyName;
    private String codes;

    @OneToOne(mappedBy = "User",cascade = CascadeType.ALL)
    User user;

    @ManyToOne
    @JoinColumn(name = "serviceProvider")
    ServiceProvider serviceProvider;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCodes() {
        return codes;
    }

    public void setCodes(String codes) {
        this.codes = codes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }
}
