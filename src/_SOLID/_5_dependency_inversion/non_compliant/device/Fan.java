package _SOLID._5_dependency_inversion.non_compliant.device;

// Low-level class
public class Fan {

    public void spin() {
        System.out.println("Fan is spinning");
    }

    public void stop() {
        System.out.println("Fan is stopping");
    }
}
