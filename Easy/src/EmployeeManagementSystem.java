import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class EmployeeManagementSystem {
    private static ArrayList<Employee> employees = new ArrayList<>();

    public static void addEmployee(int id, String name, double salary) {
        employees.add(new Employee(id, name, salary));
        System.out.println("Employee added successfully!");
    }

    public static void updateEmployee(int id, String name, double salary) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                emp.setName(name);
                emp.setSalary(salary);
                System.out.println("Employee details updated!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public static void removeEmployee(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                employees.remove(emp);
                System.out.println("Employee removed!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public static void searchEmployee(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                System.out.println("Employee Found: " + emp);
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Employee\n2. Update Employee\n3. Remove Employee\n4. Search Employee\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    addEmployee(id, name, salary);
                    break;
                case 2:
                    System.out.print("Enter ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter New Salary: ");
                    salary = sc.nextDouble();
                    updateEmployee(id, name, salary);
                    break;
                case 3:
                    System.out.print("Enter ID: ");
                    id = sc.nextInt();
                    removeEmployee(id);
                    break;
                case 4:
                    System.out.print("Enter ID: ");
                    id = sc.nextInt();
                    searchEmployee(id);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
