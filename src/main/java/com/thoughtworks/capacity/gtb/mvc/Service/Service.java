package com.thoughtworks.capacity.gtb.mvc.Service;

import com.thoughtworks.capacity.gtb.mvc.domain.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@org.springframework.stereotype.Service
public class Service {
    private List<User> userList = new ArrayList<>();

    public Service() {
        userList.add(new User("1111", "BMV", "white"));
        userList.add(new User("2222", "BMV", "white"));
    }

    public boolean usenameIsContained(User user) {
        ArrayList<String> usernameList = new ArrayList<>();
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            User nexUser = iterator.next();
            usernameList.add(nexUser.getUsername());
        }
        boolean usernameStatus = false;
        for (String username : usernameList) {
            if (username.equals(user.getUsername())) {
                usernameStatus = true;
                break;
            }
        }
        return usernameStatus;
    }

    public void createUser(User user) {
//        Iterator iter = userList.iterator();
//        while (iter.hasNext()) {
//            User userExisted = (User) iter.next();
//            if (!userExisted.getUsername().equals(user.getUsername())) {
//                userList.add(new User(user.getUsername(), user.getPassword(), user.getEmail()));
//            }
//        }
//
//        userList.add(new User(user.getUsername(), user.getPassword(), user.getEmail()));

//        for (User userExisted : userList) {
//            if (!userExisted.getUsername().equals(user.getUsername())) {
//                userList.add(new User(user.getUsername(), user.getPassword(), user.getEmail()));
//            }
//        }

        ListIterator iter = userList.listIterator();
        while (iter.hasNext()) {
            User userExisted = (User) iter.next();
            if (!usenameIsContained(user)) {
                iter.add(new User(user.getUsername(), user.getPassword(), user.getEmail()));
            }
        }

    }

    public List<User> getAll() {
        return userList;
    }

    public User signIn(User user) {

        return user;
    }
}
