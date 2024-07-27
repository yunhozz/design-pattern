package _SOLID._4_interface_segregation.non_compliant.worker;

public class Employee implements Worker {

    @Override
    public void work() {
        System.out.println("Employee is working");
    }

    @Override
    public void eat() {
        System.out.println("Employee is eating");
    }
}
