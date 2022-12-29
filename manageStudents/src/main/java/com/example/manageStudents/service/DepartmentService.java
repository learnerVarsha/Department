package com.example.manageStudents.service;

import com.example.manageStudents.entity.Department;
import com.example.manageStudents.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> getDepartments();

    public Department getDepartmentById(Long id) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long id);

    public Department updateDepartment(Long id, Department department);

    public Department getDepartmentByName(String departmentName);
}
