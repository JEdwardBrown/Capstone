package Capstone.client;

import java.time.LocalDate;
import java.util.UUID;

public class ClientEmployee {

    private UUID id;
    private String name;
    private LocalDate startDate;
    private int empLoc;
    private String role;

        //Constructor to set parameters for new Employee
        public ClientEmployee(UUID id, String name, LocalDate start, int loc, String role) {
            this.id = id;
            this.name = name;
            this.startDate = start;
            this.empLoc = loc;
            this.role = role;
        }

        public ClientEmployee(UUID id) {
            this.id = id;
        }

        //Blank Constructor
        public ClientEmployee() {

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
