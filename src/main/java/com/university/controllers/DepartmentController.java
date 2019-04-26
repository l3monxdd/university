package com.university.controllers;

import com.university.entities.DTO.StatisticDTO;
import com.university.entities.Department;
import com.university.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/register")
    public Department addDepartment(@RequestBody Department departmentRequest) {
        System.out.println(departmentRequest);
        departmentService.save(departmentRequest);
        return departmentRequest;
    }

    @GetMapping("/all")
    public List<Department> findAll() {
        return departmentService.findAll();
    }


    @PostMapping("/head")
    public String findHeadOfDep(@RequestParam String headOfDep) {
        Department department = departmentService.findDepartmentByHeadOfDepartment(headOfDep);
        return department.getName();
    }

    @PostMapping("/depName")
    public String findByDepartmentName(@RequestParam String departmentName) {
        Department department = departmentService.findDepartmentByName(departmentName);
        return department.getHeadOfDepartment();
    }

    @PostMapping("/avgSalary")
    public Double findAvgSalary(@RequestParam String name) {
        return departmentService.findAverageSalary(name);
    }

    @PostMapping("/count")
    public Integer findCountOfEmployees(@RequestParam String name) {
        return departmentService.findCountOfEmployee(name);
    }

    @PostMapping("/statistic")
    public StatisticDTO getStatistic(@RequestParam String name) {
        Department department = departmentService.findDepartmentByName(name);
        return departmentService.getStatistic(department);
    }
}
