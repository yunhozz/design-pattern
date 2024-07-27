package _SOLID._4_interface_segregation.non_compliant;

import _SOLID._4_interface_segregation.non_compliant.worker.Employee;
import _SOLID._4_interface_segregation.non_compliant.worker.Robot;
import _SOLID._4_interface_segregation.non_compliant.worker.Worker;

public class Main {

    public static void main(String[] args) {
        Worker employee = new Employee();
        employee.work(); // Employee is working
        employee.eat(); // Employee is eating

        Worker robot = new Robot();
        robot.work(); // Robot is working
        robot.eat(); // Throws UnsupportedOperationException
    }
}
