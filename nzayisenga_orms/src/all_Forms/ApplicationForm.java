package all_Forms;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import all_objects.*;
public class ApplicationForm implements ActionListener {
	    JFrame frame;
	    JLabel id_lb = new JLabel("app_id");
	    JLabel appseeker_lb = new JLabel("jobseeker_id");
	    JLabel appName_lb = new JLabel("job_name");
	    JLabel version_lb = new JLabel("application_date");
	    JLabel platform_lb = new JLabel("status");
	    JLabel website_lb = new JLabel("institution");
	    JLabel contact_lb = new JLabel("action");
//text
	    JTextField id_txf = new JTextField();
	    JTextField appseeker_txf = new JTextField();
	    JTextField appName_txf = new JTextField();
	    JTextField data_txf = new JTextField();
	    JTextField sta_txf = new JTextField();
	    JTextField insti_txf = new JTextField();
	    JTextField action_txf = new JTextField();

	    JButton insert_btn = new JButton("Insert");
	    JButton view_btn = new JButton("View");
	    JButton update_btn = new JButton("Update");
	    JButton delete_btn = new JButton("Delete");

	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    int w = (int) screenSize.getWidth();
	    int h = (int) screenSize.getHeight();

	    public ApplicationForm() {
	        createForm();
	    }

	    private void addActionListeners() {
	        insert_btn.addActionListener(this);
	        view_btn.addActionListener(this);
	        update_btn.addActionListener(this);
	        delete_btn.addActionListener(this);
	    }

	    private void createForm() {
	        frame = new JFrame();
	        frame.setTitle("APPLICATION FORM");
	        frame.setBounds(10, 10, 700, 400);
	        frame.getContentPane().setLayout(null);
	        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setResizable(true);
	        setLocationAndSize();
	    }

	    private void setLocationAndSize() {
	        id_lb.setBounds(10, 10, 100, 30);
	        appseeker_lb.setBounds(10, 50, 100, 30);
	        appName_lb.setBounds(10, 90, 100, 30);
	        version_lb.setBounds(10, 130, 100, 30);
	        platform_lb.setBounds(10, 170, 100, 30);
	        website_lb.setBounds(10, 210, 100, 30);
	        contact_lb.setBounds(10, 250, 100, 30);

	        id_txf.setBounds(160, 10, 130, 30);
	        appseeker_txf.setBounds(160, 50, 130, 30);
	        appName_txf.setBounds(160, 90, 130, 30);
	        data_txf.setBounds(160, 130, 130, 30);
	        sta_txf.setBounds(160, 170, 130, 30);
	        insti_txf.setBounds(160, 210, 130, 30);
	        action_txf.setBounds(160, 250, 130, 30);

	        insert_btn.setBounds(10, 290, 85, 30);
	        view_btn.setBounds(100, 290, 85, 30);
	        update_btn.setBounds(190, 290, 85, 30);
	        delete_btn.setBounds(280, 290, 85, 30);

	        setFontForAll();
	        addComponentsToFrame();
	    }

	    private void setFontForAll() {
	        Font font = new Font("Georgia", Font.BOLD, 18);

	        id_lb.setFont(font);
	        appseeker_lb.setFont(font);
	        appName_lb.setFont(font);
	        version_lb.setFont(font);
	        platform_lb.setFont(font);
	        website_lb.setFont(font);
	        contact_lb.setFont(font);

	        id_txf.setFont(font);
	        appseeker_txf.setFont(font);
	        appName_txf.setFont(font);
	        data_txf.setFont(font);
	        sta_txf.setFont(font);
	        insti_txf.setFont(font);
	        action_txf.setFont(font);

	        Font fonti = new Font("Courier New", Font.BOLD, 12);

	        insert_btn.setFont(fonti);
	        view_btn.setFont(fonti);
	        update_btn.setFont(fonti);
	        delete_btn.setFont(fonti);
	    }

	    private void addComponentsToFrame() {
	        frame.add(id_lb);
	        frame.add(appseeker_lb);
	        frame.add(appName_lb);
	        frame.add(version_lb);
	        frame.add(platform_lb);
	        frame.add(website_lb);
	        frame.add(contact_lb);

	        frame.add(id_txf);
	        frame.add(appseeker_txf);
	        frame.add(appName_txf);
	        frame.add(data_txf);
	        frame.add(sta_txf);
	        frame.add(insti_txf);
	        frame.add(action_txf);

	        frame.add(insert_btn);
	        frame.add(view_btn);
	        frame.add(update_btn);
	        frame.add(delete_btn);

	        addActionListeners();
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        Application app = new Application();
	        if (e.getSource() == insert_btn) {
	        	app.setJobSeekerId(appseeker_txf.getText());
	            app.setJobName(appName_txf.getText());
	            app.setStatus(data_txf.getText());
	            app.setDate(sta_txf.getText());
	            app.setInstitution(insti_txf.getText());
	            app.setAction(action_txf.getText());
	            app.insertData();
	        } else if (e.getSource() == view_btn) {
	            int id = Integer.parseInt(id_txf.getText());
	            app.readWithID(id);
	            id_txf.setText(String.valueOf(app.getApp_id()));
	            appName_txf.setText(app.getJobName());
	            appseeker_txf.setText(app.getJobSeekerId());
	            data_txf.setText(app.getDate());
	            sta_txf.setText(app.getStatus());
	            insti_txf.setText(app.getInstitution());
	            action_txf.setText(app.getAction());
	        } else if (e.getSource() == update_btn) {
	            int id = Integer.parseInt(id_txf.getText());
	            app.setJobSeekerId(appseeker_txf.getText());
	            app.setJobName(appName_txf.getText());
	            app.setStatus(data_txf.getText());
	            app.setDate(sta_txf.getText());
	            app.setInstitution(insti_txf.getText());
	            app.setAction(action_txf.getText());
	            app.insertData();
	            app.update(id);
	        } else {
	            int id = Integer.parseInt(id_txf.getText());
	            app.delete(id);
	        }
	    }

	    public static void main(String[] args) {
	        ApplicationForm appForms = new ApplicationForm();
	        System.out.println(appForms);
	    }

		public void setVisible(boolean b) {
			// TODO Auto-generated method stub
			
		}
	}


