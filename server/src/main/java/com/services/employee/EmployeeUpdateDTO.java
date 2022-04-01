package com.services.employee;

import javax.validation.constraints.NotBlank;
import java.util.UUID;
import io.micronaut.core.annotation.Introspected;

@Introspected
public class EmployeeUpdateDTO {
    @NotBlank
    private UUID id;

    @NotBlank
    private Boolean active;

    public UUID GetId() {
        return id;
    }

    public void SetId(UUID id) {
        this.id = id;
    }
}
