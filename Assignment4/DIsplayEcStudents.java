package Assignment4;

import java.sql.*;

public class DIsplayEcStudents {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String pass = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();

            String query = "SELECT * FROM Students "
                         + "WHERE semester = 7 AND branch = 'EC'";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                System.out.println(
                        rs.getInt("roll") + "  "
                      + rs.getString("name") + "  "
                      + rs.getString("branch") + "  "
                      + rs.getFloat("percentage") + "  "
                      + rs.getInt("semester") + "  "
                      + rs.getInt("passingYear")
                );
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
