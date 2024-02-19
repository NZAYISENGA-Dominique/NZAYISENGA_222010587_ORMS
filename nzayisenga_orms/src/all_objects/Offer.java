package all_objects;
import javax.swing.JOptionPane;
import java.sql.*;
public class Offer {
	private int offer_id;
	private  String job_id;
	private  String jobseeker_id;
	private String salary;
	private String benefit;
	private String start_date;
	private String end_date;
	private String Offer_Status;
	private String reason_for_status;
	
	 public Offer()  {}
	public Offer(int offer_id,  String joboffer_id,  String jobseekeroffer_id, String salary, String benefit, String start_salary, String interviewtype,
			String Offer_Status, String reason_for_status, String interviewstatus) {
		this.offer_id = offer_id;
		this.job_id = joboffer_id;
		this.jobseeker_id = jobseekeroffer_id;
		this.salary = salary;
		this.benefit = benefit;
		this.start_date = start_salary;
		this.end_date = interviewtype;
		this.Offer_Status = Offer_Status;
		this.reason_for_status = reason_for_status;
		
	}
	public Offer(String joboffer_id,  String jobseekeroffer_id, String salary, String benefit, String start_date, String end_date,
			String Offer_Status, String reason_for_status) {
		this.job_id = joboffer_id;
		this.jobseeker_id = jobseekeroffer_id;
		this.salary = salary;
		this.benefit = benefit;
		this.start_date = start_date;
		this.end_date = end_date;
		this.Offer_Status = Offer_Status;
		this.reason_for_status = reason_for_status;
	}
	
	
	public int getOffer_id() {
		return offer_id;
	}
	public void setOffer_id(int offer_id) {
		this.offer_id = offer_id;
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
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getBenefit() {
		return benefit;
	}
	public void setBenefit(String benefit) {
		this.benefit = benefit;
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
	public String getOffer_Status() {
		return Offer_Status;
	}
	public void setOffer_Status(String offer_Status) {
		Offer_Status = offer_Status;
	}
	public String getReason_for_status() {
		return reason_for_status;
	}
	public void setReason_for_status(String reason_for_status) {
		this.reason_for_status = reason_for_status;
	}
	//Method to establish database connection
	private Connection getConnection() throws SQLException {
	    String url = "jdbc:mysql://localhost/nzayisenga_222010587";
	    String username = "root";
	    String password = "";
	    return DriverManager.getConnection(url, username, password);
	}
	public void insertdater() {
	    String sql = "INSERT INTO offer (job_id, jobseeker_id, salary, benefit, start_date, end_date, Offer_Status, reason_for_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	    try (Connection con = getConnection();
	         PreparedStatement statement = con.prepareStatement(sql)) {
	        statement.setString(1, this.job_id);
	        statement.setString(2, this.jobseeker_id);
	        statement.setString(3, this.salary);
	        statement.setString(4, this.benefit);
	        statement.setString(5, this.start_date);
	        statement.setString(6, this.end_date);
	        statement.setString(7, this.Offer_Status);
	        statement.setString(8, this.reason_for_status);
	        
	        int rowsInserted = statement.executeUpdate();
	        if (rowsInserted > 0) {
	            JOptionPane.showMessageDialog(null, "Offer inserted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            JOptionPane.showMessageDialog(null, "Failed to insert offer!", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
	    }
	}


	    public void readWithoffer_id(int inputoffer_id) {
	    	
	        String sql = "SELECT * FROM offer WHERE offer_id = ?";

	        try (Connection con = getConnection();
	                PreparedStatement statement = con.prepareStatement(sql)) {
	            statement.setInt(1, inputoffer_id);

	            ResultSet resultSet = statement.executeQuery();

	            if (resultSet.next()) {
	                this.job_id = resultSet.getString("job_id");
	                this.jobseeker_id = resultSet.getString("jobseeker_id");
	                this.salary = resultSet.getString("salary");
	                this.benefit = resultSet.getString("benefit");
	                this.start_date = resultSet.getString("start_date");
	                this.end_date = resultSet.getString("end_date");
	                this.Offer_Status = resultSet.getString("Offer_Status");
	                this.reason_for_status = resultSet.getString("reason_for_status");
	            } else {
	                JOptionPane.showMessageDialog(null, "No user found with Resume: " + inputoffer_id, "Read Error", JOptionPane.ERROR_MESSAGE);
	            }
	        } catch (SQLException e) {
	            JOptionPane.showMessageDialog(null, "Failed to read data: " + e.getMessage(), "Read Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	    public void update(int inputoffer_id) {
	   	 
	       String sql = "UPDATE offer SET job_id=?, jobseeker_id=?,salary=?,benefit=?, start_date=?, end_date=?,Offer_Status=?,reason_for_status=? WHERE offer_id=?";

	       try (Connection con = getConnection();
	               PreparedStatement preparedStatement = con.prepareStatement(sql)) {
	           preparedStatement.setString(1, this.job_id);
	           preparedStatement.setString(2, this.jobseeker_id);
	           preparedStatement.setString(3, this.salary);
	           preparedStatement.setString(4, this.benefit);
	           preparedStatement.setString(5, this.start_date);
	           preparedStatement.setString(6, this.end_date);
	           preparedStatement.setString(7, this.Offer_Status);
	           preparedStatement.setString(8, this.reason_for_status);
	           preparedStatement.setInt(9, inputoffer_id);

	           int rowsAffected = preparedStatement.executeUpdate();

	           if (rowsAffected > 0) {
	               JOptionPane.showMessageDialog(null, "Data update successfully!", "After upsalary", JOptionPane.INFORMATION_MESSAGE);
	           } else {
	               JOptionPane.showMessageDialog(null, "No user found with offer: " + inputoffer_id, "Upsalary Error", JOptionPane.ERROR_MESSAGE);
	           }
	       } catch (SQLException e) {
	           JOptionPane.showMessageDialog(null, "Failed to update data: " + e.getMessage(), "Upsalary Error", JOptionPane.ERROR_MESSAGE);
	       }
	   }

	   public void delete(int inputoffer_id) {
	  
	       String sql = "DELETE FROM offer WHERE offer_id=?";

	       try (Connection con = getConnection();
	               PreparedStatement preparedStatement = con.prepareStatement(sql)) {
	           preparedStatement.setInt(1, inputoffer_id);

	           int rowsAffected = preparedStatement.executeUpdate();

	           if (rowsAffected > 0) {
	               JOptionPane.showMessageDialog(null, "Data deleted successfully!", "After delete", JOptionPane.INFORMATION_MESSAGE);
	           } else {
	               JOptionPane.showMessageDialog(null, "No user found with offer_id: " + inputoffer_id, "Delete Error", JOptionPane.ERROR_MESSAGE);
	           }
	       } catch (SQLException e) {
	           JOptionPane.showMessageDialog(null, "Failed to delete data: " + e.getMessage(), "Delete Error", JOptionPane.ERROR_MESSAGE);
	       }
	   }
	}




