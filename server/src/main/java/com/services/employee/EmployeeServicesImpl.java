package com.services.employee;

import jakarta.inject.Singleton;

import java.util.Optional;
import java.util.UUID;

@Singleton
public class EmployeeServicesImpl implements EmployeeServices {

    @Override
    public Employee save(Employee employee) {
        return EmployeeRepository.save(employee);
    }

    @Override
    public Employee update(Employee employee) {

        Optional<Employee> originalEmp = EmployeeRepository.findById(employee.GetId());

        employee.SetId(originalEmp.get().GetId());
        employee.SetName(originalEmp.get().GetName());
        employee.SetRole(originalEmp.get().GetRole());
        employee.SetEmployLoc(originalEmp.get().GetEmployeeLoc());
        employee.SetStartDate(originalEmp.get().GetStartDate());

        return EmployeeRepository.update(employee);
    }

    @Override
    public Boolean delete(UUID id) {
        final Employee template = getById(id);

        // delete the template itself
        EmployeeRepository.softDeleteById(Util.nullSafeUUIDToString(id));
        return true;
    }

    @Override
    public Employee getById(UUID id) {
        final Optional<Employee> employeeTemplate = EmployeeRepository.findById(id);

        return employeeTemplate.get();
    }
}
