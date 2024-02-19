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
public class JobForm  implements ActionListener {
			    JFrame frame;
			    JLabel id_lb = new JLabel("Job_id");
			    JLabel re_lb = new JLabel("Recruiter_id");
			    JLabel des_lb = new JLabel("Job_description");
			    JLabel name_lb = new JLabel("Job_name");
			    JLabel loca_lb = new JLabel("Job_location");
			    JLabel sal_lb = new JLabel("Job_salary");
			    JLabel pos_lb = new JLabel("Posting_date");
			    JLabel app_lb = new JLabel("Application_deadline");
			    JLabel type_lb = new JLabel("Employment_type");
			    JLabel req_lb = new JLabel("Job_requirements");
			    JLabel dep_lb = new JLabel("Department");
			    JLabel st_lb = new JLabel("Status");
		//text
			    JTextField id_txf = new JTextField();
			    JTextField re_txf = new JTextField();
			    JTextField des_txf = new JTextField();
			    JTextField name_txf = new JTextField();
			    JTextField loca_txf = new JTextField();
			    JTextField sal_txf = new JTextField();
			    JTextField pos_txf = new JTextField();
			    JTextField app_txf = new JTextField();
			    JTextField type_txf = new JTextField();
			    JTextField req_txf = new JTextField();
			    JTextField dep_txf = new JTextField();
			    JTextField st_txf = new JTextField();

			    JButton insert_btn = new JButton("Insert");
			    JButton view_btn = new JButton("View");
			    JButton update_btn = new JButton("Update");
			    JButton delete_btn = new JButton("Delete");

			    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			    int w = (int) screenSize.getWidth();
			    int h = (int) screenSize.getHeight();

			  public JobForm() {
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
			        frame.setTitle("JOB FORM");
			        frame.setBounds(10, 10, 700, 600);
			        frame.getContentPane().setLayout(null);
			        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
			        frame.setVisible(true);
			        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        frame.setResizable(true);
			        setLocationAndSize();
			    }

			    private void setLocationAndSize() {
			        id_lb.setBounds(10, 10, 100, 30);
			        re_lb.setBounds(10, 50, 100, 30);
			        des_lb.setBounds(10, 90, 100, 30);
			        name_lb.setBounds(10, 130, 100, 30);
			        loca_lb.setBounds(10, 170, 100, 30);
			        sal_lb.setBounds(10, 210, 100, 30);
			        pos_lb.setBounds(10, 250, 100, 30);
			        app_lb.setBounds(10, 290, 100, 30);
			        type_lb.setBounds(10, 330, 100, 30);
			        req_lb.setBounds(10, 370, 100, 30);
			        dep_lb.setBounds(10, 410, 100, 30);
			        st_lb.setBounds(10, 450, 100, 30);
			       

			        id_txf.setBounds(160, 10, 130, 30);
			        re_txf.setBounds(160, 50, 130, 30);
			        des_txf.setBounds(160, 90, 130, 30);
			        name_txf.setBounds(160, 130, 130, 30);
			        loca_txf.setBounds(160, 170, 130, 30);
			        sal_txf.setBounds(160, 210, 130, 30);
			        pos_txf.setBounds(160, 250, 130, 30);
			        app_txf.setBounds(160, 290, 130, 30);
			        type_txf.setBounds(160, 330, 130, 30);
			        req_txf.setBounds(160, 370, 130, 30);
			        dep_txf.setBounds(160, 410, 130, 30);
			        st_txf.setBounds(160, 450, 130, 30);

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
			        re_lb.setFont(font);
			        des_lb.setFont(font);
			        name_lb.setFont(font);
			        loca_lb.setFont(font);
			        sal_lb.setFont(font);
			        pos_lb.setFont(font);
			        app_lb.setFont(font);
			        type_lb.setFont(font);
			        req_lb.setFont(font);
			        dep_lb.setFont(font);
			        dep_lb.setFont(font);
			        st_lb.setFont(font);

			        id_txf.setFont(font);
			        re_txf.setFont(font);
			        des_txf.setFont(font);
			        name_txf.setFont(font);
			        loca_txf.setFont(font);
			        sal_txf.setFont(font);
			        pos_txf.setFont(font);
			        type_txf.setFont(font);
			        name_txf.setFont(font);
			        req_txf.setFont(font);
			        type_txf.setFont(font);
			        dep_txf.setFont(font);
			        st_txf.setFont(font);

			        Font fonti = new Font("Courier New", Font.BOLD, 12);

			        insert_btn.setFont(fonti);
			        view_btn.setFont(fonti);
			        update_btn.setFont(fonti);
			        delete_btn.setFont(fonti);
			    }

			    private void addComponentsToFrame() {
			        frame.add(id_lb);
			        frame.add(re_lb);
			        frame.add(des_lb);
			        frame.add(name_lb);
			        frame.add(type_lb);
			        frame.add(loca_lb);
			        frame.add(sal_lb);
			        frame.add(pos_lb);
			        frame.add(app_lb);
			        frame.add(type_lb);
			        frame.add(req_lb);
			        frame.add(dep_lb);
			        frame.add(st_lb);

			        frame.add(id_txf);
			        frame.add(re_txf);
			        frame.add(des_txf);
			        frame.add(name_txf);
			        frame.add(loca_txf);
			        frame.add(sal_txf);
			        frame.add(pos_txf);
			        frame.add(type_txf);
			        frame.add(app_txf);
			        frame.add(req_txf);
			        frame.add(dep_txf);
			        frame.add(st_txf);

			        frame.add(insert_btn);
			        frame.add(view_btn);
			        frame.add(update_btn);
			        frame.add(delete_btn);

			        addActionListeners();
			    }

			    @Override
			    public void actionPerformed(ActionEvent e) {
			        Job job=new Job();
			        if (e.getSource() == insert_btn) {
			        	
			            job.setRecruiter_id(re_txf.getText());
			            job.setJob_name(des_txf.getText());
			            job.setJob_description(name_txf.getText());
			            job.setJob_location(sal_txf.getText());
			            job.setJob_salary(pos_txf.getText());
			            job.setPosting_date(type_txf.getText());
			            job.setApplication_deadline(app_txf.getText());
			            job.setEmployment_type(type_txf.getText());
			            job.setJob_requirements(req_txf.getText());
			            job.setDepartment(dep_txf.getText());
			            job.setStatus(st_txf.getText());
			            job.insertjob();
			        } else if (e.getSource() == view_btn) {
			            int id = Integer.parseInt(id_txf.getText());
			            job.readWithjob_id(id);
			            id_txf.setText(String.valueOf(job.getJob_id()));
			            re_txf.setText(job.getRecruiter_id());
			            des_txf.setText(job.getJob_description());
			            name_txf.setText(job.getJob_name());
			             pos_txf.setText(job.getJob_location());
			             sal_txf.setText(job.getJob_salary());
			             pos_txf.setText(job.getPosting_date());
				            app_txf.setText(job.getApplication_deadline());
				            type_txf.setText(job.getEmployment_type());
				            req_txf.setText(job.getJob_requirements());
				            dep_txf.setText(job.getDepartment());
				            st_txf.setText(job.getStatus());
				             
			        } else if (e.getSource() == update_btn) {
			            int id = Integer.parseInt(id_txf.getText());
			            job.setRecruiter_id(re_txf.getText());
			            job.setJob_description(des_txf.getText());
			            job.setJob_name(name_txf.getText());
			            job.setJob_location(sal_txf.getText());
			            job.setJob_salary(pos_txf.getText());
			            job.setPosting_date(type_txf.getText());
			            job.setApplication_deadline(name_txf.getText());
			            job.setEmployment_type(type_txf.getText());
			            job.setJob_requirements(req_txf.getText());
			            job.setDepartment(dep_txf.getText());
			            job.setStatus(st_txf.getText());
			            job.update(id);
			        } else {
			            int id = Integer.parseInt(id_txf.getText());
			            job.delete(id);
			        }
			    }

			    public static void main(String[] args) {
			    	JobForm jobForms = new JobForm();
			        System.out.println(jobForms);
			    }
			}


