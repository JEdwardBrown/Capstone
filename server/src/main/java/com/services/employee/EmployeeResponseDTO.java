package com.services.employee;

import io.micronaut.core.annotation.Introspected;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Introspected
public class EmployeeResponseDTO {

    @NotNull
    private String name;

    @NotNull
    private String role;

    @NotNull
    private UUID id;

    @NotNull
    private int loc;

    @NotNull
    private LocalDate startDate;

    public UUID GetId() {
        return id;
    }

    public void SetId(UUID id) {
        this.id = id;
    }

    public String GetName() {
        return name;
    }

    public void SetName(String name) {
        this.name = name;
    }

    public int GetLoc() {
        return loc;
    }

    public void SetLoc(int loc) {
        this.loc = loc;
    }

    public String GetRole() {
        return role;
    }

    public void SetRole(String role) {
        this.role = role;
    }

    public LocalDate GetStartDate() {
        return startDate;
    }

    public void SetStartDate(LocalDate start) {
        this.startDate = start;
    }

}
