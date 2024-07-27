package _SOLID._4_interface_segregation.compliant.worker;

import _SOLID._4_interface_segregation.compliant.worker.action.Eatable;
import _SOLID._4_interface_segregation.compliant.worker.action.Workable;

public class Employee implements Workable, Eatable {

    @Override
    public void work() {
        System.out.println("Employee is working");
    }

    @Override
    public void eat() {
        System.out.println("Employee is eating");
    }
}
