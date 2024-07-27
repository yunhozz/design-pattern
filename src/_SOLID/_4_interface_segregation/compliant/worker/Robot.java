package _SOLID._4_interface_segregation.compliant.worker;

import _SOLID._4_interface_segregation.compliant.worker.action.Workable;

public class Robot implements Workable {

    @Override
    public void work() {
        System.out.println("Robot is working");
    }
    // Robot does not implement Eatable interface
}
