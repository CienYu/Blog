package com.longbai.controller;


import com.longbai.service.TTagBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tTagBlog")
@CrossOrigin
public class TTagBlogController {

    // 注入业务层对象
    @Autowired
    private TTagBlogService tTagBlogService;

}
