package com.takeout.service;

import com.takeout.dto.EmployeeDTO;
import com.takeout.dto.EmployeeLoginDTO;
import com.takeout.dto.EmployeePageQueryDTO;
import com.takeout.entity.Employee;
import com.takeout.result.PageResult;

public interface EmployeeService {

    /**
     * 员工登录
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

    void save(EmployeeDTO employeeDTO);

    PageResult pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    void startOrStop(Integer status, Long id);
}
