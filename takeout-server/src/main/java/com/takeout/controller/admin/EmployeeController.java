package com.takeout.controller.admin;

import com.takeout.constant.JwtClaimsConstant;
import com.takeout.dto.EmployeeDTO;
import com.takeout.dto.EmployeeLoginDTO;
import com.takeout.dto.EmployeePageQueryDTO;
import com.takeout.entity.Employee;
import com.takeout.properties.JwtProperties;
import com.takeout.result.PageResult;
import com.takeout.result.Result;
import com.takeout.service.EmployeeService;
import com.takeout.utils.JwtUtil;
import com.takeout.vo.EmployeeLoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 员工管理
 */
@RestController
@RequestMapping("/admin/employee")
@Slf4j
@Api(tags = "员工相关接口")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 登录
     *
     * @param employeeLoginDTO
     * @return
     */
    @PostMapping("/login")
    @ApiOperation("员工登录接口")
    public Result<EmployeeLoginVO> login(@RequestBody EmployeeLoginDTO employeeLoginDTO) {
        log.info("员工登录：{}", employeeLoginDTO);

        Employee employee = employeeService.login(employeeLoginDTO);

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.EMP_ID, employee.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims);

        EmployeeLoginVO employeeLoginVO = EmployeeLoginVO.builder()
                .id(employee.getId())
                .userName(employee.getUsername())
                .name(employee.getName())
                .token(token)
                .build();

        return Result.success(employeeLoginVO);
    }

    /**
     * 退出
     *
     * @return
     */
    @PostMapping("/logout")
    @ApiOperation("员工退出接口")
    public Result<String> logout() {
        return Result.success();
    }

    /*
    * 新增员工
    * */
    @PostMapping
    @ApiOperation("新增员工接口")
    public Result save(@RequestBody EmployeeDTO employeeDTO){
        log.info("新增员工，员工数据：{}",employeeDTO);
        employeeService.save(employeeDTO);
        return Result.success();
    }

    /*
     * 员工分页查询
     */
    @GetMapping("/page")
    @ApiOperation("员工分页查询接口")
    public Result<PageResult> page(EmployeePageQueryDTO employeePageQueryDTO){
        log.info("员工分页查询，参数为:{}", employeePageQueryDTO);
        PageResult pageResult = employeeService.pageQuery(employeePageQueryDTO);
        return Result.success(pageResult);
    }

    /*
    * 启用禁用员工账号
    * */
    @PostMapping("/status/{status}")
    @ApiOperation("启用禁用员工账号接口")
    public Result startOrStop(@PathVariable Integer status, Long id){
        log.info("员工状态：{}，员工id：{}",status,id);
        employeeService.startOrStop(status,id);
        return Result.success();
    }
}
