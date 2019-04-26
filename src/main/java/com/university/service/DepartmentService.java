package com.university.service;

import com.university.entities.DTO.StatisticDTO;
import com.university.entities.Department;

import java.util.List;

public interface DepartmentService {
    void save(Department department);

    void update(Department department);

    void deleteById(int id);

    List<Department> findAll();

    Department findById(int id);

    Department findDepartmentByHeadOfDepartment(String headOfDep);

    Department findDepartmentByName(String name);

    Double findAverageSalary(String name);

    Integer findCountOfEmployee(String name);

    StatisticDTO getStatistic(Department department);
}
