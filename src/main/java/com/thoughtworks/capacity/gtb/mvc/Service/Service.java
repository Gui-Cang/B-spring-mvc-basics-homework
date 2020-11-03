package com.thoughtworks.capacity.gtb.mvc.Service;

import com.thoughtworks.capacity.gtb.mvc.domain.User;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    private List<User> userList= new ArrayList<>();
    public Service() {
        userList.add( new User("1111", "BMV", "white"));
        userList.add( new User("1111", "BMV", "white"));
    }

}
