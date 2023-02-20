package com.longbai.controller;


import com.longbai.entity.TImg;
import com.longbai.service.TImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/tImg")
public class TImgController {

    // 注入业务层对象
    @Autowired
    private TImgService tImgService;

}
