package com.longbai.controller;


import com.longbai.service.TTagService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tTag")
@CrossOrigin
public class TTagController {

    // 注入业务层对象
    @Autowired
    private TTagService tTagService;

}
