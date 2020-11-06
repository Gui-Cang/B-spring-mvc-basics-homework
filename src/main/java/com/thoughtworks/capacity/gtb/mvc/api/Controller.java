package com.thoughtworks.capacity.gtb.mvc.api;

import com.thoughtworks.capacity.gtb.mvc.Service.Service;
import com.thoughtworks.capacity.gtb.mvc.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class Controller {

    private final Service service;


    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/list")
    @ResponseBody
    public List<User> getAllCounts() {
        return service.getAll();
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody @Valid User user) {
        service.createUser(user);
    }

    @GetMapping("/login")
    public User singIn(@RequestParam(name = "usernameWeb") String usernameWeb, @RequestParam(name = "passwordWeb")String passwordWeb) {
        return service.signIn(usernameWeb, passwordWeb);
    }


}
