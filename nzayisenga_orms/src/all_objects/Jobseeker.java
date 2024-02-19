package all_objects;
import javax.swing.JOptionPane;
import java.sql.*;
public class Jobseeker {
		private String jobseeker_name;
		private  String jobseeker_phone;
		private  String jobseeker_email_address;
		private int jobseeker_ID;
		private String jobseeker_username;
		private String jobseeker_password;
		private String jobseeker_address;
		private String jobseeker_resume;
		private String jobseeker_disability;
		private String jobseeker_reference;
		private String application_date;
		private String  status;
		 public Jobseeker()  {}
		public Jobseeker(String jobseeker_name,String jobseeker_phone,  String jobseeker_email_address, int jobseeker_ID, String jobseeker_username, String jobseeker_password, String jobseeker_address,
				String jobseeker_resume, String jobseeker_disability, String jobseeker_reference,String application_date,String status) {
			this.jobseeker_name = jobseeker_name;
			this.jobseeker_phone = 	jobseeker_phone;
			this.jobseeker_email_address = jobseeker_email_address;
			this.jobseeker_ID = jobseeker_ID;
			this.jobseeker_username = jobseeker_username;
			this.jobseeker_password = jobseeker_password;
			this.jobseeker_address = jobseeker_address;
			this.jobseeker_resume = jobseeker_resume;
			this.jobseeker_disability = jobseeker_disability;
			this.jobseeker_reference = jobseeker_reference;
			this.application_date = application_date;
			this.status =status;
		}
		public Jobseeker(String jobseeker_name,String jobseeker_phone,  String jobseeker_email_address,String jobseeker_username, String jobseeker_password, String jobseeker_address,
				String jobseeker_resume, String jobseeker_disability, String jobseeker_reference,String application_date,String status) {
			this.jobseeker_name = jobseeker_name;
			this.jobseeker_phone = 	jobseeker_phone;
			this.jobseeker_email_address = jobseeker_email_address;
			this.jobseeker_username = jobseeker_username;
			this.jobseeker_password = jobseeker_password;
			this.jobseeker_address = jobseeker_address;
			this.jobseeker_resume = jobseeker_resume;
			this.jobseeker_disability = jobseeker_disability;
			this.jobseeker_reference = jobseeker_reference;
			this.application_date = application_date;
			this.status=status;
		}
		
		public String getJobseeker_name() {
			return jobseeker_name;
		}
		public void setJobseeker_name(String jobseeker_name) {
			this.jobseeker_name = jobseeker_name;
		}
		public String getJobseeker_phone() {
			return jobseeker_phone;
		}
		public void setJobseeker_phone(String jobseeker_phone) {
			this.jobseeker_phone = jobseeker_phone;
		}
		public String getJobseeker_email_address() {
			return jobseeker_email_address;
		}
		public void setJobseeker_email_address(String jobseeker_email_address) {
			this.jobseeker_email_address = jobseeker_email_address;
		}
		public int getJobseeker_ID() {
			return jobseeker_ID;
		}
		public void setJobseeker_ID(int jobseeker_ID) {
			this.jobseeker_ID = jobseeker_ID;
		}
		public String getJobseeker_username() {
			return jobseeker_username;
		}
		public void setJobseeker_username(String jobseeker_username) {
			this.jobseeker_username = jobseeker_username;
		}
		public String getJobseeker_password() {
			return jobseeker_password;
		}
		public void setJobseeker_password(String jobseeker_password) {
			this.jobseeker_password = jobseeker_password;
		}
		public String getJobseeker_address() {
			return jobseeker_address;
		}
		public void setJobseeker_address(String jobseeker_address) {
			this.jobseeker_address = jobseeker_address;
		}
		public String getJobseeker_resume() {
			return jobseeker_resume;
		}
		public void setJobseeker_resume(String jobseeker_resume) {
			this.jobseeker_resume = jobseeker_resume;
		}
		public String getJobseeker_disability() {
			return jobseeker_disability;
		}
		public void setJobseeker_disability(String jobseeker_disability) {
			this.jobseeker_disability = jobseeker_disability;
		}
		public String getJobseeker_reference() {
			return jobseeker_reference;
		}
		public void setJobseeker_reference(String jobseeker_reference) {
			this.jobseeker_reference = jobseeker_reference;
		}
		public String getApplication_date() {
			return application_date;
		}
		public void setApplication_date(String application_date) {
			this.application_date = application_date;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		//Method to establish database connection
		private Connection getConnection() throws SQLException {
		    String url = "jdbc:mysql://localhost/nzayisenga_222010587";
		    String username = "root";
		    String password = "";
		    return DriverManager.getConnection(url, username, password);
		}

		    public void insertjob() {
		        String sql = "INSERT INTO jobseeker (jobseeker_name,jobseeker_phone,jobseeker_email_address,jobseeker_username, jobseeker_password,jobseeker_address,jobseeker_resume,jobseeker_disability,jobseeker_reference,application_date,status) VALUES (?, ?, ?, ?, ?, ?, ?,?,?,?,?)";
		        try (Connection con = getConnection();
		                PreparedStatement statement = con.prepareStatement(sql)) {
		        	 statement.setString(1, this.jobseeker_name);
		        	statement.setString(2, this.jobseeker_phone);
		            statement.setString(3, this.jobseeker_email_address);
		            statement.setString(4, this.jobseeker_username);
		            statement.setString(5, this.jobseeker_password);
		            statement.setString(6, this.jobseeker_address);
		            statement.setString(7, this.jobseeker_resume);
		            statement.setString(8, this.jobseeker_disability);
		            statement.setString(9, this.jobseeker_reference);
		            statement.setString(10, this.application_date);
		            statement.setString(11, this.status);
		            int rowsInserted = statement.executeUpdate();
		            if (rowsInserted > 0) {
		                JOptionPane.showMessageDialog(null, "jobseeker inserted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
		            } else {
		                JOptionPane.showMessageDialog(null, "Failed to insert jobseeker!", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        } catch (SQLException e) {
		            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }

		    public void readWithjobseekerID(int inputjobseeker_ID) {
		    	
		        String sql = "SELECT * FROM jobseeker WHERE jobseeker_id= ?";

		        try (Connection con = getConnection();
		                PreparedStatement statement = con.prepareStatement(sql)) {
		            statement.setInt(1, inputjobseeker_ID);

		            ResultSet resultSet = statement.executeQuery();

		            if (resultSet.next()) {
		                this.jobseeker_name = resultSet.getString("jobseeker_name");
		            	this.	jobseeker_phone = resultSet.getString("jobseeker_phone");
		                this.jobseeker_email_address = resultSet.getString("jobseeker_email_address");
                         this.jobseeker_username = resultSet.getString("jobseeker_username");
		                this.jobseeker_password = resultSet.getString("jobseeker_password");
		                this.jobseeker_address = resultSet.getString("jobseeker_address");
		                this.jobseeker_resume = resultSet.getString("jobseeker_resume");
		                this.jobseeker_disability = resultSet.getString("jobseeker_disability");
		                this.jobseeker_reference = resultSet.getString("jobseeker_reference");
		                this.application_date = resultSet.getString("application_date");
		                this.status = resultSet.getString("status");
		            } else {
		                JOptionPane.showMessageDialog(null, "No user found with jobseeker_ID: " + inputjobseeker_ID, "Read Error", JOptionPane.ERROR_MESSAGE);
		            }
		        } catch (SQLException e) {
		            JOptionPane.showMessageDialog(null, "Failed to read data: " + e.getMessage(), "Read Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		    public void update(int inputjobseeker_ID) {
		   	 
		       String sql = "UPDATE  jobseeker SET jobseeker_name=?,jobseeker_phone=?,jobseeker_email_address=?,jobseeker_username=?, jobseeker_password=?,jobseeker_address=? ,jobseeker_resume=?,jobseeker_disability=?,jobseeker_reference=?,application_date=?,status =? WHERE jobseeker_id=?";

		       try (Connection con = getConnection();
		               PreparedStatement preparedStatement = con.prepareStatement(sql)) {
		    	   preparedStatement.setString(1, this.jobseeker_name);
		    	   preparedStatement.setString(2, this.	jobseeker_phone);
		           preparedStatement.setString(3, this.jobseeker_email_address);
		          preparedStatement.setString(4, this.jobseeker_username);
		           preparedStatement.setString(5, this.jobseeker_password);
		           preparedStatement.setString(6, this.jobseeker_address);
		           preparedStatement.setString(7, this.jobseeker_resume);
		           preparedStatement.setString(8, this.jobseeker_disability);
		           preparedStatement.setString(9, this.jobseeker_reference);
		           preparedStatement.setString(10, this.application_date);
		           preparedStatement.setString(11, this.status);
		           preparedStatement.setInt(12, inputjobseeker_ID);

		           int rowsAffected = preparedStatement.executeUpdate();

		           if (rowsAffected > 0) {
		               JOptionPane.showMessageDialog(null, "Data update successfully!", "After update", JOptionPane.INFORMATION_MESSAGE);
		           } else {
		               JOptionPane.showMessageDialog(null, "No user found with jobseeker: " + inputjobseeker_ID, "Update Error", JOptionPane.ERROR_MESSAGE);
		           }
		       } catch (SQLException e) {
		           JOptionPane.showMessageDialog(null, "Failed to update data: " + e.getMessage(), "Update Error", JOptionPane.ERROR_MESSAGE);
		       }
		   }

		   public void delete(int inputjobseeker_ID) {
		  
		       String sql = "DELETE FROM jobseeker WHERE jobseeker_id=?";

		       try (Connection con = getConnection();
		               PreparedStatement preparedStatement = con.prepareStatement(sql)) {
		           preparedStatement.setInt(1, inputjobseeker_ID);

		           int rowsAffected = preparedStatement.executeUpdate();

		           if (rowsAffected > 0) {
		               JOptionPane.showMessageDialog(null, "Data deleted successfully!", "After delete", JOptionPane.INFORMATION_MESSAGE);
		           } else {
		               JOptionPane.showMessageDialog(null, "No user found with jobseeker: " + inputjobseeker_ID, "Delete Error", JOptionPane.ERROR_MESSAGE);
		           }
		       } catch (SQLException e) {
		           JOptionPane.showMessageDialog(null, "Failed to delete data: " + e.getMessage(), "Delete Error", JOptionPane.ERROR_MESSAGE);
		       }
		   }
		}






