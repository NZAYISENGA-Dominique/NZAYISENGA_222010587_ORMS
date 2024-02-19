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
public class InterviewForm  implements ActionListener {
		    JFrame frame;
		    JLabel id_lb = new JLabel("Interview_id");
		    JLabel jo_lb = new JLabel("Job_id");
		    JLabel seek_lb = new JLabel("Jobseeker_id");
		    JLabel dat_lb = new JLabel("Date");
		    JLabel ti_lb = new JLabel("Time");
		    JLabel loc_lb = new JLabel("Location");
		    JLabel type_lb = new JLabel("Interview_type");
		    JLabel name_lb = new JLabel("Interview_name");
		    JLabel fee_lb = new JLabel("Interview_feedback");
		    JLabel sta_lb = new JLabel("Interview_status");
	//text
		    JTextField id_txf = new JTextField();
		    JTextField jo_txf = new JTextField();
		    JTextField seeker_txf = new JTextField();
		    JTextField dat_txf = new JTextField();
		    JTextField ti_txf = new JTextField();
		    JTextField loc_txf = new JTextField();
		    JTextField type_txf = new JTextField();
		    JTextField name_txf = new JTextField();
		    JTextField fee_txf = new JTextField();
		    JTextField sta_txf = new JTextField();

		    JButton insert_btn = new JButton("Insert");
		    JButton view_btn = new JButton("View");
		    JButton update_btn = new JButton("Update");
		    JButton delete_btn = new JButton("Delete");

		    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		    int w = (int) screenSize.getWidth();
		    int h = (int) screenSize.getHeight();

		    public InterviewForm() {
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
		        frame.setTitle("INTERVIEW FORM");
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
		        jo_lb.setBounds(10, 50, 100, 30);
		        seek_lb.setBounds(10, 90, 100, 30);
		        dat_lb.setBounds(10, 130, 100, 30);
		        ti_lb.setBounds(10, 170, 100, 30);
		        loc_lb.setBounds(10, 210, 100, 30);
		        type_lb.setBounds(10, 250, 100, 30);
		        name_lb.setBounds(10, 290, 100, 30);
		        fee_lb.setBounds(10, 330, 100, 30);
		        sta_lb.setBounds(10, 370, 100, 30);

		        id_txf.setBounds(160, 10, 130, 30);
		        jo_txf.setBounds(160, 50, 130, 30);
		        seeker_txf.setBounds(160, 90, 130, 30);
		        dat_txf.setBounds(160, 130, 130, 30);
		        ti_txf.setBounds(160, 170, 130, 30);
		        loc_txf.setBounds(160, 210, 130, 30);
		        type_txf.setBounds(160, 250, 130, 30);
		        name_txf.setBounds(160, 290, 130, 30);
		        fee_txf.setBounds(160, 330, 130, 30);
		        sta_txf.setBounds(160, 370, 130, 30);

		        insert_btn.setBounds(10, 410, 85, 30);
		        view_btn.setBounds(100, 410, 85, 30);
		        update_btn.setBounds(190, 410, 85, 30);
		        delete_btn.setBounds(280, 410, 85, 30);

		        setFontForAll();
		        addComponentsToFrame();
		    }

		    private void setFontForAll() {
		        Font font = new Font("Georgia", Font.BOLD, 18);

		        id_lb.setFont(font);
		        jo_lb.setFont(font);
		        seek_lb.setFont(font);
		        dat_lb.setFont(font);
		        ti_lb.setFont(font);
		        loc_lb.setFont(font);
		        type_lb.setFont(font);
		        name_lb.setFont(font);
		        fee_lb.setFont(font);
		        sta_lb.setFont(font);

		        id_txf.setFont(font);
		        jo_txf.setFont(font);
		        seeker_txf.setFont(font);
		        dat_txf.setFont(font);
		        ti_txf.setFont(font);
		        loc_txf.setFont(font);
		        type_txf.setFont(font);
		        name_txf.setFont(font);
		        fee_txf.setFont(font);
		        sta_txf.setFont(font);

		        Font fonti = new Font("Courier New", Font.BOLD, 12);

		        insert_btn.setFont(fonti);
		        view_btn.setFont(fonti);
		        update_btn.setFont(fonti);
		        delete_btn.setFont(fonti);
		    }

		    private void addComponentsToFrame() {
		        frame.add(id_lb);
		        frame.add(jo_lb);
		        frame.add(seek_lb);
		        frame.add(dat_lb);
		        frame.add(ti_lb);
		        frame.add(loc_lb);
		        frame.add(type_lb);
		        frame.add(name_lb);
		        frame.add(fee_lb);
		        frame.add(sta_lb);

		        frame.add(id_txf);
		        frame.add(jo_txf);
		        frame.add(seeker_txf);
		        frame.add(dat_txf);
		        frame.add(ti_txf);
		        frame.add(loc_txf);
		        frame.add(type_txf);
		        frame.add(name_txf);
		        frame.add(fee_txf);
		        frame.add(sta_txf);

		        frame.add(insert_btn);
		        frame.add(view_btn);
		        frame.add(update_btn);
		        frame.add(delete_btn);

		        addActionListeners();
		    }

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        interview inter=new interview();
		        if (e.getSource() == insert_btn) {
		        	
		            inter.setJobid(seeker_txf.getText());
		            inter.setJobseekerid(dat_txf.getText());
		            inter.setdate(dat_txf.getText());
		            inter.setTime(ti_txf.getText());
		            inter.setLocation(loc_txf.getText());
		            inter.setInterviewtype(type_txf.getText());
		            inter.setInterviewername(name_txf.getText());
		            inter.setInterviewstatus(sta_txf.getText());
		            inter.setInterviewfeedback(fee_txf.getText());
		            inter.insertInterview();
		        } else if (e.getSource() == view_btn) {
		            int id = Integer.parseInt(id_txf.getText());
		            inter.readWithId(id);
		            id_txf.setText(String.valueOf(inter.getId()));
		            jo_txf.setText(inter.getJobid());
		            seeker_txf.setText(inter.getJobseekerid());
		            dat_txf.setText(inter.getdate());
		            ti_txf.setText(inter.getTime());
		             loc_txf.setText(inter.getLocation());
		             type_txf.setText(inter.getInterviewtype());
		             name_txf.setText(inter.getInterviewername());
			            fee_txf.setText(inter.getInterviewfeedback());
			            sta_txf.setText(inter.getInterviewstatus());
			             
		        } else if (e.getSource() == update_btn) {
		            int id = Integer.parseInt(id_txf.getText());
		            inter.setJobid(seeker_txf.getText());
		            inter.setJobseekerid(dat_txf.getText());
		            inter.setdate(dat_txf.getText());
		            inter.setTime(ti_txf.getText());
		            inter.setLocation(loc_txf.getText());
		            inter.setInterviewtype(type_txf.getText());
		            inter.setInterviewername(name_txf.getText());
		            inter.setInterviewstatus(sta_txf.getText());
		            inter.setInterviewfeedback(fee_txf.getText());
		            inter.update(id);
		        } else {
		            int id = Integer.parseInt(id_txf.getText());
		            inter.delete(id);
		        }
		    }

		    public static void main(String[] args) {
		    	InterviewForm intForms = new InterviewForm();
		        System.out.println(intForms);
		    }
		}


