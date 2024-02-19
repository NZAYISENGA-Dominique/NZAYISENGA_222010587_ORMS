package all_objects;
import javax.swing.JOptionPane;
import java.sql.*;
public class Recruiter {
private int recruiter_id;
		private  String recruiter_name;
		private String company_type;
		private String recruiter_address;
		private String recruiter_email;
		private String recruiter_description;
		private String recruiter_phone;
		private String industry;
		
		 public Recruiter()  {}
		public Recruiter(int recruiter_id,  String jobrecruiter_id,  String jobseekerrecruiter_id, String company_type, String recruiter_address, String start_company_type, String interviewtype,
				String recruiter_phone, String industry, String interviewstatus) {
			this.recruiter_id = recruiter_id;
			this.recruiter_name = jobseekerrecruiter_id;
			this.company_type = company_type;
			this.recruiter_address = recruiter_address;
			this.recruiter_email = start_company_type;
			this.recruiter_description = interviewtype;
			this.recruiter_phone = recruiter_phone;
			this.industry = industry;
			
		}
		public Recruiter(String jobrecruiter_id,  String jobseekerrecruiter_id, String company_type, String recruiter_address, String recruiter_email, String recruiter_description,
				String recruiter_phone, String industry) {
			this.recruiter_name = jobseekerrecruiter_id;
			this.company_type = company_type;
			this.recruiter_address = recruiter_address;
			this.recruiter_email = recruiter_email;
			this.recruiter_description = recruiter_description;
			this.recruiter_phone = recruiter_phone;
			this.industry = industry;
		}
		
		public int getRecruiter_id() {
			return recruiter_id;
		}
		public void setRecruiter_id(int recruiter_id) {
			this.recruiter_id = recruiter_id;
		}
		public String getRecruiter_name() {
			return recruiter_name;
		}
		public void setRecruiter_name(String recruiter_name) {
			this.recruiter_name = recruiter_name;
		}
		public String getCompany_type() {
			return company_type;
		}
		public void setCompany_type(String company_type) {
			this.company_type = company_type;
		}
		public String getRecruiter_address() {
			return recruiter_address;
		}
		public void setRecruiter_address(String recruiter_address) {
			this.recruiter_address = recruiter_address;
		}
		public String getRecruiter_email() {
			return recruiter_email;
		}
		public void setRecruiter_email(String recruiter_email) {
			this.recruiter_email = recruiter_email;
		}
		public String getRecruiter_description() {
			return recruiter_description;
		}
		public void setRecruiter_description(String recruiter_description) {
			this.recruiter_description = recruiter_description;
		}
		public String getRecruiter_phone() {
			return recruiter_phone;
		}
		public void setRecruiter_phone(String recruiter_phone) {
			this.recruiter_phone = recruiter_phone;
		}
		public String getIndustry() {
			return industry;
		}
		public void setIndustry(String industry) {
			this.industry = industry;
		}
		//Method to establish database connection
		private Connection getConnection() throws SQLException {
		    String url = "jdbc:mysql://localhost/nzayisenga_222010587";
		    String username = "root";
		    String password = "";
		    return DriverManager.getConnection(url, username, password);
		}

		public void insertdater() {
		    String sql = "INSERT INTO recruiter (recruiter_name, company_type, recruiter_address, recruiter_email, recruiter_description, recruiter_phone, industry) VALUES (?, ?, ?, ?, ?, ?, ?)";
		    try (Connection con = getConnection();
		            PreparedStatement statement = con.prepareStatement(sql)) {
		        statement.setString(1, this.recruiter_name);
		        statement.setString(2, this.company_type);
		        statement.setString(3, this.recruiter_address);
		        statement.setString(4, this.recruiter_email);
		        statement.setString(5, this.recruiter_description);
		        statement.setString(6, this.recruiter_phone);
		        statement.setString(7, this.industry);
		        int rowsInserted = statement.executeUpdate();
		        if (rowsInserted > 0) {
		            JOptionPane.showMessageDialog(null, "Recruiter inserted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
		        } else {
		            JOptionPane.showMessageDialog(null, "Failed to insert recruiter!", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    } catch (SQLException e) {
		        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
		    }
		}


		    public void readWithrecruiter_id(int inputrecruiter_id) {
		    	
		        String sql = "SELECT * FROM recruiter WHERE recruiter_id = ?";

		        try (Connection con = getConnection();
		                PreparedStatement statement = con.prepareStatement(sql)) {
		            statement.setInt(1, inputrecruiter_id);

		            ResultSet resultSet = statement.executeQuery();

		            if (resultSet.next()) {
		                this.recruiter_name = resultSet.getString("recruiter_name");
		                this.company_type = resultSet.getString("company_type");
		                this.recruiter_address = resultSet.getString("recruiter_address");
		                this.recruiter_email = resultSet.getString("recruiter_email");
		                this.recruiter_description = resultSet.getString("recruiter_description");
		                this.recruiter_phone = resultSet.getString("recruiter_phone");
		                this.industry = resultSet.getString("industry");
		               
		            } else {
		                JOptionPane.showMessageDialog(null, "No user found with recruiter: " + inputrecruiter_id, "Read Error", JOptionPane.ERROR_MESSAGE);
		            }
		        } catch (SQLException e) {
		            JOptionPane.showMessageDialog(null, "Failed to read data: " + e.getMessage(), "Read Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		    public void update(int inputrecruiter_id) {
		   	 
		       String sql = "UPDATE recruiter SET recruiter_name=?,company_type=?,recruiter_address=?, recruiter_email=?, recruiter_description=?,recruiter_phone=?,industry=? WHERE recruiter_id=?";

		       try (Connection con = getConnection();
		               PreparedStatement preparedStatement = con.prepareStatement(sql)) {
		           preparedStatement.setString(1, this.recruiter_name);
		           preparedStatement.setString(2, this.company_type);
		           preparedStatement.setString(3, this.recruiter_address);
		           preparedStatement.setString(4, this.recruiter_email);
		           preparedStatement.setString(5, this.recruiter_description);
		           preparedStatement.setString(6, this.recruiter_phone);
		           preparedStatement.setString(7, this.industry);
		           preparedStatement.setInt(8, inputrecruiter_id);

		           int rowsAffected = preparedStatement.executeUpdate();

		           if (rowsAffected > 0) {
		               JOptionPane.showMessageDialog(null, "Data update successfully!", "After upcompany_type", JOptionPane.INFORMATION_MESSAGE);
		           } else {
		               JOptionPane.showMessageDialog(null, "No user found with recruiter: " + inputrecruiter_id, "Upcompany_type Error", JOptionPane.ERROR_MESSAGE);
		           }
		       } catch (SQLException e) {
		           JOptionPane.showMessageDialog(null, "Failed to update data: " + e.getMessage(), "Upcompany_type Error", JOptionPane.ERROR_MESSAGE);
		       }
		   }

		   public void delete(int inputrecruiter_id) {
		  
		       String sql = "DELETE FROM recruiter WHERE recruiter_id=?";

		       try (Connection con = getConnection();
		               PreparedStatement preparedStatement = con.prepareStatement(sql)) {
		           preparedStatement.setInt(1, inputrecruiter_id);

		           int rowsAffected = preparedStatement.executeUpdate();

		           if (rowsAffected > 0) {
		               JOptionPane.showMessageDialog(null, "Data deleted successfully!", "After delete", JOptionPane.INFORMATION_MESSAGE);
		           } else {
		               JOptionPane.showMessageDialog(null, "No user found with recruiter_id: " + inputrecruiter_id, "Delete Error", JOptionPane.ERROR_MESSAGE);
		           }
		       } catch (SQLException e) {
		           JOptionPane.showMessageDialog(null, "Failed to delete data: " + e.getMessage(), "Delete Error", JOptionPane.ERROR_MESSAGE);
		       }
		   }
		}




