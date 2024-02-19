package all_objects;
import javax.swing.JOptionPane;
import java.sql.*;
public class Job {
	private int job_id;
	private  String recruiter_id;
	private  String job_description;
	private String job_name;
	private String job_location;
	private String job_salary;
	private String posting_date;
	private String application_deadline;
	private String employment_type;
	private String job_requirements;
	private String department;
	private String status;
	 public Job()  {}
	public Job(int job_id,  String recruiter_id,  String job_description, String job_name, String job_location, String job_salary, String posting_date,
			String application_deadline, String employment_type, String job_requirements,String department,String status) {
		this.job_id = job_id;
		this.recruiter_id = recruiter_id;
		this.job_description = job_description;
		this.job_name = job_name;
		this.job_location = job_location;
		this.job_salary = job_salary;
		this.posting_date = posting_date;
		this.application_deadline = application_deadline;
		this.employment_type = employment_type;
		this.job_requirements = job_requirements;
		this.department = department;
		this.status = status;
	}
	public Job(String recruiter_id,  String job_description, String job_name, String job_location, String job_salary, String posting_date,
			String application_deadline, String employment_type, String job_requirements,String department,String status) {
		this.recruiter_id = recruiter_id;
		this.job_description = job_description;
		this.job_name = job_name;
		this.job_location = job_location;
		this.job_salary = job_salary;
		this.posting_date = posting_date;
		this.application_deadline = application_deadline;
		this.employment_type = employment_type;
		this.job_requirements = job_requirements;
		this.department = department;
		this.status = status;
	}
	
	public int getJob_id() {
		return job_id;
	}
	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	public String getRecruiter_id() {
		return recruiter_id;
	}
	public void setRecruiter_id(String recruiter_id) {
		this.recruiter_id = recruiter_id;
	}
	public String getJob_description() {
		return job_description;
	}
	public void setJob_description(String job_description) {
		this.job_description = job_description;
	}
	public String getJob_name() {
		return job_name;
	}
	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}
	public String getJob_location() {
		return job_location;
	}
	public void setJob_location(String job_location) {
		this.job_location = job_location;
	}
	public String getJob_salary() {
		return job_salary;
	}
	public void setJob_salary(String job_salary) {
		this.job_salary = job_salary;
	}
	public String getPosting_date() {
		return posting_date;
	}
	public void setPosting_date(String posting_date) {
		this.posting_date = posting_date;
	}
	public String getApplication_deadline() {
		return application_deadline;
	}
	public void setApplication_deadline(String application_deadline) {
		this.application_deadline = application_deadline;
	}
	public String getEmployment_type() {
		return employment_type;
	}
	public void setEmployment_type(String employment_type) {
		this.employment_type = employment_type;
	}
	public String getJob_requirements() {
		return job_requirements;
	}
	public void setJob_requirements(String job_requirements) {
		this.job_requirements = job_requirements;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
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
	        String sql = "INSERT INTO job (recruiter_id,job_description,job_name,job_location, job_salary,posting_date,	application_deadline,employment_type,job_requirements,department,status) VALUES (?, ?, ?, ?, ?, ?, ?,?,?,?,?)";
	        try (Connection con = getConnection();
	                PreparedStatement statement = con.prepareStatement(sql)) {
	            statement.setString(1, this.recruiter_id);
	            statement.setString(2, this.job_description);
	            statement.setString(3, this.job_name);
	            statement.setString(4, this.job_location);
	            statement.setString(5, this.job_salary);
	            statement.setString(6, this.posting_date);
	            statement.setString(7, this.application_deadline);
	            statement.setString(8, this.employment_type);
	            statement.setString(9, this.job_requirements);
	            statement.setString(10, this.department);
	            statement.setString(11, this.status);
	            int rowsInserted = statement.executeUpdate();
	            if (rowsInserted > 0) {
	                JOptionPane.showMessageDialog(null, "job inserted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
	            } else {
	                JOptionPane.showMessageDialog(null, "Failed to insert job!", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        } catch (SQLException e) {
	            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }

	    public void readWithjob_id(int inputjob_id) {
	    	
	        String sql = "SELECT * FROM job WHERE job_id = ?";

	        try (Connection con = getConnection();
	                PreparedStatement statement = con.prepareStatement(sql)) {
	            statement.setInt(1, inputjob_id);

	            ResultSet resultSet = statement.executeQuery();

	            if (resultSet.next()) {
	                this.recruiter_id = resultSet.getString("recruiter_id");
	                this.job_description = resultSet.getString("job_description");
	                this.job_name = resultSet.getString("job_name");
	                this.job_location = resultSet.getString("job_location");
	                this.job_salary = resultSet.getString("job_salary");
	                this.posting_date = resultSet.getString("posting_date");
	                this.application_deadline = resultSet.getString("application_deadline");
	                this.employment_type = resultSet.getString("employment_type");
	                this.job_requirements = resultSet.getString("job_requirements");
	                this.department = resultSet.getString("department");
	                this.status = resultSet.getString("status");
	            } else {
	                JOptionPane.showMessageDialog(null, "No user found with job_id: " + inputjob_id, "Read Error", JOptionPane.ERROR_MESSAGE);
	            }
	        } catch (SQLException e) {
	            JOptionPane.showMessageDialog(null, "Failed to read data: " + e.getMessage(), "Read Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	    public void update(int inputjob_id) {
	   	 
	       String sql = "UPDATE  job SET recruiter_id=?,job_description=?,job_name=?,job_location=?, job_salary=?,posting_date=? ,application_deadline=?,employment_type=?,job_requirements=?,department=?,status =? WHERE job_id=?";

	       try (Connection con = getConnection();
	               PreparedStatement preparedStatement = con.prepareStatement(sql)) {
	           preparedStatement.setString(1, this.recruiter_id);
	           preparedStatement.setString(2, this.job_description);
	           preparedStatement.setString(3, this.job_name);
	           preparedStatement.setString(4, this.job_location);
	           preparedStatement.setString(5, this.job_salary);
	           preparedStatement.setString(6, this.posting_date);
	           preparedStatement.setString(7, this.application_deadline);
	           preparedStatement.setString(8, this.employment_type);
	           preparedStatement.setString(9, this.job_requirements);
	           preparedStatement.setString(10, this.department);
	           preparedStatement.setString(11, this.status);
	           preparedStatement.setInt(12, inputjob_id);

	           int rowsAffected = preparedStatement.executeUpdate();

	           if (rowsAffected > 0) {
	               JOptionPane.showMessageDialog(null, "Data update successfully!", "After upjob_name", JOptionPane.INFORMATION_MESSAGE);
	           } else {
	               JOptionPane.showMessageDialog(null, "No user found with job_id: " + inputjob_id, "Update Error", JOptionPane.ERROR_MESSAGE);
	           }
	       } catch (SQLException e) {
	           JOptionPane.showMessageDialog(null, "Failed to update data: " + e.getMessage(), "Update Error", JOptionPane.ERROR_MESSAGE);
	       }
	   }

	   public void delete(int inputjob_id) {
	  
	       String sql = "DELETE FROM job WHERE job_id=?";

	       try (Connection con = getConnection();
	               PreparedStatement preparedStatement = con.prepareStatement(sql)) {
	           preparedStatement.setInt(1, inputjob_id);

	           int rowsAffected = preparedStatement.executeUpdate();

	           if (rowsAffected > 0) {
	               JOptionPane.showMessageDialog(null, "Data deleted successfully!", "After delete", JOptionPane.INFORMATION_MESSAGE);
	           } else {
	               JOptionPane.showMessageDialog(null, "No user found with job_id: " + inputjob_id, "Delete Error", JOptionPane.ERROR_MESSAGE);
	           }
	       } catch (SQLException e) {
	           JOptionPane.showMessageDialog(null, "Failed to delete data: " + e.getMessage(), "Delete Error", JOptionPane.ERROR_MESSAGE);
	       }
	   }
	}





