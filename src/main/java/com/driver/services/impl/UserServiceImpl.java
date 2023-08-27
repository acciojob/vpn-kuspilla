package com.driver.services.impl;

import com.driver.model.Country;
import com.driver.model.CountryName;
import com.driver.model.ServiceProvider;
import com.driver.model.User;
import com.driver.repository.CountryRepository;
import com.driver.repository.ServiceProviderRepository;
import com.driver.repository.UserRepository;
import com.driver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository3;
    @Autowired
    ServiceProviderRepository serviceProviderRepository3;
    @Autowired
    CountryRepository countryRepository3;

    @Override
    public User register(String username, String password, String countryName) throws Exception{

        User user = new User();
        if(countryName.equalsIgnoreCase("IND") || countryName.equalsIgnoreCase("AUS") || countryName.equalsIgnoreCase("CHI") ||
                countryName.equalsIgnoreCase("JPN") || countryName.equalsIgnoreCase("USA") ){
            user.setPassword(password);
            user.setUserName(username);

            Country country =new Country();
            if( countryName.equalsIgnoreCase("IND")){
                country.setCountryName("IND");
                country.setCodes(CountryName.IND.toCode());
            }
            if( countryName.equalsIgnoreCase("AUS")){
                country.setCountryName("AUS");
                country.setCodes(CountryName.AUS.toCode());
            }
            if( countryName.equalsIgnoreCase("CHI")){
                country.setCountryName("CHI");
                country.setCodes(CountryName.CHI.toCode());
            }
            if( countryName.equalsIgnoreCase("JPN")){
                country.setCountryName("JPN");
                country.setCodes(CountryName.JPN.toCode());
            }
            if( countryName.equalsIgnoreCase("USA")){
                country.setCountryName("USA");
                country.setCodes(CountryName.USA.toCode());
            }

            country.setUser(user);
            user.setConnected(false);
            user.setCountry(country);
            String code = country.getCodes()+"."+userRepository3.save(user).getId();
            user.setOriginalIp(code);

            userRepository3.save(user);

        }
        else{
            throw new Exception("Country not found");
        }

        return user;
    }

    @Override
    public User subscribe(Integer userId, Integer serviceProviderId) {
        User user = userRepository3.findById(userId).get();
        ServiceProvider serviceProvider = serviceProviderRepository3.findById(serviceProviderId).get();

        user.getServiceProviderList().add(serviceProvider);
        serviceProvider.getUserList().add(user);

        serviceProviderRepository3.save(serviceProvider);
         return user;
    }
}
