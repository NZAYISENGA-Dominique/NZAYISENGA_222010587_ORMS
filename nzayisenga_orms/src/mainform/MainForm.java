package mainform;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import all_Forms.*;

public class MainForm extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    private JMenuBar menuBar;
    private JMenu ApplicationMenu;
    private JMenu JobMenu;
    private JMenu PlacementMenu;
    private JMenu JobseekersMenu;
    private JMenu OfferMenu;
    private JMenu RecruiterMenu;
    private JMenu InterviewMenu;
    private JMenu ResumeMenu;
    private JMenu logoutMenu;

    private JMenuItem ApplicationItem;
    private JMenuItem JobItem;
    private JMenuItem PlacementItem;
    private JMenuItem JobseekersItem;
    private JMenuItem OfferItem;
    private JMenuItem RecruiterItem;
    private JMenuItem ResumeItem;
    private JMenuItem InterviewItem;
    private JMenuItem logoutItem;

    private String loggedInUser;

    public MainForm(String username) {
        this.loggedInUser = username;
        setTitle("Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        menuBar = new JMenuBar();

        // Create menu items
        ApplicationMenu = new JMenu("Application");
        ApplicationItem = new JMenuItem("Application Form");
        ApplicationItem.addActionListener(this);

        JobMenu = new JMenu("JOB");
        JobItem = new JMenuItem("Job Form");
        JobItem.addActionListener(this);

        JobseekersMenu = new JMenu("Jobseeker");
        JobseekersItem = new JMenuItem("Jobseeker Form");
        JobseekersItem.addActionListener(this);

        OfferMenu = new JMenu("Offer");
        OfferItem = new JMenuItem("Offer Form");
        OfferItem.addActionListener(this);

        RecruiterMenu = new JMenu("Recruiter");
        RecruiterItem = new JMenuItem("Recruiter Form");
        RecruiterItem.addActionListener(this);
        
        ResumeMenu = new JMenu("RESUME");
        ResumeItem = new JMenuItem("Resume Form");
        ResumeItem.addActionListener(this);

        PlacementMenu = new JMenu("PLACEMENT");
        PlacementItem = new JMenuItem("Placement Form");
        PlacementItem.addActionListener(this);
        
        InterviewMenu = new JMenu("INTERVIEW");
        InterviewItem = new JMenuItem("Interview Form");
        InterviewItem .addActionListener(this);



        logoutMenu = new JMenu("LOGOUT");
        logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);

        // Add menu items to respective menus
        ApplicationMenu.add(ApplicationItem);
        JobMenu.add(JobItem);
        JobseekersMenu.add(JobseekersItem);
        OfferMenu.add(OfferItem);
        RecruiterMenu.add(RecruiterItem);
        ResumeMenu.add(ResumeItem);
        PlacementMenu.add(PlacementItem);
        //InterviewMenu.add(InterviewItem);
        logoutMenu.add(logoutItem);

        // Add menus to menu bar
        menuBar.add(ApplicationMenu);
        menuBar.add(JobMenu);
        menuBar.add(JobseekersMenu);
        menuBar.add(OfferMenu);
        menuBar.add(RecruiterMenu);
        menuBar.add(PlacementMenu);
        menuBar.add(ResumeMenu);
        menuBar.add(InterviewMenu);
        menuBar.add(logoutMenu);

        // Set menu bar to frame
        setJMenuBar(menuBar);

        // Initialize dashboard panel
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new BorderLayout());

        // Add components to dashboard panel
        JLabel titleLabel = new JLabel("WELCOME "+loggedInUser+"");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        dashboardPanel.add(titleLabel, BorderLayout.CENTER);

        // Add dashboard panel to frame
        add(dashboardPanel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ApplicationItem) {
            new ApplicationForm();
        } else if (e.getSource() == JobItem) {
            new JobForm();
        } else if (e.getSource() == JobseekersItem) {
            new JobseekerForm();
        } else if (e.getSource() == OfferItem) {
            new OfferForm();
        } else if (e.getSource() == RecruiterItem) {
            new RecruiterForm();
        } else if (e.getSource() == ResumeItem) {
            new ResumeForm();
        } else if (e.getSource() == PlacementItem) {
            new PlacementForm();
        } else if (e.getSource() == InterviewItem) {
            new InterviewForm();
       
        } else if (e.getSource() == logoutItem) {
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
    	SwingUtilities.invokeLater(() -> new MainForm("TO THE ONLINE RECRUITMENT MANAGEMENT SYSTEM"));
    	
    
}}
