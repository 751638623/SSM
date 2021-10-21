package com.ssmcrud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssmcrud.bean.Employee;
import com.ssmcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 卢宇航
 * @Description 编写员工的CRUD  Controller
 * @create 2021-06-15 22:14
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/emps")
    public String getEmps(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
        PageHelper.startPage(pn,2);
        List<Employee> emps = employeeService.getAll();
        PageInfo page = new PageInfo(emps,10);
        model.addAttribute("pageInfo",page);
        System.out.println("1111");
        System.out.println("2222");
        return "list";
    }
}
