package com.services.employee;

import jakarta.inject.Singleton;

import java.util.Optional;
import java.util.UUID;

@Singleton
public class EmployeeServicesImpl implements EmployeeServices {

    private final EmployeeRepository employeeRepository;

    public EmployeeServicesImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Employee employee) {

        Optional<Employee> originalEmp = employeeRepository.findById(employee.GetId());

        employee.SetId(originalEmp.get().GetId());
        employee.SetName(originalEmp.get().GetName());
        employee.SetRole(originalEmp.get().GetRole());
        employee.SetEmployLoc(originalEmp.get().GetEmployeeLoc());
        employee.SetStartDate(originalEmp.get().GetStartDate());

        return employeeRepository.update(employee);
    }

    @Override
    public Boolean delete(UUID id) {
        final Employee template = getById(id);

        // delete the template itself
        employeeRepository.softDeleteById(nullSafeUUIDToString(id));
        return true;
    }

    @Override
    public Employee getById(UUID id) {
        final Optional<Employee> employeeTemplate = employeeRepository.findById(id);

        return employeeTemplate.get();
    }

    public static String nullSafeUUIDToString(UUID uuid) {
        return uuid == null ? null : uuid.toString();
    }
}
