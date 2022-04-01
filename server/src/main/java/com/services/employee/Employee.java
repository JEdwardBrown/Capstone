package com.services.employee;

import io.micronaut.data.annotation.AutoPopulated;
import io.micronaut.data.annotation.TypeDef;
import io.micronaut.data.model.DataType;
import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @AutoPopulated
    @Column(name = "memberId")
    @TypeDef(type = DataType.STRING)
    private UUID id;

    @Column(name = "memberName")
    @NotBlank
    @TypeDef(type = DataType.STRING)
    private String name;

    @Column(name = "startDate")
    @NotBlank
    @TypeDef(type = DataType.DATE)
    private LocalDate startDate;

    @Column(name = "employmentLoc")
    @NotBlank
    @TypeDef(type = DataType.INTEGER)
    private int empLoc;

    @Column(name = "empRole")
    @NotBlank
    @TypeDef(type = DataType.STRING)
    private String role;

    //Constructor to set parameters for new Employee
    public Employee(UUID id, String name, LocalDate start, int loc, String role) {
        this.id = id;
        this.name = name;
        this.startDate = start;
        this.empLoc = loc;
        this.role = role;
    }

    public Employee(UUID id) {
        this.id = id;
    }

    //Blank Constructor
    public Employee() {

    }

    public void SetId(UUID dID) {
        this.id = dID;
    }

    public UUID GetId() {
        return id;
    }

    public void SetName(String name) {
        this.name = name;
    }

    public String GetName() {
        return name;
    }

    public void SetRole(String role) {
        this.role = role;
    }

    public String GetRole() {
        return role;
    }

    public void SetEmployLoc(int loc) {
        this.empLoc = loc;
    }

    public int GetEmployeeLoc() {
        return empLoc;
    }

    public void SetStartDate(LocalDate start) {
        this.startDate = start;
    }

    public LocalDate GetStartDate() {
        return this.startDate;
    }
}
