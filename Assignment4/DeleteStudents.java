package Assignment4;

import java.sql.*;

public class DeleteStudents {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String pass = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();

            String query = "DELETE FROM Students "
                         + "WHERE passingYear = 2024 AND branch = 'Civil'";

            int deleted = st.executeUpdate(query);
            System.out.println("Deleted Records: " + deleted);

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
