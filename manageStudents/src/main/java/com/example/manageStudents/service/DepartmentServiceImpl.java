package com.example.manageStudents.service;

import com.example.manageStudents.entity.Department;
import com.example.manageStudents.error.DepartmentNotFoundException;
import com.example.manageStudents.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(id);
        if(!department.isPresent()) {
            throw new DepartmentNotFoundException("Department with id: " + id + " is not present");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long id) {
            departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
         Department deptDB = departmentRepository.findById(id).get();
         if(Objects.nonNull(department.getDepartmentName()) && !"".equals(department.getDepartmentName())){
             deptDB.setDepartmentName(department.getDepartmentName());
         }
         if(Objects.nonNull(department.getDepartmentCode()) && !"".equals(department.getDepartmentCode())){
             deptDB.setDepartmentCode(department.getDepartmentCode());
         }
         if(Objects.nonNull(department.getDepartmentAddress()) && !"".equals(department.getDepartmentAddress())) {
             deptDB.setDepartmentAddress(department.getDepartmentAddress());
         }
         return departmentRepository.save(deptDB);
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }


}
