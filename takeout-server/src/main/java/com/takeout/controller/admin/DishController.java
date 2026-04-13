package com.takeout.controller.admin;

import com.takeout.dto.DishDTO;
import com.takeout.dto.DishPageQueryDTO;
import com.takeout.result.PageResult;
import com.takeout.result.Result;
import com.takeout.service.DishService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* 菜品管理
* */
@RestController
@RequestMapping("/admin/dish")
@Api(tags = "菜品管理接口")
@Slf4j
public class DishController {

    @Autowired
    private DishService dishService;

    /*
    * 新增菜品
    *
    * */
    @PostMapping
    @ApiOperation("新增菜品")
    public Result save(@RequestBody DishDTO dishDTO){
        log.info("新增菜品：{}",dishDTO);
        dishService.saveWithFlavor(dishDTO);
        return Result.success();
    }

    /*
    * 菜品分页查询
    *
    * */
    @GetMapping("/page")
    @ApiOperation("菜品分页查询")
    public Result<PageResult> page(DishPageQueryDTO dishPageQueryDTO){
        log.info("分页查询：{}",dishPageQueryDTO);
        PageResult pageResult = dishService.pageQuery(dishPageQueryDTO);
        return Result.success(pageResult);
    }

    /*
    * 批量删除菜品
    *
    * */
    @DeleteMapping
    @ApiOperation("批量删除")
    public Result delete(@RequestParam List<Long> ids){
        log.info("批量删除：{}",ids);
        dishService.deleteBatch(ids);
        return Result.success();
    }
}
