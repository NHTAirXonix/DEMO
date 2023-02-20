package com.example.springmaven.service.impl;

import com.example.springmaven.dto.UserDTO;
import com.example.springmaven.model.User;
import com.example.springmaven.repository.IUserRepository;
import com.example.springmaven.service.IUserService;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Mapper
    public interface UserMapper {
        UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
        UserDTO userToUserDTO(User user);
    }

    public Page<UserDTO> convertToUserDTOPage(Page<User> userPage) {
        List<UserDTO> userDTOS = userPage.getContent()
                .stream()
                .map(p -> new UserDTO(
                        p.getId(),
                        p.getNameUser(),
                        p.getAddressUser(),
                        p.getPhoneUser(),
                        p.getBirthdayUser(),
                        p.getStatusObject()))
                .collect(Collectors.toList());
        return new PageImpl<>(userDTOS, userPage.getPageable(), userPage.getTotalElements());
    }

    @Override
    public ResponseEntity<UserDTO> removeUser(Long id) {
        User user = userRepository.findById(id).get();
        UserDTO userDto = UserMapper.INSTANCE.userToUserDTO(user);
        if (userDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            userRepository.deleteUser(id.toString());
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<Page<UserDTO>> findListUser(Pageable pageable) {
        Page<UserDTO> userDTOPage =  convertToUserDTOPage(userRepository.findAll(pageable));
        if (userDTOPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(userDTOPage, HttpStatus.OK);
        }
    }

    @Override
    public void addUser(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        userRepository.save(user);
    }

    @Override
    public ResponseEntity<UserDTO> updateUser(Long id,UserDTO userDTO) {
        if (userRepository.findById(id).isPresent()) {
            User userEdit = userRepository.findById(id).get();
            BeanUtils.copyProperties(userDTO,userEdit);
            userRepository.save(userEdit);
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<UserDTO> findByUser(Long id) {
        if (userRepository.findById(id).isPresent()) {
            UserDTO userDto = UserMapper.INSTANCE.userToUserDTO(userRepository.findById(id).get());
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Page<UserDTO>> searchUser(String name, String address, String phone, Pageable pageable) {
        Page<UserDTO> userDTOPage =  convertToUserDTOPage(userRepository.findAllUser(name, address, phone, pageable));
        if (userDTOPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(userDTOPage, HttpStatus.OK);
        }
    }
}
