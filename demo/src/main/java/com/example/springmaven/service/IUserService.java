package com.example.springmaven.service;

import com.example.springmaven.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface IUserService {

    ResponseEntity<Page<UserDTO>> findListUser(Pageable pageable);

    void addUser(UserDTO userDTO);

    ResponseEntity<UserDTO> removeUser(Long id);

    ResponseEntity<UserDTO> updateUser(Long id,UserDTO userDTO);

    ResponseEntity<UserDTO> findByUser(Long id);

    ResponseEntity<Page<UserDTO>> searchUser(String name,String address, String phone, Pageable pageable);
}
