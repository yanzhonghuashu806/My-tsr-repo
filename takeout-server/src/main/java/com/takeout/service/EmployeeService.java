package com.takeout.service;

import com.takeout.dto.EmployeeDTO;
import com.takeout.dto.EmployeeLoginDTO;
import com.takeout.entity.Employee;

public interface EmployeeService {

    /**
     * 员工登录
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

    void save(EmployeeDTO employeeDTO);
}
