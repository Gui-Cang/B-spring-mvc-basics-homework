package com.thoughtworks.capacity.gtb.mvc.api;

import com.thoughtworks.capacity.gtb.mvc.Service.Service;
import com.thoughtworks.capacity.gtb.mvc.domain.User;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;


@RestController
@Validated
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
    public User logIn(@RequestParam @NotNull @Length(min = 3, max = 10, message = "用户名长度错误") @Pattern(regexp = "\\w*", message = "用户名只能由字母、数字或下划线组成") String username,
                      @RequestParam @NotNull @Length(min = 5, max = 12, message = "密码长度错误") String password) {
        return service.signIn(username, password);
    }

}
