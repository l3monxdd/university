package com.university.serviceImpl;

import com.university.dao.DepartmentDao;
import com.university.entities.DTO.StatisticDTO;
import com.university.entities.Department;
import com.university.entities.Lector;
import com.university.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.university.entities.Degree.*;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao;

    @Autowired
    public DepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public void save(Department department) {
        departmentDao.save(department);
    }

    @Override
    public void update(Department department) {
        departmentDao.save(department);
    }

    @Override
    public void deleteById(int id) {
        departmentDao.deleteById(id);
    }

    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    @Override
    public Department findById(int id) {
        return departmentDao.findById(id).get();
    }

    @Override
    public Department findDepartmentByHeadOfDepartment(String headOfDep) {
        return departmentDao.findDepartmentByHeadOfDepartment(headOfDep);
    }

    @Override
    public Department findDepartmentByName(String name) {
        return departmentDao.findDepartmentByName(name);
    }

    @Override
    public Double findAverageSalary(String name) {
        return departmentDao.findAverageSalary(name);
    }

    @Override
    public Integer findCountOfEmployee(String name) {
        return departmentDao.findCountOfEmployee(name);
    }

    @Override
    public StatisticDTO getStatistic(Department department) {
        StatisticDTO statisticDTO = new StatisticDTO();

        int assistantCount = 0;
        int associateProfessorCount = 0;
        int professorCount = 0;

        for (Lector lector : department.getLectors()) {
            if (lector.getDegree().equals(ASSISTANT)) {
                assistantCount++;
            } else if (lector.getDegree().equals(ASSOCIATE_PROFESSOR)) {
                associateProfessorCount++;
            } else if (lector.getDegree().equals(PROFESSOR)) {
                professorCount++;
            } else System.out.println("wrong degree");
        }
        statisticDTO.setAssistantCount(assistantCount);
        statisticDTO.setAssociateProfessorCount(associateProfessorCount);
        statisticDTO.setProfessorCount(professorCount);
        statisticDTO.setDepartmentName(department.getName());
        return statisticDTO;
    }
}
