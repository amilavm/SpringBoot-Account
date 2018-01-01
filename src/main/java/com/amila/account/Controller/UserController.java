package com.amila.account.Controller;

import com.amila.account.Model.UserAccount;
import com.amila.account.Repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @RequestMapping(value = "/welcome")
    public String welcomePage(){
        return "welcome spring boot";
    }

    /*retrieve all users*/
    @RequestMapping(value = "/user")
    public ResponseEntity<List<UserAccount>> displayAllUsers(){
        List<UserAccount> users = userAccountRepository.findAll();
        if(users.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<UserAccount>>(users, HttpStatus.OK);
    }

    /*retrieve single user*/
    @RequestMapping(value = "/user/{id}")
    public ResponseEntity<?> displaySingleUser(@PathVariable("id") Integer id){
        UserAccount user = userAccountRepository.findById(id);
        if(user == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<UserAccount>(user, HttpStatus.OK);
    }

    /*create user*/
    @RequestMapping(value = "/user" , method = RequestMethod.POST)
    public ResponseEntity<UserAccount> createUser(@RequestBody UserAccount userAccount){
        UserAccount usr = this.userAccountRepository.save(userAccount);
        return new ResponseEntity<UserAccount>(usr, HttpStatus.OK);
    }
}
