package structure.composite;

import java.util.ArrayList;
import java.util.List;

// Component interface
interface OrganizationComponent {
    void showDetails();
    double getSalary();
}

// Leaf class
class Employee implements OrganizationComponent {
    private final String name;
    private final String position;
    private final double salary;

    public Employee(String name, String position, double salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public void showDetails() {
        System.out.println("Employee: " + name + ", Position: " + position);
    }

    @Override
    public double getSalary() {
        return salary;
    }
}

// Composite class
class Department implements OrganizationComponent {
    private final String name;
    private final List<OrganizationComponent> subordinates = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public void addSubordinate(OrganizationComponent component) {
        subordinates.add(component);
    }

    public void removeSubordinate(OrganizationComponent component) {
        subordinates.remove(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Department: " + name);
        for (OrganizationComponent component : subordinates) {
            component.showDetails();
        }
    }

    @Override
    public double getSalary() {
        double totalSalary = 0;
        for (OrganizationComponent component : subordinates) {
            totalSalary += component.getSalary();
        }
        return totalSalary;
    }
}

class CompanyStructureDemo {
    public static void main(String[] args) {
        // Create the overall company structure
        Department company = new Department("TechCorp");

        // Create departments
        Department engineering = new Department("Engineering");
        Department sales = new Department("Sales");

        // Create sub-departments
        Department softwareDev = new Department("Software Development");
        Department qualityAssurance = new Department("Quality Assurance");

        // Create employees
        Employee ceo = new Employee("John Doe", "CEO", 150000);
        Employee cto = new Employee("Jane Smith", "CTO", 130000);
        Employee salesManager = new Employee("Mike Johnson", "Sales Manager", 100000);
        Employee developer1 = new Employee("Alice Brown", "Software Developer", 80000);
        Employee developer2 = new Employee("Bob Wilson", "Software Developer", 75000);
        Employee tester = new Employee("Charlie Davis", "QA Tester", 70000);

        // Build the organizational structure
        company.addSubordinate(ceo);
        company.addSubordinate(engineering);
        company.addSubordinate(sales);

        engineering.addSubordinate(cto);
        engineering.addSubordinate(softwareDev);
        engineering.addSubordinate(qualityAssurance);

        softwareDev.addSubordinate(developer1);
        softwareDev.addSubordinate(developer2);

        qualityAssurance.addSubordinate(tester);

        sales.addSubordinate(salesManager);

        // Display the entire company structure
        System.out.println("Company Structure:");
        company.showDetails();

        // Calculate and display total salary
        System.out.println("\nTotal Company Salary: $" + company.getSalary());
    }
}
