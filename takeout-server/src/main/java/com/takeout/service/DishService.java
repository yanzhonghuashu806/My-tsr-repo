package com.takeout.service;

import com.takeout.dto.DishDTO;
import com.takeout.dto.DishPageQueryDTO;
import com.takeout.result.PageResult;
import com.takeout.result.Result;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DishService {

    /*
    * 新增菜品和对应的口味数据
    * */
    public void saveWithFlavor(DishDTO dishDTO);

    /*
    * 菜品分页查询
    * */
    PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);

    /*
    * 批量删除菜品
    * */
    void deleteBatch(List<Long> ids);
}
