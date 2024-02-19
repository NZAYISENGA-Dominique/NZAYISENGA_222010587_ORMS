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
public class JobseekerForm  implements ActionListener {
				    JFrame frame;
				    JLabel name_lb = new JLabel("Jobseeker_name");
				    JLabel phone__lb = new JLabel("Jobseeker_phone");
				    JLabel email__lb = new JLabel("Jobseeker_email_address");
				    JLabel id_lb = new JLabel("Jobseeker_ID");
				    JLabel user__lb = new JLabel("Jobseeker_username");
				    JLabel pass__lb = new JLabel("Jobseeker_password");
				    JLabel add_lb = new JLabel("Jobseeker_address");
				    JLabel res__lb = new JLabel("Jobseeker_resume");
				    JLabel dis__lb = new JLabel("Jobseeker_disability");
				    JLabel ref__lb = new JLabel("Jobseeker_reference");
				    JLabel app__lb = new JLabel("Application_date");
				    JLabel st_lb = new JLabel("Status");
			//text
				    JTextField name_txf = new JTextField();
				    JTextField phone__txf = new JTextField();
				    JTextField email__txf = new JTextField();
				    JTextField id_txf = new JTextField();
				    JTextField user_txf = new JTextField();
				    JTextField pass_txf = new JTextField();
				    JTextField add_txf = new JTextField();
				    JTextField res_txf = new JTextField();
				    JTextField dis_txf = new JTextField();
				    JTextField ref_txf = new JTextField();
				    JTextField app_txf = new JTextField();
				    JTextField st_txf = new JTextField();

				    JButton insert_btn = new JButton("Insert");
				    JButton view_btn = new JButton("View");
				    JButton update_btn = new JButton("Update");
				    JButton delete_btn = new JButton("Delete");

				    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				    int w = (int) screenSize.getWidth();
				    int h = (int) screenSize.getHeight();

				 public JobseekerForm() {
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
				        frame.setTitle("JOBSEEKER FORM");
				        frame.setBounds(10, 10, 700, 600);
				        frame.getContentPane().setLayout(null);
				        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
				        frame.setVisible(true);
				        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				        frame.setResizable(true);
				        setLocationAndSize();
				    }

				    private void setLocationAndSize() {
				        name_lb.setBounds(10, 10, 200, 30);
				        phone__lb.setBounds(10, 50, 200, 30);
				        email__lb.setBounds(10, 90, 200, 30);
				        id_lb.setBounds(10, 130, 200, 30);
				        user__lb.setBounds(10, 170, 200, 30);
				        pass__lb.setBounds(10, 210, 200, 30);
				        add_lb.setBounds(10, 250, 200, 30);
				        res__lb.setBounds(10, 290, 200, 30);
				        dis__lb.setBounds(10, 330, 200, 30);
				        ref__lb.setBounds(10, 370, 200, 30);
				        app__lb.setBounds(10, 410, 200, 30);
				        st_lb.setBounds(10, 450, 200, 30);
				       

				        name_txf.setBounds(240, 10, 180, 30);
				        phone__txf.setBounds(240, 50, 180, 30);
				        email__txf.setBounds(240, 90, 180, 30);
				        id_txf.setBounds(240, 130, 180, 30);
				        user_txf.setBounds(240, 170, 180, 30);
				       pass_txf.setBounds(240, 210, 180, 30);
				       add_txf.setBounds(240, 250, 180, 30);
				       res_txf.setBounds(240, 290, 180, 30);
				        dis_txf.setBounds(240, 330, 180, 30);
				        ref_txf.setBounds(240, 370, 180, 30);
				        app_txf.setBounds(240, 410, 180, 30);
				        st_txf.setBounds(240, 450, 180, 30);

				        insert_btn.setBounds(10, 490, 85, 30);
				        view_btn.setBounds(100, 490, 85, 30);
				        update_btn.setBounds(190, 490, 85, 30);
				        delete_btn.setBounds(280, 490, 85, 30);

				        setFontForAll();
				        addComponentsToFrame();
				    }

				    private void setFontForAll() {
				        Font font = new Font("Georgia", Font.BOLD, 18);

				        id_lb.setFont(font);
				        phone__lb.setFont(font);
				        email__lb.setFont(font);
				        name_lb.setFont(font);
				        user__lb.setFont(font);
				        pass__lb.setFont(font);
				        add_lb.setFont(font);
				        res__lb.setFont(font);
				        dis__lb.setFont(font);
				        ref__lb.setFont(font);
				        app__lb.setFont(font);
				        st_lb.setFont(font);

				        id_txf.setFont(font);
				        phone__txf.setFont(font);
				        email__txf.setFont(font);
				        name_txf.setFont(font);
				        user_txf.setFont(font);
				       pass_txf.setFont(font);
				       add_txf.setFont(font);
				        res_txf.setFont(font);
				        dis_txf.setFont(font);
				        ref_txf.setFont(font);
				        app_txf.setFont(font);
				        st_txf.setFont(font);

				        Font fonti = new Font("Courier New", Font.BOLD, 12);

				        insert_btn.setFont(fonti);
				        view_btn.setFont(fonti);
				        update_btn.setFont(fonti);
				        delete_btn.setFont(fonti);
				    }

				    private void addComponentsToFrame() {
				        frame.add(id_lb);
				        frame.add(phone__lb);
				        frame.add(email__lb);
				        frame.add(name_lb);
				        frame.add(dis__lb);
				        frame.add(user__lb);
				        frame.add(pass__lb);
				        frame.add(add_lb);
				        frame.add(res__lb);
				        frame.add(dis__lb);
				        frame.add(ref__lb);
				        frame.add(app__lb);
				        frame.add(st_lb);

				        frame.add(id_txf);
				        frame.add(phone__txf);
				        frame.add(email__txf);
				        frame.add(name_txf);
				        frame.add(user_txf);
				        frame.add(pass_txf);
				        frame.add(add_txf);
				        frame.add(res_txf);
				        frame.add(dis_txf);
				        frame.add(ref_txf);
				        frame.add(app_txf);
				        frame.add(st_txf);

				        frame.add(insert_btn);
				        frame.add(view_btn);
				        frame.add(update_btn);
				        frame.add(delete_btn);

				        addActionListeners();
				    }

				    @Override
				    public void actionPerformed(ActionEvent e) {
				        Jobseeker job=new Jobseeker();
				        if (e.getSource() == insert_btn) {
				        	 job.setJobseeker_name(name_txf.getText());
				            job.setJobseeker_phone(phone__txf.getText());
				            job.setJobseeker_email_address(email__txf.getText());
				           job.setJobseeker_username(user_txf.getText());
				            job.setJobseeker_password(pass_txf.getText());
				            job.setJobseeker_address(add_txf.getText());
				            job.setJobseeker_resume(res_txf.getText());
				            job.setJobseeker_disability(dis_txf.getText());
				            job.setJobseeker_reference(ref_txf.getText());
				            job.setApplication_date(app_txf.getText());
				            job.setStatus(st_txf.getText());
				            job.insertjob();
				        } else if (e.getSource() == view_btn) {
				            int id = Integer.parseInt(id_txf.getText());
				            job.readWithjobseekerID(id);
				            name_txf.setText(job.getJobseeker_name());
				            phone__txf.setText(job.getJobseeker_phone());
				            email__txf.setText(job.getJobseeker_email_address());
				            id_txf.setText(String.valueOf(job.getJobseeker_ID()));
				            pass_txf.setText(job.getJobseeker_password());
				            add_txf.setText(job.getJobseeker_address());
				            pass_txf.setText(job.getJobseeker_password());
					           res_txf.setText(job.getJobseeker_resume());
					           dis_txf.setText(job.getJobseeker_disability());
					            ref_txf.setText(job.getJobseeker_reference());
					            app_txf.setText(job.getApplication_date());
					            st_txf.setText(job.getStatus());
					             
				        } else if (e.getSource() == update_btn) {
				            int id = Integer.parseInt(id_txf.getText());
				            job.setJobseeker_name(name_txf.getText());
				            job.setJobseeker_phone(phone__txf.getText());
				            job.setJobseeker_email_address(email__txf.getText());
				           job.setJobseeker_username(user_txf.getText());
				            job.setJobseeker_password(pass_txf.getText());
				            job.setJobseeker_address(add_txf.getText());
				            job.setJobseeker_resume(res_txf.getText());
				            job.setJobseeker_disability(dis_txf.getText());
				            job.setJobseeker_reference(ref_txf.getText());
				            job.setApplication_date(app_txf.getText());
				            job.setStatus(st_txf.getText());
				            job.update(id);
				        } else {
				            int id = Integer.parseInt(id_txf.getText());
				            job.delete(id);
				        }
				    }

				    public static void main(String[] args) {
				    	JobseekerForm jobseekerForm = new JobseekerForm();
				        System.out.println(jobseekerForm);
				    }
				}




