import java.util.*;
import java.util.regex.Pattern;

// Employee class
class Employee {
    private String empId;
    private String name;
    private double salary;

    public Employee(String empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    public String getEmpId() {
        return empId;
    }

    @Override
    public String toString() {
        return "Employee ID: " + empId +
               ", Name: " + name +
               ", Salary: " + salary;
    }
}

// Main class
public class EmployeeManagementSystem {

    // REGEX for Employee ID → EMP followed by 3 digits
    private static final String EMP_ID_REGEX = "^EMP\\d{3}$";
    private static final Pattern pattern = Pattern.compile(EMP_ID_REGEX);

    public static void main(String[] args) {

        // Map interface reference
        Map<String, Employee> hashMap = new HashMap<>();
        Map<String, Employee> treeMap = new TreeMap<>();
        Map<String, Employee> hashtable = new Hashtable<>();

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Employee Management Menu =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Remove Employee by ID");
            System.out.println("5. Demonstrate Null Support");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            try {
                switch (choice) {
                    case 1 -> addEmployee(sc, hashMap, treeMap, hashtable);
                    case 2 -> displayEmployees(hashMap, treeMap, hashtable);
                    case 3 -> searchEmployee(sc, hashMap);
                    case 4 -> removeEmployee(sc, hashMap, treeMap, hashtable);
                    case 5 -> demonstrateNullSupport();
                    case 6 -> System.out.println("Exiting system....");
                    default -> System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 6);

        sc.close();
    }

    // Add employee
    private static void addEmployee(Scanner sc, Map<String, Employee>... maps) {

        System.out.print("Enter Employee ID (EMP###): ");
        String empId = sc.nextLine();

        if (!pattern.matcher(empId).matches()) {
            throw new IllegalArgumentException("Invalid Employee ID format!");
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        if (salary <= 0) {
            throw new IllegalArgumentException("Salary must be positive!");
        }

        Employee emp = new Employee(empId, name, salary);

        for (Map<String, Employee> map : maps) {
            map.put(empId, emp);
        }

        System.out.println("Employee added successfully ");
    }

    // Display employees
    private static void displayEmployees(
            Map<String, Employee> hashMap,
            Map<String, Employee> treeMap,
            Map<String, Employee> hashtable) {

        System.out.println("\n--- HashMap ---");
        hashMap.values().forEach(System.out::println);

        System.out.println("\n--- TreeMap (Sorted) ---");
        treeMap.values().forEach(System.out::println);

        System.out.println("\n--- Hashtable ---");
        hashtable.values().forEach(System.out::println);
    }

    // Search employee
    private static void searchEmployee(Scanner sc, Map<String, Employee> map) {
        System.out.print("Enter Employee ID to search: ");
        String empId = sc.nextLine();

        Employee emp = map.get(empId);
        if (emp != null) {
            System.out.println(emp);
        } else {
            System.out.println("Employee not found ");
        }
    }

    // Remove employee
    private static void removeEmployee(
            Scanner sc,
            Map<String, Employee>... maps) {

        System.out.print("Enter Employee ID to remove: ");
        String empId = sc.nextLine();

        boolean removed = false;
        for (Map<String, Employee> map : maps) {
            if (map.remove(empId) != null) {
                removed = true;
            }
        }

        System.out.println(removed ? "Employee removed ✔" : "Employee not found ");
    }

    // Null support demonstration
    private static void demonstrateNullSupport() {
        System.out.println("\n--- Null Support Demo ---");

        Map<String, String> hashMap = new HashMap<>();
        Map<String, String> treeMap = new TreeMap<>();
        Map<String, String> hashtable = new Hashtable<>();

        hashMap.put(null, "Allowed");
        hashMap.put("A", null);

        System.out.println("HashMap allows null key & value ");

        try {
            treeMap.put(null, "Not Allowed");
        } catch (Exception e) {
            System.out.println("TreeMap does NOT allow null key ");
        }

        try {
            hashtable.put(null, "Nope");
        } catch (Exception e) {
            System.out.println("Hashtable does NOT allow null key/value ");
        }
    }
}
