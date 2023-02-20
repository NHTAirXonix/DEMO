package com.example.springmaven.repository;

import com.example.springmaven.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IUserRepository extends JpaRepository<User, Long> {

    Page<User> findUserByNameUserContainingAndAddressUserContainingAndPhoneUserContaining(
            String name, String address, String phone, Pageable pageable);

    @Query(value = "select * from user " +
            "where status_object = 'on' " +
            "and product_name like %:name% " +
            "and phone_user like %:phone% " +
            "and address_user like %:address% ", nativeQuery = true)
    Page<User> findAllUser(@Param("name") String name,
                           @Param("phone") String phone,
                           @Param("address") String address,
                           Pageable pageable);

    @Modifying
    @Query(value = "update  user set status_object = 'off' where id = :id", nativeQuery = true)
    void deleteUser(@Param("id") String id);

}
