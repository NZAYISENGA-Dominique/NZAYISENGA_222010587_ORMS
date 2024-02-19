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
public class ResumeForm   implements ActionListener {
				    JFrame frame;
				    JLabel id_lb = new JLabel("Resume_id");
				    JLabel seek_lb = new JLabel("Jobseeker_id");
				    JLabel sal_lb = new JLabel("Education");
				    JLabel ben_lb = new JLabel("Skills");
				    JLabel start_lb = new JLabel("Work_experiance");
				    JLabel end_lb = new JLabel("Languages");
				    JLabel off_lb = new JLabel("Jobseeker_address");
				 
				   
			//text
				    JTextField id_txf = new JTextField();
				    JTextField seeker_txf = new JTextField();
				    JTextField sal_txf = new JTextField();
				    JTextField ben_txf = new JTextField();
				    JTextField start_txf = new JTextField();
				    JTextField end_txf = new JTextField();
				    JTextField off_txf = new JTextField();
				  

				    JButton insert_btn = new JButton("Insert");
				    JButton view_btn = new JButton("View");
				    JButton update_btn = new JButton("Update");
				    JButton delete_btn = new JButton("Delete");

				    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				    int w = (int) screenSize.getWidth();
				    int h = (int) screenSize.getHeight();

				    public ResumeForm() {
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
				        frame.setTitle("RESUME FORM");
				        frame.setBounds(10, 10, 600, 500);
				        frame.getContentPane().setLayout(null);
				        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
				        frame.setVisible(true);
				        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				        frame.setResizable(true);
				        setLocationAndSize();
				    }

				    private void setLocationAndSize() {
				        id_lb.setBounds(10, 10, 100, 30);
				        seek_lb.setBounds(10, 50, 100, 30);
				        sal_lb.setBounds(10, 90, 100, 30);
				        ben_lb.setBounds(10, 130, 100, 30);
				        start_lb.setBounds(10, 170, 100, 30);
				        end_lb.setBounds(10, 210, 100, 30);
				        off_lb.setBounds(10, 250, 100, 30);
				       
				       

				        id_txf.setBounds(160, 10, 130, 30);
				        seeker_txf.setBounds(160, 50, 130, 30);
				        sal_txf.setBounds(160, 90, 130, 30);
				        ben_txf.setBounds(160, 130, 130, 30);
				        start_txf.setBounds(160, 170, 130, 30);
				        end_txf.setBounds(160, 210, 130, 30);
				        off_txf.setBounds(160, 250, 130, 30);
				       
				        

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
				        seek_lb.setFont(font);
				        sal_lb.setFont(font);
				        ben_lb.setFont(font);
				        start_lb.setFont(font);
				        end_lb.setFont(font);
				        off_lb.setFont(font);
				     
				      

				        id_txf.setFont(font);
				        seeker_txf.setFont(font);
				        sal_txf.setFont(font);
				        ben_txf.setFont(font);
				        start_txf.setFont(font);
				        end_txf.setFont(font);
				        off_txf.setFont(font);
				       
				       

				        Font fonti = new Font("Courier New", Font.BOLD, 12);

				        insert_btn.setFont(fonti);
				        view_btn.setFont(fonti);
				        update_btn.setFont(fonti);
				        delete_btn.setFont(fonti);
				    }

				    private void addComponentsToFrame() {
				        frame.add(id_lb);
				        frame.add(seek_lb);
				        frame.add(sal_lb);
				        frame.add(ben_lb);
				        frame.add(start_lb);
				        frame.add(end_lb);
				        frame.add(off_lb);
				       

				        frame.add(id_txf);
				        frame.add(seeker_txf);
				        frame.add(sal_txf);
				        frame.add(ben_txf);
				        frame.add(start_txf);
				        frame.add(end_txf);
				        frame.add(off_txf);
				      
				       

				        frame.add(insert_btn);
				        frame.add(view_btn);
				        frame.add(update_btn);
				        frame.add(delete_btn);

				        addActionListeners();
				    }

				    @Override
				    public void actionPerformed(ActionEvent e) {
				        Resume resum=new Resume();
				        if (e.getSource() == insert_btn) {
				        	
				            resum.setJobseeker_id(seeker_txf.getText());
				            resum.setEducation(sal_txf.getText());
				            resum.setSkills(ben_txf.getText());
				            resum.setWork_experiance(start_txf.getText());
				            resum.setLanguages(end_txf.getText());
				            resum.setJobseeker_address(off_txf.getText());
				         
				            resum.insertdater();
				        } else if (e.getSource() == view_btn) {
				            int id = Integer.parseInt(id_txf.getText());
				            resum.readWithResume_id(id);
				            id_txf.setText(String.valueOf(resum.getResume_id()));
				            seeker_txf.setText(resum.getJobseeker_id());
				            sal_txf.setText(resum.getEducation());
				            ben_txf.setText(resum.getSkills());
				             start_txf.setText(resum.getWork_experiance());
				             end_txf.setText(resum.getLanguages());
				             off_txf.setText(resum.getJobseeker_address());
					         
					            } else if (e.getSource() == update_btn) {
				            int id = Integer.parseInt(id_txf.getText());
				            resum.setJobseeker_id(sal_txf.getText());
				            resum.setEducation(sal_txf.getText());
				            resum.setSkills(ben_txf.getText());
				            resum.setWork_experiance(start_txf.getText());
				            resum.setLanguages(end_txf.getText());
				            resum.setJobseeker_address(off_txf.getText());
				          
				            resum.update(id);
				        } else {
				            int id = Integer.parseInt(id_txf.getText());
				            resum.delete(id);
				        }
				    }

				    public static void main(String[] args) {
				    	ResumeForm resForms = new ResumeForm();
				        System.out.println(resForms);
				    }
				}




