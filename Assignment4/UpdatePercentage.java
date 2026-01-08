package Assignment4;

import java.sql.*;

public class UpdatePercentage {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String pass = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();

            String query = "UPDATE Students SET percentage = percentage + (percentage * 0.05) "
                         + "WHERE branch = 'CSE'";

            int updated = st.executeUpdate(query);
            System.out.println("Updated Records: " + updated);

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
