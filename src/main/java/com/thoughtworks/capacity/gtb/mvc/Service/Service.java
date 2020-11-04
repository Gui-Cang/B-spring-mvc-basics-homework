package com.thoughtworks.capacity.gtb.mvc.Service;

import com.thoughtworks.capacity.gtb.mvc.domain.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    private List<User> userList = new ArrayList<>();

    public Service() {
        userList.add(new User("1111", "BMV", "white"));
        userList.add(new User("2222", "BMV", "white"));
    }

    public void creatUser(User user) {
//        Iterator iter = userList.iterator();
//        while (iter.hasNext()) {
//            User userExisted = (User) iter.next();
//            if (userExisted.getUsername().equals(user.getUsername())) {
//                continue;
//            } else {
//                userList.add(new User(user.getUsername(), user.getPassword(), user.getEmail()));
//            }
//        }
        userList.add(new User(user.getUsername(), user.getPassword(), user.getEmail()));
    }

    public List<User> getAll() { return userList;}
}
