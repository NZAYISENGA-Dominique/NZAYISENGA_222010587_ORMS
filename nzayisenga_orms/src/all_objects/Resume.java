package all_objects;
import javax.swing.JOptionPane;
import java.sql.*;
public class Resume {
		private int Resume_id;
		private  String jobseeker_id;
		private String education;
		private String skills;
		private String work_experiance;
		private String languages;
		private String jobseeker_address;
		
		 public Resume()  {}
		public Resume(int Resume_id,   String jobseeker_id, String education, String skills, String work_experiance, String languages,
				String jobseeker_address) {
			this.Resume_id = Resume_id;
			this.jobseeker_id = jobseeker_id;
			this.education = education;
			this.skills = skills;
			this.work_experiance =work_experiance;
			this.languages = languages;
			this.jobseeker_address = jobseeker_address;
		
			
		}
		public Resume(  String jobseekerResume_id, String education, String skills, String work_experiance, String languages,
				String jobseeker_address, String reason_for_status) {
			this.jobseeker_id = jobseekerResume_id;
			this.education = education;
			this.skills = skills;
			this.work_experiance = work_experiance;
			this.languages = languages;
			this.jobseeker_address = jobseeker_address;
		}
		public int getResume_id() {
			return Resume_id;
		}
		public void setResume_id(int resume_id) {
			Resume_id = resume_id;
		}
		public String getJobseeker_id() {
			return jobseeker_id;
		}
		public void setJobseeker_id(String jobseeker_id) {
			this.jobseeker_id = jobseeker_id;
		}
		public String getEducation() {
			return education;
		}
		public void setEducation(String education) {
			this.education = education;
		}
		public String getSkills() {
			return skills;
		}
		public void setSkills(String skills) {
			this.skills = skills;
		}
		public String getWork_experiance() {
			return work_experiance;
		}
		public void setWork_experiance(String work_experiance) {
			this.work_experiance = work_experiance;
		}
		public String getLanguages() {
			return languages;
		}
		public void setLanguages(String languages) {
			this.languages = languages;
		}
		public String getJobseeker_address() {
			return jobseeker_address;
		}
		public void setJobseeker_address(String jobseeker_address) {
			this.jobseeker_address = jobseeker_address;
		}
	
		//Method to establish database connection
		private Connection getConnection() throws SQLException {
		    String url = "jdbc:mysql://localhost/nzayisenga_222010587";
		    String username = "root";
		    String password = "";
		    return DriverManager.getConnection(url, username, password);
		}

		   
		    	public void insertdater() {
		    	    String sql = "INSERT INTO resume (jobseeker_id, education, skills, work_experiance, languages, jobseeker_address) VALUES (?, ?, ?, ?, ?, ?)";
		    	    try (Connection con = getConnection();
		    	            PreparedStatement statement = con.prepareStatement(sql)) {
		    	        statement.setString(1, this.jobseeker_id);
		    	        statement.setString(2, this.education);
		    	        statement.setString(3, this.skills);
		    	        statement.setString(4, this.work_experiance);
		    	        statement.setString(5, this.languages);
		    	        statement.setString(6, this.jobseeker_address);
		    	        int rowsInserted = statement.executeUpdate();
		    	        if (rowsInserted > 0) {
		    	            JOptionPane.showMessageDialog(null, "Resume inserted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
		    	        } else {
		    	            JOptionPane.showMessageDialog(null, "Failed to insert resume!", "Error", JOptionPane.ERROR_MESSAGE);
		    	        }
		    	    } catch (SQLException e) {
		    	        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
		    	    }
		    	}

		    public void readWithResume_id(int inputResume_id) {
		    	
		        String sql = "SELECT * FROM resume WHERE Resume_id = ?";

		        try (Connection con = getConnection();
		                PreparedStatement statement = con.prepareStatement(sql)) {
		            statement.setInt(1, inputResume_id);

		            ResultSet resultSet = statement.executeQuery();

		            if (resultSet.next()) {
		                this.jobseeker_id = resultSet.getString("jobseeker_id");
		                this.education = resultSet.getString("education");
		                this.skills = resultSet.getString("skills");
		                this.work_experiance = resultSet.getString("work_experiance");
		                this.languages = resultSet.getString("languages");
		                this.jobseeker_address = resultSet.getString("jobseeker_address");
		               
		            } else {
		                JOptionPane.showMessageDialog(null, "No user found with Resume: " + inputResume_id, "Read Error", JOptionPane.ERROR_MESSAGE);
		            }
		        } catch (SQLException e) {
		            JOptionPane.showMessageDialog(null, "Failed to read data: " + e.getMessage(), "Read Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		    public void update(int inputResume_id) {
		   	 
		       String sql = "UPDATE resume SET jobseeker_id=?,education=?,skills=?, work_experiance=?, languages=?,jobseeker_address=?WHERE Resume_id=?";

		       try (Connection con = getConnection();
		               PreparedStatement preparedStatement = con.prepareStatement(sql)) {
		           preparedStatement.setString(1, this.jobseeker_id);
		           preparedStatement.setString(2, this.education);
		           preparedStatement.setString(3, this.skills);
		           preparedStatement.setString(4, this.work_experiance);
		           preparedStatement.setString(5, this.languages);
		           preparedStatement.setString(6, this.jobseeker_address);
		           preparedStatement.setInt(7, inputResume_id);

		           int rowsAffected = preparedStatement.executeUpdate();

		           if (rowsAffected > 0) {
		               JOptionPane.showMessageDialog(null, "Data update successfully!", "After upeducation", JOptionPane.INFORMATION_MESSAGE);
		           } else {
		               JOptionPane.showMessageDialog(null, "No user found with Resume_id: " + inputResume_id, "Upeducation Error", JOptionPane.ERROR_MESSAGE);
		           }
		       } catch (SQLException e) {
		           JOptionPane.showMessageDialog(null, "Failed to upeducation data: " + e.getMessage(), "Upeducation Error", JOptionPane.ERROR_MESSAGE);
		       }
		   }

		   public void delete(int inputResume_id) {
		  
		       String sql = "DELETE FROM resume WHERE Resume_id=?";

		       try (Connection con = getConnection();
		               PreparedStatement preparedStatement = con.prepareStatement(sql)) {
		           preparedStatement.setInt(1, inputResume_id);

		           int rowsAffected = preparedStatement.executeUpdate();

		           if (rowsAffected > 0) {
		               JOptionPane.showMessageDialog(null, "Data deleted successfully!", "After delete", JOptionPane.INFORMATION_MESSAGE);
		           } else {
		               JOptionPane.showMessageDialog(null, "No user found with Resume_id: " + inputResume_id, "Delete Error", JOptionPane.ERROR_MESSAGE);
		           }
		       } catch (SQLException e) {
		           JOptionPane.showMessageDialog(null, "Failed to delete data: " + e.getMessage(), "Delete Error", JOptionPane.ERROR_MESSAGE);
		       }
		   }
		}





