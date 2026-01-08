package Assignment4;

import java.sql.*;

public class CreateAndInsertStudents {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String pass = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();

            String create = "CREATE TABLE Students ("
                    + "roll INT PRIMARY KEY, "
                    + "name VARCHAR(50), "
                    + "branch VARCHAR(20), "
                    + "percentage FLOAT, "
                    + "semester INT, "
                    + "passingYear INT)";

            st.executeUpdate(create);
            System.out.println("Table Created");

            st.executeUpdate("INSERT INTO Students VALUES (1, 'Rohit', 'CSE', 85.5, 7, 2025)");
            st.executeUpdate("INSERT INTO Students VALUES (2, 'Tanya', 'EC', 78.0, 7, 2025)");
            st.executeUpdate("INSERT INTO Students VALUES (3, 'Amit', 'Civil', 65.0, 6, 2024)");

            System.out.println("Records Inserted");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
