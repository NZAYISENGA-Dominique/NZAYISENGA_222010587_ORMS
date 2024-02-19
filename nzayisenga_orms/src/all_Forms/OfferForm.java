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
public class OfferForm   implements ActionListener {
			    JFrame frame;
			    JLabel id_lb = new JLabel("Offer_id");
			    JLabel jo_lb = new JLabel("Job_id");
			    JLabel seek_lb = new JLabel("Jobseeker_id");
			    JLabel sal_lb = new JLabel("Salary");
			    JLabel ben_lb = new JLabel("Benefit");
			    JLabel start_lb = new JLabel("Start_date");
			    JLabel end_lb = new JLabel("End_date");
			    JLabel off_lb = new JLabel("Offer_Status");
			    JLabel reason_lb = new JLabel("Reason_for_statu");
			   
		//text
			    JTextField id_txf = new JTextField();
			    JTextField jo_txf = new JTextField();
			    JTextField seeker_txf = new JTextField();
			    JTextField sal_txf = new JTextField();
			    JTextField ben_txf = new JTextField();
			    JTextField start_txf = new JTextField();
			    JTextField end_txf = new JTextField();
			    JTextField off_txf = new JTextField();
			    JTextField reason_txf = new JTextField();

			    JButton insert_btn = new JButton("Insert");
			    JButton view_btn = new JButton("View");
			    JButton update_btn = new JButton("Update");
			    JButton delete_btn = new JButton("Delete");

			    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			    int w = (int) screenSize.getWidth();
			    int h = (int) screenSize.getHeight();

			    public OfferForm() {
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
			        frame.setTitle("OFFER FORM");
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
			        sal_lb.setBounds(10, 130, 100, 30);
			        ben_lb.setBounds(10, 170, 100, 30);
			        start_lb.setBounds(10, 210, 100, 30);
			        end_lb.setBounds(10, 250, 100, 30);
			        off_lb.setBounds(10, 290, 100, 30);
			        reason_lb.setBounds(10, 330, 100, 30);
			       

			        id_txf.setBounds(160, 10, 130, 30);
			        jo_txf.setBounds(160, 50, 130, 30);
			        seeker_txf.setBounds(160, 90, 130, 30);
			        sal_txf.setBounds(160, 130, 130, 30);
			        ben_txf.setBounds(160, 170, 130, 30);
			        start_txf.setBounds(160, 210, 130, 30);
			        end_txf.setBounds(160, 250, 130, 30);
			        off_txf.setBounds(160, 290, 130, 30);
			        reason_txf.setBounds(160, 330, 130, 30);
			        

			        insert_btn.setBounds(10, 370, 85, 30);
			        view_btn.setBounds(100, 370, 85, 30);
			        update_btn.setBounds(190, 370, 85, 30);
			        delete_btn.setBounds(280, 370, 85, 30);

			        setFontForAll();
			        addComponentsToFrame();
			    }

			    private void setFontForAll() {
			        Font font = new Font("Georgia", Font.BOLD, 18);

			        id_lb.setFont(font);
			        jo_lb.setFont(font);
			        seek_lb.setFont(font);
			        sal_lb.setFont(font);
			        ben_lb.setFont(font);
			        start_lb.setFont(font);
			        end_lb.setFont(font);
			        off_lb.setFont(font);
			        reason_lb.setFont(font);
			      

			        id_txf.setFont(font);
			        jo_txf.setFont(font);
			        seeker_txf.setFont(font);
			        sal_txf.setFont(font);
			        ben_txf.setFont(font);
			        start_txf.setFont(font);
			        end_txf.setFont(font);
			        off_txf.setFont(font);
			        reason_txf.setFont(font);
			       

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
			        frame.add(sal_lb);
			        frame.add(ben_lb);
			        frame.add(start_lb);
			        frame.add(end_lb);
			        frame.add(off_lb);
			        frame.add(reason_lb);
			       

			        frame.add(id_txf);
			        frame.add(jo_txf);
			        frame.add(seeker_txf);
			        frame.add(sal_txf);
			        frame.add(ben_txf);
			        frame.add(start_txf);
			        frame.add(end_txf);
			        frame.add(off_txf);
			        frame.add(reason_txf);
			       

			        frame.add(insert_btn);
			        frame.add(view_btn);
			        frame.add(update_btn);
			        frame.add(delete_btn);

			        addActionListeners();
			    }

			    @Override
			    public void actionPerformed(ActionEvent e) {
			        Offer inter=new Offer();
			        if (e.getSource() == insert_btn) {
			        	
			            inter.setJob_id(jo_txf.getText());
			            inter.setJobseeker_id(seeker_txf.getText());
			            inter.setSalary(sal_txf.getText());
			            inter.setBenefit(ben_txf.getText());
			            inter.setStart_date(start_txf.getText());
			            inter.setEnd_date(end_txf.getText());
			            inter.setOffer_Status(off_txf.getText());
			            inter.setReason_for_status(reason_txf.getText());
			            inter.insertdater();
			        } else if (e.getSource() == view_btn) {
			            int id = Integer.parseInt(id_txf.getText());
			            inter.readWithoffer_id(id);
			            id_txf.setText(String.valueOf(inter.getOffer_id()));
			            jo_txf.setText(inter.getJob_id());
			            seeker_txf.setText(inter.getJobseeker_id());
			            sal_txf.setText(inter.getSalary());
			            ben_txf.setText(inter.getBenefit());
			             start_txf.setText(inter.getStart_date());
			             end_txf.setText(inter.getEnd_date());
			             off_txf.setText(inter.getOffer_Status());
				            reason_txf.setText(inter.getReason_for_status());
				            } else if (e.getSource() == update_btn) {
			            int id = Integer.parseInt(id_txf.getText());
			            inter.setJob_id(jo_txf.getText());
			            inter.setJobseeker_id(seeker_txf.getText());
			            inter.setSalary(sal_txf.getText());
			            inter.setBenefit(ben_txf.getText());
			            inter.setStart_date(start_txf.getText());
			            inter.setEnd_date(end_txf.getText());
			            inter.setOffer_Status(off_txf.getText());
			            inter.setReason_for_status(reason_txf.getText());
			            inter.update(id);
			        } else {
			            int id = Integer.parseInt(id_txf.getText());
			            inter.delete(id);
			        }
			    }

			    public static void main(String[] args) {
			    	OfferForm offForms = new OfferForm();
			        System.out.println(offForms);
			    }
			}



