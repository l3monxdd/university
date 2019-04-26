package com.university.controllers;

import com.university.entities.Department;
import com.university.entities.Lector;
import com.university.service.DepartmentService;
import com.university.service.LectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lector")
public class LectorController {

    private LectorService lectorService;
    private DepartmentService departmentService;

    @Autowired
    public LectorController(LectorService lectorService, DepartmentService departmentService) {
        this.lectorService = lectorService;
        this.departmentService = departmentService;
    }


    @PostMapping("/register")
    public Lector addLector(@RequestBody Lector lector) {
        System.out.println(lector);
        lectorService.save(lector);
        return lector;
    }

    @GetMapping("/all")
    public List<Lector> findAll() {
        return lectorService.findAll();
    }

    @GetMapping("/{lectorId}/department/{departmentId}")
    public Lector addDepartment(@PathVariable int lectorId, @PathVariable int departmentId) {
        Lector lector = lectorService.findById(lectorId);
        Department department = departmentService.findById(departmentId);
        List<Department> depFromDb = lector.getDepartments();
        depFromDb.add(department);
        lectorService.update(lector);
        return lector;
    }

    @PostMapping("/find")
    public List<Lector> findAllLike(@RequestParam String like) {
        return lectorService.findAllSearch(like);
    }


}
