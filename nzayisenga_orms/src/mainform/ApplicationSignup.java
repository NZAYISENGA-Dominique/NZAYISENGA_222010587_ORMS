package mainform;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import all_objects.*;


public class ApplicationSignup  extends JFrame{
	
    private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jnametext;
	private JTextField seekertext;
	private JTextField datetext;
	private JTextField statustxt;
	private JTextField institext;
	private JTextField acttext;
	private JTextField emailtext;
	private JPasswordField passwordtext;
	

	/**
	 * Launch the application.
	 */

public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
	public void run() {
		try {
			ApplicationSignup frame = new ApplicationSignup();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
});
}

/**
* Create the frame.
*/
public ApplicationSignup() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 633, 505);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

setContentPane(contentPane);
contentPane.setLayout(null);

JLabel lblfnmae = new JLabel("jobseeker_id :");
lblfnmae.setBounds(10, 77, 85, 23);
contentPane.add(lblfnmae);

JLabel lbllname = new JLabel("job_name :");
lbllname.setBounds(10, 124, 85, 23);
contentPane.add(lbllname);

seekertext = new JTextField();
seekertext.setBounds(97, 73, 180, 33);
contentPane.add(jnametext);
seekertext.setColumns(10);

jnametext = new JTextField();
jnametext.setBounds(97, 123, 180, 33);
jnametext.setColumns(10);
contentPane.add(jnametext);

JLabel lblPhone = new JLabel("application_date :");
lblPhone.setBounds(10, 183, 77, 23);
contentPane.add(lblPhone);
//fname, lname, phone,email, username, password
datetext = new JTextField();
datetext.setBounds(97, 179, 180, 33);
datetext.setColumns(10);
contentPane.add(datetext);

JLabel lblEmail = new JLabel("Email :");
lblEmail.setBounds(348, 124, 77, 23);
contentPane.add(lblEmail);

emailtext = new JTextField();
emailtext.setBounds(425, 123, 180, 33);
emailtext.setColumns(10);
contentPane.add(emailtext);

JLabel lblDateOfBirth = new JLabel("Action :");
lblDateOfBirth.setBounds(348, 77, 77, 23);
contentPane.add(lblDateOfBirth);

acttext = new JTextField();
acttext.setBounds(425, 73, 180, 33);
acttext.setColumns(10);
contentPane.add(acttext);
JLabel lbinsitution = new JLabel("institution :");
lbinsitution.setBounds(348, 77, 77, 23);
contentPane.add(lbinsitution);

institext = new JTextField();
institext.setBounds(425, 73, 180, 33);
institext.setColumns(10);
contentPane.add(institext);
JLabel lb1status1= new JLabel("status :");
lb1status1.setBounds(348, 77, 77, 23);
contentPane.add(lb1status1);

statustxt = new JTextField();
statustxt.setBounds(425, 73, 180, 33);
statustxt.setColumns(10);
contentPane.add(statustxt);

JLabel lblPhone_1_1 = new JLabel("Password :");
lblPhone_1_1.setBounds(348, 183, 77, 23);
contentPane.add(lblPhone_1_1);

passwordtext = new JPasswordField();
passwordtext.setBounds(423, 179, 182, 33);
contentPane.add(passwordtext);

JButton btnNewButton = new JButton("CANCEL");
btnNewButton.setBounds(209, 285, 126, 33);
contentPane.add(btnNewButton);

JButton signUp = new JButton("SIGN UP");
signUp.setBounds(380, 285, 132, 33);
signUp.addActionListener(new ActionListener() {
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		ApplicationSignup frame = new ApplicationSignup ();
		frame.setVisible(true);
		Application ad = new Application();
		if(e.getSource()==signUp) {
			ad.setJobName(jnametext.getText());
			ad.setDate(datetext.getText());
			ad.setPassword(passwordtext.getText());
			ad.setJobSeekerId(seekertext.getText());
			ad.setStatus(statustxt.getText());
			ad.setEmail(emailtext.getText());
			ad.setInstitution(institext.getText());
			ad.setAction(emailtext.getText());
			char[] passwordChars = passwordtext.getPassword();
			String passwordString = new String(passwordChars);
			ad.setPassword(passwordString);
			ad.insertData();
			System.out.print(ad.getJobName() + " " + ad.getJobSeekerId() + " "  + " " + ad.getPassword() + " " + " " +ad.getEmail() + " " +  ad.getDate() + " " + ad.getStatus()+ " " + ad.getAction()+ " " + ad.getInstitution() );
		}
	}
});
contentPane.add(signUp);
}

}


