package com.thoughtworks.capacity.gtb.mvc.api;

import com.thoughtworks.capacity.gtb.mvc.Service.Service;
import com.thoughtworks.capacity.gtb.mvc.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
public class Controller {

    private final Service service;
    private List<User> userList2= initUsers();
    private List<User> initUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("sdasd", "assdd", "add@sdf.com"));
        return users;
    }

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/list2")
    public List<User> getAllCounts2() {
      return userList2;
        //  return service.getAll();
    }

    @GetMapping("/list")
    public List<User> getAllCounts() {
        return service.getAll();
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody @Valid User user) {
        service.creatUser(user);
    }


}
