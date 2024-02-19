package connectivity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class interviewtestconnectivity {

		    public static void main(String[] args) {
		        Connection co = null;
		        PreparedStatement stm = null;
		        ResultSet rs = null;
		        String sql = "SELECT * FROM interview";
		        String host = "jdbc:mysql://localhost/nzayisenga_222010587";
		        String user = "root";
		        String pass = "";

		        try {
		            Class.forName("com.mysql.jdbc.Driver");

		            co = DriverManager.getConnection(host, user, pass);
		            stm = co.prepareStatement(sql);
		            rs = stm.executeQuery();
		            while (rs.next()) {
		                String id = rs.getString("interview_id");
		                String joid = rs.getString("job_id");
		                String seid = rs.getString("jobseeker_id");
		                String da = rs.getString("date");
		                String ti = rs.getString("time");
		                String lo = rs.getString("location");
		                String ty = rs.getString("interview_type");
		                String name = rs.getString("interview_name");
		                String fe = rs.getString("interview_feedback");
		                String sta = rs.getString("interview_status");

		                System.out.println(id + "\t" + joid + "\t" + seid + "\t" + da + "\t" +ti+ "\t" +lo + "\t" + ty+"\t" +name+ "\t" +fe + "\t" + sta);
		            }
		        } catch (ClassNotFoundException e) {
		            System.out.println("Error: JDBC driver not found");
		        } catch (SQLException e) {
		            System.out.println("Error: Unable to access the database.");
		            e.printStackTrace();
		        } finally {
		            try {
		                if (rs != null) {
		                    rs.close();
		                }
		                if (stm != null) {
		                    stm.close();
		                }
		                if (co != null) {
		                    co.close();
		                }
		            } catch (SQLException e) {
		                System.out.println("Error: Unable to close the database connection");
		            }
		        }
		    }
		}


