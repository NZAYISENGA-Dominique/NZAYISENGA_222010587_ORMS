package all_objects;
import javax.swing.JOptionPane;
import java.sql.*;
public class Placement {
private int placement_id;
		private  String job_id;
		private  String jobseeker_id;
		private String start_date;
		private String end_date;
		private String job_name;
		private String company_name;
		
		 public Placement()  {}
		public Placement(int placement_id,  String jobplacement_id,  String jobseekerplacement_id, String start_date, String end_date,
	String job_name, String company_name) {
			this.placement_id = placement_id;
			this.job_id = jobplacement_id;
			this.jobseeker_id = jobseekerplacement_id;
			this.start_date = start_date;
			this.end_date = end_date;
			this.job_name = job_name;
			this.company_name= company_name;
			
		}
		public Placement(String jobplacement_id,  String jobseekerplacement_id, String start_date, String end_date,
				String job_name, String company_name) {
			this.job_id = jobplacement_id;
			this.jobseeker_id = jobseekerplacement_id;
			this.start_date = start_date;
			this.end_date = end_date;
			this.job_name = job_name;
			this.company_name= company_name;
		}
		
		public int getplacement_id() {
			return placement_id;
		}
		public void setplacement_id(int placement_id) {
			this.placement_id = placement_id;
		}
		public String getJob_id() {
			return job_id;
		}
		public void setJob_id(String job_id) {
			this.job_id = job_id;
		}
		public String getJobseeker_id() {
			return jobseeker_id;
		}
		public void setJobseeker_id(String jobseeker_id) {
			this.jobseeker_id = jobseeker_id;
		}
		public String getStart_date() {
			return start_date;
		}
		public void setStart_date(String start_date) {
			this.start_date = start_date;
		}
		public String getEnd_date() {
			return end_date;
		}
		public void setEnd_date(String end_date) {
			this.end_date = end_date;
		}
		public String getJob_name() {
			return job_name;
		}
		public void setJob_name(String job_name) {
			this.job_name = job_name;
		}
		public String getCompany_name() {
			return company_name;
		}
		public void setCompany_name(String company_name) {
			this.company_name = company_name;
		}
		//Method to establish database connection
		private Connection getConnection() throws SQLException {
		    String url = "jdbc:mysql://localhost/nzayisenga_222010587";
		    String username = "root";
		    String password = "";
		    return DriverManager.getConnection(url, username, password);
		}

		public void insertdater() {
		    String sql = "INSERT INTO placement (job_id, jobseeker_id, start_date, end_date, job_name, company_name) VALUES (?, ?, ?, ?, ?, ?)";
		    try (Connection con = getConnection();
		            PreparedStatement statement = con.prepareStatement(sql)) {
		        statement.setString(1, this.job_id);
		        statement.setString(2, this.jobseeker_id);
		        statement.setString(3, this.start_date);
		        statement.setString(4, this.end_date);
		        statement.setString(5, this.job_name);
		        statement.setString(6, this.company_name);
		        int rowsInserted = statement.executeUpdate();
		        if (rowsInserted > 0) {
		            JOptionPane.showMessageDialog(null, "Placement inserted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
		        } else {
		            JOptionPane.showMessageDialog(null, "Failed to insert placement!", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    } catch (SQLException e) {
		        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
		    }
		}

		    

		    public void readWithplacement_id(int inputplacement_id) {
		    	
		        String sql = "SELECT * FROM placement WHERE placement_id= ?";

		        try (Connection con = getConnection();
		                PreparedStatement statement = con.prepareStatement(sql)) {
		            statement.setInt(1, inputplacement_id);

		            ResultSet resultSet = statement.executeQuery();

		            if (resultSet.next()) {
		                this.job_id = resultSet.getString("job_id");
		                this.jobseeker_id = resultSet.getString("jobseeker_id");
		                this.start_date = resultSet.getString("start_date");
		                this.end_date = resultSet.getString("end_date");
		                this.job_name = resultSet.getString("job_name");
		                this.company_name= resultSet.getString("company_name");
		               
		            } else {
		                JOptionPane.showMessageDialog(null, "No user found with placement: " + inputplacement_id, "Read Error", JOptionPane.ERROR_MESSAGE);
		            }
		        } catch (SQLException e) {
		            JOptionPane.showMessageDialog(null, "Failed to read data: " + e.getMessage(), "Read Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		    public void update(int inputplacement_id) {
		   	 
		       String sql = "UPDATE placement SET job_id=?, jobseeker_id=?,start_date=?, end_date=?,job_name=?,company_name=? WHERE placement_id=?";

		       try (Connection con = getConnection();
		               PreparedStatement preparedStatement = con.prepareStatement(sql)) {
		           preparedStatement.setString(1, this.job_id);
		           preparedStatement.setString(2, this.jobseeker_id);
		           preparedStatement.setString(3, this.start_date);
		           preparedStatement.setString(4, this.end_date);
		           preparedStatement.setString(5, this.job_name);
		           preparedStatement.setString(6, this.company_name);
		           preparedStatement.setInt(7, inputplacement_id);

		           int rowsAffected = preparedStatement.executeUpdate();

		           if (rowsAffected > 0) {
		               JOptionPane.showMessageDialog(null, "Data update successfully!", "After upsalary", JOptionPane.INFORMATION_MESSAGE);
		           } else {
		               JOptionPane.showMessageDialog(null, "No user found with placement_id: " + inputplacement_id, "Upsalary Error", JOptionPane.ERROR_MESSAGE);
		           }
		       } catch (SQLException e) {
		           JOptionPane.showMessageDialog(null, "Failed to upsalary data: " + e.getMessage(), "Upsalary Error", JOptionPane.ERROR_MESSAGE);
		       }
		   }

		   public void delete(int inputplacement_id) {
		  
		       String sql = "DELETE FROM placement WHERE placement_id=?";

		       try (Connection con = getConnection();
		               PreparedStatement preparedStatement = con.prepareStatement(sql)) {
		           preparedStatement.setInt(1, inputplacement_id);

		           int rowsAffected = preparedStatement.executeUpdate();

		           if (rowsAffected > 0) {
		               JOptionPane.showMessageDialog(null, "Data deleted successfully!", "After delete", JOptionPane.INFORMATION_MESSAGE);
		           } else {
		               JOptionPane.showMessageDialog(null, "No user found with placement: " + inputplacement_id, "Delete Error", JOptionPane.ERROR_MESSAGE);
		           }
		       } catch (SQLException e) {
		           JOptionPane.showMessageDialog(null, "Failed to delete data: " + e.getMessage(), "Delete Error", JOptionPane.ERROR_MESSAGE);
		       }
		   }
		}





