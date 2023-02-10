package com.example.springmaven.controller;

import com.example.springmaven.dto.PersonDto;
import com.example.springmaven.model.MyUser;
import com.example.springmaven.model.QMyUser;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@RestController
@RequestMapping("test")
public class QueryDSLController {


    @GetMapping("/abc")
    @ResponseBody
    public MyUser nnn() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("examplePU");
        EntityManager em = emf.createEntityManager();
        QMyUser myUser = QMyUser.myUser;
        JPAQuery<?> query = new JPAQuery<Void>(em);
        MyUser myUserReturn = query.select(myUser)
                .from(myUser)
//                .where(myUser.firstName.eq("Bob"))
                .fetchOne();
        return myUserReturn;
    }


}
