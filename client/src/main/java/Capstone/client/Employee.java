package Capstone.client;

import java.sql.Date;

public class Employee {
    String id, name, role;
    int employLoc;
    Date startDate;

    public void SetId(String dID) {
        this.id = dID;
    }

    public String GetId() {
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
        this.employLoc = loc;
    }

    public int GetEmployeeLoc() {
        return employLoc;
    }

    public void SetStartDate(Date start) {
        this.startDate = start;
    }

    public Date GetStartDate() {
        return this.startDate;
    }
}
