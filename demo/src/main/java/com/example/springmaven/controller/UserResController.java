package com.example.springmaven.controller;

import com.example.springmaven.dto.UserDTO;
import com.example.springmaven.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserResController {
    @Autowired
    private IUserService iuserService;

    @GetMapping("/listUser")
    @ResponseBody
    public ResponseEntity<Page<UserDTO>> showListUser(@RequestParam(defaultValue = "0") int page) {
        return iuserService.findListUser(PageRequest.of(page, 5));
    }

    @PostMapping("/addUser")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
        iuserService.addUser(userDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/findUserId/{id}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable Long id){
        return iuserService.findByUser(id);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable Long id){
        return iuserService.removeUser(id);
    }

    @PatchMapping("/editUser/{id}")
    public ResponseEntity<UserDTO> editUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return iuserService.updateUser(id, userDTO);
    }

    @GetMapping("/searchUser")
    public ResponseEntity<Page<UserDTO>> searchUser(@RequestParam String name, @RequestParam String address,
            @RequestParam String phone, @RequestParam(defaultValue = "0") int page) {
        return iuserService.searchUser(name, address, phone, PageRequest.of(page, 5));
    }


    // REST API
    // MAP STRUCT
    // SWAGGER
    // STATUS DELETE
    // HARD DELETE
}
