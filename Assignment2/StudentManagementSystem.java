import java.util.*;
import java.util.regex.Pattern;

//Interface defining the standard operations for Student Management
interface StudentOperations {
    void addStudent(Student s);
    void displayAll();
    boolean removeByRoll(int rollNumber);
    Student searchByRoll(int rollNumber);
}

//Student Model Class with REGEX Validation
class Student {
    private int rollNumber;
    private String name;

    // REGEX: Name must contain only alphabets and spaces
    private static final String NAME_PATTERN = "^[a-zA-Z\\s]+$";

    public Student(int rollNumber, String name) {
        if (!Pattern.matches(NAME_PATTERN, name)) {
            throw new IllegalArgumentException("Invalid Name: Use alphabets only.");
        }
        this.rollNumber = rollNumber;
        this.name = name;
    }

    public int getRollNumber() { return rollNumber; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return String.format("[Roll No: %d | Name: %s]", rollNumber, name);
    }
}

//Controller class implementing the logic using ArrayList and Vecto
class StudentManager implements StudentOperations {
    // Demonstrating the use of List interface, ArrayList, and Vector
    private List<Student> studentList = new ArrayList<>(); 
    private Vector<Student> vectorStorage = new Vector<>(); 

    @Override
    public void addStudent(Student s) {
        studentList.add(s);
        vectorStorage.add(s); // Parallel storage for demonstration
        System.out.println(">>> Record added successfully.");
    }

    @Override
    public void displayAll() {
        if (studentList.isEmpty()) {
            System.out.println(">>> No records available.");
            return;
        }
        System.out.println("\n--- Current Student Records ---");
        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    @Override
    public boolean removeByRoll(int rollNumber) {
        // removeIf returns true if an element was removed
        boolean removed = studentList.removeIf(s -> s.getRollNumber() == rollNumber);
        vectorStorage.removeIf(s -> s.getRollNumber() == rollNumber);
        return removed;
    }

    @Override
    public Student searchByRoll(int rollNumber) {
        for (Student s : studentList) {
            if (s.getRollNumber() == rollNumber) return s;
        }
        return null;
    }
}

// Main Application class with Exception Handling
public class StudentManagementSystem {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Student Record System");

        while (true) {
            try {
                System.out.println("\n1. Add | 2. Display | 3. Remove | 4. Search | 5. Exit");
                System.out.print("Select an option: ");
                
                // Validate that input is an integer
                if (!sc.hasNextInt()) {
                    throw new InputMismatchException("Choice must be a number.");
                }
                
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Roll Number: ");
                        int r = sc.nextInt();
                        sc.nextLine(); // Clear buffer
                        System.out.print("Enter Student Name: ");
                        String n = sc.nextLine();
                        manager.addStudent(new Student(r, n));
                        break;

                    case 2:
                        manager.displayAll();
                        break;

                    case 3:
                        System.out.print("Enter Roll Number to delete: ");
                        int delRoll = sc.nextInt();
                        if (manager.removeByRoll(delRoll)) 
                            System.out.println(">>> Record deleted.");
                        else 
                            System.out.println(">>> Record not found.");
                        break;

                    case 4:
                        System.out.print("Enter Roll Number to search: ");
                        int searchRoll = sc.nextInt();
                        Student found = manager.searchByRoll(searchRoll);
                        if (found != null) 
                            System.out.println(">>> Found: " + found);
                        else 
                            System.out.println(">>> Student not found.");
                        break;

                    case 5:
                        System.out.println("Exiting program...");
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input Error: Please enter numeric values where required.");
                sc.nextLine(); // Clear the invalid input from scanner
            } catch (IllegalArgumentException e) {
                System.out.println("Validation Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
                sc.nextLine();
            }
        }
    }
}