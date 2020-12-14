package com.rentpal.accounts.controller;

/*
 * @author frank
 * @created 12 Dec,2020 - 3:02 AM
 */

import com.rentpal.accounts.common.Utils;
import com.rentpal.accounts.model.APIRequestResponse;
import com.rentpal.accounts.model.User;
import com.rentpal.accounts.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    /** The user service. */
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService=userService;
    }

    /** Trims the request parameters **/
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addUser(@RequestBody User user){
        return new ResponseEntity<>(userService.addOAuthUser(user), HttpStatus.OK);
    }

    @GetMapping(value = "/user")
    public ResponseEntity<Object> getUser() {
        return new ResponseEntity<>(userService.getUser(), HttpStatus.OK);
    }
}
