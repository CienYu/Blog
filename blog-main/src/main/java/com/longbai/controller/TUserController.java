package com.longbai.controller;

import com.longbai.service.TUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tUser")
@CrossOrigin
public class TUserController {

    // 注入业务层对象
    @Autowired
    private TUserService tUserService;


}
