package com.ssmcrud.service;

import com.ssmcrud.bean.Employee;
import com.ssmcrud.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 卢宇航
 * @Description 查询所有员工
 * @create 2021-06-16 0:12
 */
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    public List<Employee> getAll() {
        return employeeMapper.selectByExampleWithDept(null);
    }


}
