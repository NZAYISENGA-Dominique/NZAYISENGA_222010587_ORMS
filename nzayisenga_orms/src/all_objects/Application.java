package all_objects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Application {
	private int app_id;
    private String jobSeekerId;
    private String jobName;
    private String date;
    private String status;
    private String institution;
    private String action;
  public Application() 
	 {}
  public Application(int app_id,String jobSeekerId, String jobName, String date, String status, String institution, String action) {
	  this.app_id= app_id;
	  this.jobSeekerId = jobSeekerId;
      this.jobName = jobName;
      this.date = date;
      this.status = status;
      this.institution = institution;
      this.action = action;
  }
    public Application(String jobSeekerId, String jobName, String date, String status, String institution, String action) {
        this.jobSeekerId = jobSeekerId;
        this.jobName = jobName;
        this.date = date;
        this.status = status;
        this.institution = institution;
        this.action = action;
    }

    public int getApp_id() {
		return app_id;
	}
	public void setApp_id(int app_id) {
		this.app_id = app_id;
	}
	public String getJobSeekerId() {
		return jobSeekerId;
	}

	public void setJobSeekerId(String jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public void insertData() {
        String url = "jdbc:mysql://localhost/nzayisenga_222010587";
        String user = "root";
        String password = "";
        String sql = "INSERT INTO application (jobseeker_ID, job_name,application_date,status,institution, action) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, jobSeekerId);
            preparedStatement.setString(2, jobName);
            preparedStatement.setString(3, date);
            preparedStatement.setString(4, status);
            preparedStatement.setString(5, institution);
            preparedStatement.setString(6, action);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully!");
                JOptionPane.showMessageDialog(null, "Data inserted successfully!", "Insert Status", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Failed to insert data.");
                JOptionPane.showMessageDialog(null, "Failed to insert data!", "Insert Status", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    public void readWithID(int inputId) {
        String url = "jdbc:mysql://localhost/nzayisenga_222010587";
        String user = "root";
        String password = "";
        String sql = "SELECT * FROM application WHERE application_id = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, inputId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                this.jobSeekerId = resultSet.getString("jobseeker_id");
                this.jobName = resultSet.getString("job_name");
                this.date = resultSet.getString("application_date");
                this.status = resultSet.getString("status");
                this.institution = resultSet.getString("institution");
                this.action = resultSet.getString("action");
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    public void update(int inputId) {
        String url = "jdbc:mysql://localhost/nzayisenga_222010587";
        String user = "root";
        String password = "";
        String sql = "UPDATE application SET jobseeker_id = ?, job_name = ?, application_date = ?, status = ?, institution = ?, action = ? WHERE application_id = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, jobSeekerId);
            preparedStatement.setString(2, jobName);
            preparedStatement.setString(3, date);
            preparedStatement.setString(4, status);
            preparedStatement.setString(5, institution);
            preparedStatement.setString(6, action);
            preparedStatement.setInt(7, inputId);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data updated successfully!");
            } else {
                System.out.println("Failed to update data. No matching record found.");
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    public void delete(int inputId) {
        String url = "jdbc:mysql://localhost/nzayisenga_222010587";
        String user = "root";
        String password = "";
        String sql = "DELETE FROM application WHERE application_id = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, inputId);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data deleted successfully!");
            } else {
                System.out.println("Failed to delete data. No matching record found.");
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    private void handleSQLException(SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Failed to execute database operation: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }
    private String email;
    private String password;
    public void application(String email,String password) {
    	this.email=email;
    	this.password=password;
	}
    
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String text) {
		
		
	}
	

public void login() {
    
    if (isValidUser(email, password)) {
        System.out.println("Login successful");
    } else {
        System.out.println("Invalid username or password");
    }
}

private boolean isValidUser(String email, String password) {
    // TODO: Implement your user validation logic here
    // This could involve checking credentials against a database, file, or other storage
    
    // Example validation (replace with your actual logic):
    return email.equals("admin") && password.equals("password");
}



}
