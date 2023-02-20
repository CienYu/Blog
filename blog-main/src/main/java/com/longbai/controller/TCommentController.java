package com.longbai.controller;


import com.longbai.service.TCommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/tComment")
@CrossOrigin
public class TCommentController {

    // 注入业务层对象
    @Autowired
    private TCommentService tCommentService;


}
