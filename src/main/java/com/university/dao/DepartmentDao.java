package com.university.dao;

import com.university.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DepartmentDao extends JpaRepository<Department, Integer> {

    Department findDepartmentByHeadOfDepartment(String headOfDep);

    Department findDepartmentByName(String name);

    @Query("select avg(l.salary) from Department d inner join d.lectors l where d.name=:name")
    Double findAverageSalary(@Param("name") String name);

    @Query("select count(l.id) from Department d inner  join d.lectors l where d.name=:name")
    Integer findCountOfEmployee(@Param("name") String name);


}
