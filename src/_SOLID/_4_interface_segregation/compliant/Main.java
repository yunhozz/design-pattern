package _SOLID._4_interface_segregation.compliant;

import _SOLID._4_interface_segregation.compliant.worker.Employee;
import _SOLID._4_interface_segregation.compliant.worker.Robot;
import _SOLID._4_interface_segregation.compliant.worker.action.Eatable;
import _SOLID._4_interface_segregation.compliant.worker.action.Workable;

public class Main {

    public static void main(String[] args) {
        Workable employee = new Employee();
        employee.work(); // Employee is working
        ((Eatable) employee).eat(); // Employee is eating

        Workable robot = new Robot();
        robot.work(); // Robot is working
        ((Eatable) robot).eat(); // Compilation error, Robot does not implement Eatable
    }
}
