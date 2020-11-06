package com.thoughtworks.capacity.gtb.mvc.Service;

import com.thoughtworks.capacity.gtb.mvc.Exception.UsernameExistedException;
import com.thoughtworks.capacity.gtb.mvc.domain.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@org.springframework.stereotype.Service
public class Service {
    private List<User> userList = new ArrayList<>();

    public Service() {
        userList.add(new User(1, "1111", "BMV", "white@123.com"));
        userList.add(new User(2, "foo", "bar", "white@123.com"));
    }

    public boolean usernameIsContained(User user) {
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
        if (!usernameIsContained(user)) {
            userList.add(new User(userList.size() + 1, user.getUsername(), user.getPassword(), user.getEmail()));
        } else {
            throw new UsernameExistedException("用户名已存在");
        }
    }

    public List<User> getAll() {
        return userList;
    }

    public User getByUsername(String username) {
        User userGet = new User();
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                userGet = user;
            }
        }
        return userGet;
    }

    public User signIn(String usernameWeb, String passwordWeb) {
        User userSignIn = new User();
        for (User user : userList) {
            if ((user.getUsername().equals(usernameWeb)) && (user.getPassword().equals(passwordWeb))) {
                userSignIn = getByUsername(usernameWeb);
            }
        }
        return userSignIn;
    }
}
