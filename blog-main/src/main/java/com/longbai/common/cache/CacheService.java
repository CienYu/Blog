package com.longbai.common.cache;

import cn.hutool.core.bean.BeanUtil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Slf4j
@Service
public class CacheService {

    @Resource
    Cache cache;

}
