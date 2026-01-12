package miniProject3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDAO {
    public static void addStudent(Student s) {
        try {
            Connection con = DBConnection.getConnection();

            // Check duplicate enrollment number
            PreparedStatement check = con.prepareStatement("SELECT eno FROM students WHERE eno=?");
            check.setInt(1, s.getEno());
            ResultSet rs = check.executeQuery();

            if (rs.next()) {
                throw new DuplicateEnoException("Enrollment number already exists.");
            }

            // Name validation
            if (s.getName().trim().isEmpty()) {
                throw new EmptyNameException("Student name cannot be empty.");
            }

            // Branch validation
            if (s.getBranch().trim().isEmpty()) {
                throw new EmptyBranchException("Branch cannot be empty.");
            }

            // Semester validation
            if (s.getSem() < 1 || s.getSem() > 8) {
                throw new InvalidSemesterException("Semester must be between 1 and 8.");
            }

            // Percentage validation
            if (s.getPercentage() < 0) {
                throw new InvalidPercentageException("Percentage cannot be negative.");
            }

            PreparedStatement pst = con.prepareStatement("INSERT INTO students VALUES (?,?,?,?,?)");
            pst.setInt(1, s.getEno());
            pst.setString(2, s.getName());
            pst.setString(3, s.getBranch());
            pst.setInt(4, s.getSem());
            pst.setDouble(5, s.getPercentage());

            pst.executeUpdate();
            System.out.println("Student added successfully.");

        } catch (DuplicateEnoException |
                EmptyNameException |
                EmptyBranchException |
                InvalidSemesterException |
                InvalidPercentageException e) {

            System.out.println("Validation Error: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }


    public static void displayAll() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                System.out.println(
                        rs.getInt(1) + " | " +
                        rs.getString(2) + " | " +
                        rs.getString(3) + " | " +
                        rs.getInt(4) + " | " +
                        rs.getDouble(5)
                );
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public static void searchStudent(int eno) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM students WHERE eno=?");
            pst.setInt(1, eno);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println(
                        rs.getInt(1) + " | " +
                        rs.getString(2) + " | " +
                        rs.getString(3) + " | " +
                        rs.getInt(4) + " | " +
                        rs.getDouble(5)
                );
            } else {
                System.out.println("Student not found.");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public static void updateBranch(int eno, String newBranch) {
        try {
            if (newBranch.trim().isEmpty()) {
                throw new EmptyBranchException("Branch cannot be empty.");
            }

            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("UPDATE students SET branch=? WHERE eno=?");
            pst.setString(1, newBranch);
            pst.setInt(2, eno);

            int rows = pst.executeUpdate();
            if (rows > 0)
                System.out.println("Branch updated successfully.");
            else
                System.out.println("Student not found.");

        } catch (EmptyBranchException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public static void deleteStudent(int eno) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("DELETE FROM students WHERE eno=?");
            pst.setInt(1, eno);

            int rows = pst.executeUpdate();
            if (rows > 0)
                System.out.println("Student deleted successfully.");
            else
                System.out.println("Student not found.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public static void displaySorted() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students ORDER BY percentage DESC");

            while (rs.next()) {
                System.out.println(
                        rs.getInt(1) + " | " +
                        rs.getString(2) + " | " +
                        rs.getString(3) + " | " +
                        rs.getInt(4) + " | " +
                        rs.getDouble(5)
                );
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
