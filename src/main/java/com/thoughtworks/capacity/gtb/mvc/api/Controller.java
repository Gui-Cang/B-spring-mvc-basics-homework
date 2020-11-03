package com.thoughtworks.capacity.gtb.mvc.api;
import com.thoughtworks.capacity.gtb.mvc.Service.Service;


@org.springframework.stereotype.Controller
public class Controller {
    private final Service service;
    public Controller(Service service) {this.service = service;}
}
