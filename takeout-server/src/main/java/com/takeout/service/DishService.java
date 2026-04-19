package com.takeout.service;

import com.takeout.dto.DishDTO;
import com.takeout.dto.DishPageQueryDTO;
import com.takeout.entity.Dish;
import com.takeout.result.PageResult;
import com.takeout.vo.DishVO;

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

    /*
    * 根据id查询菜品和对应的口味数据
    * */
    DishVO getByIdWithFlavor(Long id);

    /*
    * 根据id 修改菜品和口味数据
    * */
    void updateWithFlavor(DishDTO dishDTO);

    /**
     * 根据分类id查询菜品选项
     * @param categoryId
     * @return
     */
    List<DishVO> listWithFlavor(Dish categoryId);

    /**
     * 根据分类id查询菜品
     * @param categoryId
     * @return
     */
    List<Dish> list(Long categoryId);

    /**
     * 菜品起售停售
     * @param status
     * @param id
     */
    void startOrStop(Integer status, Long id);
}
