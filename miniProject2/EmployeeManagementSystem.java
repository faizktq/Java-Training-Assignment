package miniProject2;
import java.io.*;
import java.util.*;

public class EmployeeManagementSystem {

    static HashMap<Integer, Employee> empMap = new HashMap<>();
    static final String FILE_NAME = "employees.txt";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        login();
        loadFromFile();

        while (true) {
            System.out.println("\n---- Employee Management System ----");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Update Employee Salary");
            System.out.println("5. Delete Employee");
            System.out.println("6. Display Sorted Employees");
            System.out.println("7. Display Departments");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> displayAll();
                case 3 -> searchEmployee();
                case 4 -> updateSalary();
                case 5 -> deleteEmployee();
                case 6 -> sortEmployees();
                case 7 -> displayDepartments();
                case 8 -> {
                    System.out.println("Exiting System...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid Choice!");
            }
        }
    }

    // Login System
    static void login() {
        String username = "admin";
        String password = "admin123";

        System.out.print("Username: ");
        String u = sc.next();
        System.out.print("Password: ");
        String p = sc.next();

        if (!(u.equals(username) && p.equals(password))) {
            System.out.println("Invalid Login!");
            System.exit(0);
        }
        System.out.println("Login Successful!");
    }

    // Add Employee
    static void addEmployee() {
        try {
            System.out.print("ID: ");
            int id = sc.nextInt();

            if (empMap.containsKey(id))
                throw new Exception("Employee ID must be unique!");

            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Department: ");
            String dept = sc.next();
            if (dept.isEmpty())
                throw new Exception("Department cannot be empty!");

            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            if (salary <= 0)
                throw new Exception("Salary must be positive!");

            empMap.put(id, new Employee(id, name, dept, salary));
            saveToFile();
            System.out.println("Employee Added Successfully!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Display All
    static void displayAll() {
        if (empMap.isEmpty()) {
            System.out.println("No Employees Found!");
            return;
        }
        empMap.values().forEach(System.out::println);
    }

    // Search
    static void searchEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        Employee e = empMap.get(id);
        if (e == null)
            System.out.println("Employee Not Found!");
        else
            System.out.println(e);
    }

    // Update Salary
    static void updateSalary() {
        try {
            System.out.print("Employee ID: ");
            int id = sc.nextInt();

            if (!empMap.containsKey(id))
                throw new Exception("Employee Not Found!");

            System.out.print("New Salary: ");
            double sal = sc.nextDouble();
            if (sal <= 0)
                throw new Exception("Salary must be positive!");

            empMap.get(id).setSalary(sal);
            saveToFile();
            System.out.println("Salary Updated!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Delete
    static void deleteEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        if (empMap.remove(id) != null) {
            saveToFile();
            System.out.println("Employee Deleted!");
        } else {
            System.out.println("Employee Not Found!");
        }
    }

    // Sort Employees
    static void sortEmployees() {
        List<Employee> list = new ArrayList<>(empMap.values());
        list.sort(Comparator.comparingDouble(Employee::getSalary));

        list.forEach(System.out::println);
    }

    // Display Departments
    static void displayDepartments() {
        Set<String> departments = new HashSet<>();

        for (Employee e : empMap.values())
            departments.add(e.getDepartment());

        departments.forEach(System.out::println);
    }

    // File Handling
    static void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Employee e : empMap.values())
                pw.println(e);
        } catch (IOException e) {
            System.out.println("File Write Error!");
        }
    }

    static void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                Employee e = Employee.fromString(line);
                empMap.put(e.getId(), e);
            }
        } catch (IOException e) {
            System.out.println("File Read Error!");
        }
    }
}

