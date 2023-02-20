package com.longbai.controller;


import com.longbai.service.TBlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;



@RestController
@RequestMapping("/tBlog")
public class TBlogController {

    // 注入业务层对象
    @Autowired
    private TBlogService tBlogService;


}
