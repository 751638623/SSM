package com.ssmcrud.test;

import com.ssmcrud.bean.Department;
import com.ssmcrud.bean.Employee;
import com.ssmcrud.dao.DepartmentMapper;
import com.ssmcrud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * @author 卢宇航
 * @Description
 * @create 2021-06-15 10:50
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;
    @Test
    public void testCrud(){
//        // 插入数据
//         departmentMapper.insertSelective(new Department(null,"开发部"));
//         departmentMapper.insertSelective(new Department(null,"测试部"));
        //2,生成员工数据，测试员工插入
//
//        employeeMapper.insertSelective(new Employee(null,"jerry","M","jerry@pl.com",1));

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        for(int i=0;i<200;i++){

            String uid = UUID.randomUUID().toString().substring(0,5)+i;
            mapper.insertSelective(new Employee(null,uid,"M",uid+"@lyh.com",1));
        }
        System.out.println("批量添加员工成功");



    }
}
