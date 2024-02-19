package all_objects;
import javax.swing.JOptionPane;
import java.sql.*;
public class interview {
private int id;
private  String jobid;
private  String jobseekerid;
private String date;
private String time;
private String location;
private String interviewtype;
private String interviewername;
private String interviewfeedback;
private String interviewstatus;
 public interview()  {}
public interview(int id,  String jobid,  String jobseekerid, String date, String time, String location, String interviewtype,
		String interviewername, String interviewfeedback, String interviewstatus) {
	this.id = id;
	this.jobid = jobid;
	this.jobseekerid = jobseekerid;
	this.date = date;
	this.time = time;
	this.location = location;
	this.interviewtype = interviewtype;
	this.interviewername = interviewername;
	this.interviewfeedback = interviewfeedback;
	this.interviewstatus = interviewstatus;
}
public interview(String jobid,  String jobseekerid, String date, String time, String location, String interviewtype,
		String interviewername, String interviewfeedback, String interviewstatus) {
	this.jobid = jobid;
	this.jobseekerid = jobseekerid;
	this.date = date;
	this.time = time;
	this.location = location;
	this.interviewtype = interviewtype;
	this.interviewername = interviewername;
	this.interviewfeedback = interviewfeedback;
	this.interviewstatus = interviewstatus;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public  String getJobid() {
	return jobid;
}
public void setJobid( String jobid) {
	this.jobid = jobid;
}
public  String getJobseekerid() {
	return jobseekerid;
}
public void setJobseekerid( String jobseekerid) {
	this.jobseekerid = jobseekerid;
}
public String getdate() {
	return date;
}
public void setdate(String date) {
	this.date = date;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getInterviewtype() {
	return interviewtype;
}
public void setInterviewtype(String interviewtype) {
	this.interviewtype = interviewtype;
}
public String getInterviewername() {
	return interviewername;
}
public void setInterviewername(String interviewername) {
	this.interviewername = interviewername;
}
public String getInterviewfeedback() {
	return interviewfeedback;
}
public void setInterviewfeedback(String interviewfeedback) {
	this.interviewfeedback = interviewfeedback;
}
public String getInterviewstatus() {
	return interviewstatus;
}
public void setInterviewstatus(String interviewstatus) {
	this.interviewstatus = interviewstatus;
}
//Method to establish database connection
private Connection getConnection() throws SQLException {
    String url = "jdbc:mysql://localhost/nzayisenga_222010587";
    String username = "root";
    String password = "";
    return DriverManager.getConnection(url, username, password);
}

    public void insertInterview() {
        String sql = "INSERT INTO interview (job_id,jobseeker_ID,date,time, location, interview_type, interview_name, interview_feedback, interview_status) VALUES (?, ?, ?, ?, ?, ?, ?,?,?)";
        try (Connection con = getConnection();
                PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, this.jobid);
            statement.setString(2, this.jobseekerid);
            statement.setString(3, this.date);
            statement.setString(4, this.time);
            statement.setString(5, this.location);
            statement.setString(6, this.interviewtype);
            statement.setString(7, this.interviewername);
            statement.setString(8, this.interviewfeedback);
            statement.setString(9, this.interviewstatus);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Interview inserted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to insert interview!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void readWithId(int inputId) {
    	
        String sql = "SELECT * FROM interview WHERE interview_id = ?";

        try (Connection con = getConnection();
                PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, inputId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                this.jobid = resultSet.getString("job_id");
                this.jobseekerid = resultSet.getString("jobseeker_id");
                this.date = resultSet.getString("date");
                this.time = resultSet.getString("location");
                this.location = resultSet.getString("location");
                this.interviewtype = resultSet.getString("interview_type");
                this.interviewername = resultSet.getString("interview_name");
                this.interviewfeedback = resultSet.getString("interview_feedback");
                this.interviewstatus = resultSet.getString("interview_status");
            } else {
                JOptionPane.showMessageDialog(null, "No user found with ID: " + inputId, "Read Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to read data: " + e.getMessage(), "Read Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void update(int inputinterviewId) {
   	 
       String sql = "UPDATE interview SET job_id=?, jobseeker_id=?,date=?,time=?, location=?, interview_type=?, interview_name=?, interview_feedback=?, interview_status =? WHERE interview_id=?";

       try (Connection con = getConnection();
               PreparedStatement preparedStatement = con.prepareStatement(sql)) {
           preparedStatement.setString(1, this.jobid);
           preparedStatement.setString(2, this.jobseekerid);
           preparedStatement.setString(3, this.date);
           preparedStatement.setString(4, this.time);
           preparedStatement.setString(5, this.location);
           preparedStatement.setString(6, this.interviewtype);
           preparedStatement.setString(7, this.interviewername);
           preparedStatement.setString(8, this.interviewfeedback);
           preparedStatement.setString(9, this.interviewstatus);
           preparedStatement.setInt(10, inputinterviewId);

           int rowsAffected = preparedStatement.executeUpdate();

           if (rowsAffected > 0) {
               JOptionPane.showMessageDialog(null, "Data updated successfully!", "After update", JOptionPane.INFORMATION_MESSAGE);
           } else {
               JOptionPane.showMessageDialog(null, "No user found with ID: " + inputinterviewId, "Update Error", JOptionPane.ERROR_MESSAGE);
           }
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Failed to update data: " + e.getMessage(), "Update Error", JOptionPane.ERROR_MESSAGE);
       }
   }

   public void delete(int inputUserId) {
  
       String sql = "DELETE FROM interview WHERE interview_id=?";

       try (Connection con = getConnection();
               PreparedStatement preparedStatement = con.prepareStatement(sql)) {
           preparedStatement.setInt(1, inputUserId);

           int rowsAffected = preparedStatement.executeUpdate();

           if (rowsAffected > 0) {
               JOptionPane.showMessageDialog(null, "Data deleted successfully!", "After delete", JOptionPane.INFORMATION_MESSAGE);
           } else {
               JOptionPane.showMessageDialog(null, "No user found with ID: " + inputUserId, "Delete Error", JOptionPane.ERROR_MESSAGE);
           }
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Failed to delete data: " + e.getMessage(), "Delete Error", JOptionPane.ERROR_MESSAGE);
       }
   }
}



