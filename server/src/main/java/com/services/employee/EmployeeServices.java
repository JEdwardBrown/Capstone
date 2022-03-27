package com.services.employee;

import java.util.UUID;

public interface EmployeeServices {
    Employee save(Employee employee);

    Employee update(Employee employee);

    Boolean delete(UUID id);

    Employee getById(UUID id);
}
