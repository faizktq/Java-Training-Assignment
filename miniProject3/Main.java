package miniProject3;

import java.sql.*;
import java.util.Scanner;

public class Main {

    public static boolean login(Scanner sc) {
        try {
            System.out.print("Enter username: ");
            String u = sc.next();

            System.out.print("Enter password: ");
            String p = sc.next();

            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
            pst.setString(1, u);
            pst.setString(2, p);

            ResultSet rs = pst.executeQuery();

            if (!rs.next()) {
                throw new InvalidLoginException("Invalid username or password.");
            }

            System.out.println("Login successful.\n");
            return true;

        } catch (InvalidLoginException e) {
            System.out.println("Login Error: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
            return false;
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        if (!login(sc)) {
            return;
        }

        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by Enrollment No");
            System.out.println("4. Update Student Branch");
            System.out.println("5. Delete Student");
            System.out.println("6. Display Sorted Students");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    System.out.print("Enrollment No: ");
                    int eno = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Branch: ");
                    String branch = sc.nextLine();

                    int sem;
                    while (true) {
                        System.out.print("Semester (1-8): ");
                        sem = sc.nextInt();
                        if (sem >= 1 && sem <= 8) break;
                        System.out.println("Invalid Semester. Please enter between 1 and 8.");
                    }

                    double per;
                    while (true) {
                        System.out.print("Percentage (>=0): ");
                        per = sc.nextDouble();
                        if (per >= 0) break;
                        System.out.println("Invalid Percentage. Please enter a non-negative value.");
                    }

                    Student s = new Student(eno, name, branch, sem, per);
                    StudentDAO.addStudent(s);
                    break;

                case 2:
                    StudentDAO.displayAll();
                    break;

                case 3:
                    System.out.print("Enter Enrollment No: ");
                    StudentDAO.searchStudent(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter Enrollment No: ");
                    int e1 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Branch: ");
                    String nb = sc.nextLine();
                    StudentDAO.updateBranch(e1, nb);
                    break;

                case 5:
                    System.out.print("Enter Enrollment No: ");
                    StudentDAO.deleteStudent(sc.nextInt());
                    break;

                case 6:
                    StudentDAO.displaySorted();
                    break;

                case 7:
                    System.out.println("Exiting program...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
