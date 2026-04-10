package com.takeout.service;

import com.takeout.dto.DishDTO;
import org.springframework.stereotype.Service;

public interface DishService {

    /*
    * 新增菜品和对应的口味数据
    * */
    public void saveWithFlavor(DishDTO dishDTO);
}
