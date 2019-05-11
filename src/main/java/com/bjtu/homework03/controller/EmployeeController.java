package com.bjtu.homework03.controller;

import com.bjtu.homework03.entity.Employee;
import com.bjtu.homework03.repository.EmployeeRepository;
import com.google.common.util.concurrent.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
public class EmployeeController {
    Logger logger = LoggerFactory.getLogger(getClass());
    private final static RateLimiter limiter = RateLimiter.create(0.1);

    //注入
    @Autowired
    EmployeeRepository employeeRepository;

    //查询所有员工
    @GetMapping("/emps")
    public String list(Model model){
        limiter.acquire();
        List<Employee> employees = employeeRepository.findAll();
        //放到请求域中
        model.addAttribute("emps",employees);

        //thymeleaf 默认拼串
        //classpath: /templates/emp/list.html
        return "emp/list";
    }

    //员工添加页面
    @GetMapping("/emp")
    public String toAddPage(){
        //到添加页面
        return "emp/add";
    }

    //员工添加
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //来到员工id列表表页面
        System.out.println(employee);
        employeeRepository.save(employee);
        //redirect 重定向地址
        //forward 转发地址
        return "redirect:/main";
    }

    //到修改页面，查出当前员工，在页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee e = employeeRepository.findOne(id);
        model.addAttribute("emp",e);
        //回到修改页面（add是一个修改添加2合1的）
        return "/emp/add";
    }

    //员工修改
    @PutMapping("/emp")
    public  String updateEmployee(Employee employee){
//        System.out.println(employee);
        logger.info("修改");
        employeeRepository.save(employee);
        return "redirect:/main";
    }

    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeRepository.delete(id);
        logger.info("删除");
        return "redirect:/main";
    }

}
