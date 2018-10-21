/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import attendance.TakeAttendanceFrame;
import attendance.ViewStudAttendanceFrame;
import co_ordinator.HomeFrame;
import connection.JDBCConnect;
import faculty.FacultyTakeFrame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import student.StudentHomeFrame;

/**
 *
 * @author Admin
 */
public class LoginFrame extends javax.swing.JFrame {
    
    
    private String userType = "", username = "", password = "";
    private static final String QUOTES_QUERY = "Select * from quotes";
    private ArrayList<String> quotes = new ArrayList<String>();
    private int dateCounter = 0;


    /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
        initComponents();
    }

    public void set() {
        
        try {
            
            JDBCConnect.setConnection();
            ResultSet rs = JDBCConnect.getResults(QUOTES_QUERY);
            while(rs.next())
                quotes.add(rs.getString("text"));
            
            long currentTime = System.currentTimeMillis();
            Date date = new Date(currentTime);
            SimpleDateFormat sdf = new SimpleDateFormat("dd");
            int dateCounter = Integer.parseInt(sdf.format(date));
            dateCounter = dateCounter % 13;
              
            quoteTextLabel.setText(quotes.get(dateCounter));              
            //quoteTextLabel.setText("<html>Science of <br> today is <br> future of <br> tommorow!</html");
      
        } catch (SQLException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error while connecting to Database!", "Alert",JOptionPane.ERROR_MESSAGE);
        
        }
    }
    
    
    public void attemptLogin() {
        
 
            username = usernameTextField.getText();
           // password = passwordField.getPassword().toString();

            password = new String(passwordField.getPassword());
                                                System.out.println("\nPass: " + password);            
            if((studentRadioButton.isSelected() && facultyRadioButton.isSelected() && coordinatorRadioButton.isSelected())
                    || (studentRadioButton.isSelected() && facultyRadioButton.isSelected())
                    || (studentRadioButton.isSelected() && coordinatorRadioButton.isSelected())
                    || (facultyRadioButton.isSelected() && coordinatorRadioButton.isSelected())
               ) {
                    JOptionPane.showMessageDialog(this, "Only One Type Of User Should Be Selected!", "Alert",JOptionPane.ERROR_MESSAGE);
                    return;
                    
            } else if(studentRadioButton.isSelected()) userType = "student";
            else if(facultyRadioButton.isSelected()) userType = "faculty";
            else if(coordinatorRadioButton.isSelected()) userType = "coordinator";
            
            System.out.println("\nSelection Done!");
            
            if("".equals(username) || "".equals(password) || "".equals(userType)) {
                JOptionPane.showMessageDialog(this, "Please enter all details!", "Alert",JOptionPane.ERROR_MESSAGE); 
                return;
            }
                        System.out.println("\nUser: " + username);
                                                System.out.println("\nPass: " + password);
                        System.out.println("\nValidation Done!");
            
            String query = null; 
            
            switch(userType) {
                
                case "student" : query = "Select * from student where sapid = '"+username+"' and password = '"+password+"'";
                break;
                
                case "faculty" : query = "Select * from faculty where name = '"+username+"' and password = '"+password+"'";
                break;
                
                case "coordinator" : query = "Select * from coordinator where username = '"+username+"' and password = '"+password+"'";
                break;
            }

                        System.out.println("\nQuery: " + query);

            
        try {
        
            JDBCConnect.setConnection();;
            ResultSet res = JDBCConnect.getResults(query);
            
            if(res.next()) {
                
                switch(userType) {
                    
                    case "student" :    this.dispose();

                                        String stuName = res.getString("name");
                                        //new ViewStudAttendanceFrame(stuName,username);
                                        new StudentHomeFrame(username, stuName);
                                        //ViewStudAttendanceFrame.main(null);
                                        StudentHomeFrame.main(null);
                                        break;
                                        
                    case "faculty" :    this.dispose();
                                        //new TakeAttendanceFrame(username);
                                        //TakeAttendanceFrame.main(null);
                                        new FacultyTakeFrame(username);
                                        FacultyTakeFrame.main(null);
                                        break;
                                        
                    case "coordinator" :       this.dispose();
                                               new HomeFrame(username);
                                               HomeFrame.main(null);
                                               break;
                
                }
                            System.out.println("\nInside res.next()!");

            } else 
                JOptionPane.showMessageDialog(this, "Invalid Credentials! Try Again.", "Alert",JOptionPane.ERROR_MESSAGE); 
                
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error while connecting to Database!", "Alert",JOptionPane.ERROR_MESSAGE); 
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        backgroundPanel = new javax.swing.JPanel();
        quotesContainerPanel = new javax.swing.JPanel();
        quoteTitlePanel = new javax.swing.JPanel();
        quoteTitleLabel = new javax.swing.JLabel();
        quoteIconLabel = new javax.swing.JLabel();
        quotesPanel = new javax.swing.JPanel();
        quoteTextLabel = new javax.swing.JLabel();
        nextQuoteButton = new javax.swing.JLabel();
        loginContainerPanel = new javax.swing.JPanel();
        loginTitlePanel = new javax.swing.JPanel();
        loginIcon = new javax.swing.JLabel();
        loginTitle = new javax.swing.JLabel();
        loginPanel = new javax.swing.JPanel();
        signInTitlePanel = new javax.swing.JPanel();
        signInIcon = new javax.swing.JLabel();
        signInTitle = new javax.swing.JLabel();
        studentRadioButton = new javax.swing.JRadioButton();
        facultyRadioButton = new javax.swing.JRadioButton();
        coordinatorRadioButton = new javax.swing.JRadioButton();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        loginButtonText = new javax.swing.JLabel();
        loginButtonIcon = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backgroundPanel.setBackground(new java.awt.Color(153, 153, 153));

        quotesContainerPanel.setBackground(new java.awt.Color(153, 153, 153));

        quoteTitlePanel.setBackground(new java.awt.Color(0, 77, 64));

        quoteTitleLabel.setBackground(new java.awt.Color(0, 77, 64));
        quoteTitleLabel.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        quoteTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        quoteTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quoteTitleLabel.setText("Today's Quote");

        quoteIconLabel.setForeground(new java.awt.Color(255, 255, 255));
        quoteIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/quotes.png"))); // NOI18N

        javax.swing.GroupLayout quoteTitlePanelLayout = new javax.swing.GroupLayout(quoteTitlePanel);
        quoteTitlePanel.setLayout(quoteTitlePanelLayout);
        quoteTitlePanelLayout.setHorizontalGroup(
            quoteTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quoteTitlePanelLayout.createSequentialGroup()
                .addComponent(quoteTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quoteIconLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
        );
        quoteTitlePanelLayout.setVerticalGroup(
            quoteTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(quoteTitleLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
            .addComponent(quoteIconLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        quotesPanel.setBackground(new java.awt.Color(0, 77, 64));

        quoteTextLabel.setFont(new java.awt.Font("SimHei", 2, 36)); // NOI18N
        quoteTextLabel.setForeground(new java.awt.Color(255, 255, 255));
        quoteTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quoteTextLabel.setToolTipText("");
        quoteTextLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        nextQuoteButton.setBackground(new java.awt.Color(0, 77, 64));
        nextQuoteButton.setForeground(new java.awt.Color(255, 255, 255));
        nextQuoteButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nextQuoteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/next.png"))); // NOI18N
        nextQuoteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextQuoteButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout quotesPanelLayout = new javax.swing.GroupLayout(quotesPanel);
        quotesPanel.setLayout(quotesPanelLayout);
        quotesPanelLayout.setHorizontalGroup(
            quotesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nextQuoteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, quotesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(quoteTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        quotesPanelLayout.setVerticalGroup(
            quotesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quotesPanelLayout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(quoteTextLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextQuoteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout quotesContainerPanelLayout = new javax.swing.GroupLayout(quotesContainerPanel);
        quotesContainerPanel.setLayout(quotesContainerPanelLayout);
        quotesContainerPanelLayout.setHorizontalGroup(
            quotesContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, quotesContainerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(quotesContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(quoteTitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(quotesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        quotesContainerPanelLayout.setVerticalGroup(
            quotesContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quotesContainerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(quoteTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quotesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        loginContainerPanel.setBackground(new java.awt.Color(153, 153, 153));

        loginTitlePanel.setBackground(new java.awt.Color(121, 85, 72));

        loginIcon.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        loginIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/heading.png"))); // NOI18N

        loginTitle.setBackground(new java.awt.Color(121, 85, 72));
        loginTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        loginTitle.setForeground(new java.awt.Color(255, 255, 255));
        loginTitle.setText("ATTEDANCE SYSTEM");

        javax.swing.GroupLayout loginTitlePanelLayout = new javax.swing.GroupLayout(loginTitlePanel);
        loginTitlePanel.setLayout(loginTitlePanelLayout);
        loginTitlePanelLayout.setHorizontalGroup(
            loginTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginTitlePanelLayout.createSequentialGroup()
                .addComponent(loginIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        loginTitlePanelLayout.setVerticalGroup(
            loginTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
            .addComponent(loginTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        loginPanel.setBackground(new java.awt.Color(121, 85, 72));

        signInTitlePanel.setBackground(new java.awt.Color(121, 85, 72));
        signInTitlePanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));

        signInIcon.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        signInIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.png"))); // NOI18N

        signInTitle.setBackground(new java.awt.Color(121, 85, 72));
        signInTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        signInTitle.setForeground(new java.awt.Color(255, 255, 255));
        signInTitle.setText("SIGN IN");

        javax.swing.GroupLayout signInTitlePanelLayout = new javax.swing.GroupLayout(signInTitlePanel);
        signInTitlePanel.setLayout(signInTitlePanelLayout);
        signInTitlePanelLayout.setHorizontalGroup(
            signInTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signInTitlePanelLayout.createSequentialGroup()
                .addComponent(signInIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signInTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        signInTitlePanelLayout.setVerticalGroup(
            signInTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(signInIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
            .addComponent(signInTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        studentRadioButton.setBackground(new java.awt.Color(121, 85, 72));
        studentRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        studentRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        studentRadioButton.setText("STUDENT");

        facultyRadioButton.setBackground(new java.awt.Color(121, 85, 72));
        facultyRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        facultyRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        facultyRadioButton.setText("FACULTY");

        coordinatorRadioButton.setBackground(new java.awt.Color(121, 85, 72));
        coordinatorRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        coordinatorRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        coordinatorRadioButton.setText("Co-Ordinator");

        usernameLabel.setBackground(new java.awt.Color(121, 85, 72));
        usernameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(255, 255, 255));
        usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernameLabel.setText("USERNAME:");

        passwordLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(255, 255, 255));
        passwordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passwordLabel.setText("PASSWORD:");

        passwordField.setBackground(new java.awt.Color(121, 85, 72));
        passwordField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passwordField.setForeground(new java.awt.Color(255, 255, 255));
        passwordField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        loginButtonText.setBackground(new java.awt.Color(121, 85, 72));
        loginButtonText.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        loginButtonText.setForeground(new java.awt.Color(255, 255, 255));
        loginButtonText.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        loginButtonText.setText("LOGIN");
        loginButtonText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginButtonTextMouseClicked(evt);
            }
        });

        loginButtonIcon.setBackground(new java.awt.Color(121, 85, 72));
        loginButtonIcon.setForeground(new java.awt.Color(255, 255, 255));
        loginButtonIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/submit.png"))); // NOI18N
        loginButtonIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginButtonIconMouseClicked(evt);
            }
        });

        usernameTextField.setBackground(new java.awt.Color(121, 85, 72));
        usernameTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        usernameTextField.setForeground(new java.awt.Color(255, 255, 255));
        usernameTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(loginPanelLayout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(loginPanelLayout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(studentRadioButton)))
                        .addGap(57, 57, 57)
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(loginPanelLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(facultyRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(coordinatorRadioButton))))
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(57, 57, 57))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addComponent(loginButtonText, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loginButtonIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(signInTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(223, 223, 223))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(signInTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(facultyRadioButton)
                    .addComponent(coordinatorRadioButton)
                    .addComponent(studentRadioButton))
                .addGap(53, 53, 53)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(loginButtonText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loginButtonIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout loginContainerPanelLayout = new javax.swing.GroupLayout(loginContainerPanel);
        loginContainerPanel.setLayout(loginContainerPanelLayout);
        loginContainerPanelLayout.setHorizontalGroup(
            loginContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginContainerPanelLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(loginContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(loginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loginTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 651, Short.MAX_VALUE))
                .addGap(49, 49, 49))
        );
        loginContainerPanelLayout.setVerticalGroup(
            loginContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginContainerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addComponent(loginContainerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quotesContainerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginContainerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(quotesContainerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonTextMouseClicked
        // TODO add your handling code here:
        
        attemptLogin();
    }//GEN-LAST:event_loginButtonTextMouseClicked

    private void loginButtonIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonIconMouseClicked
        // TODO add your handling code here:
        
        attemptLogin();
    }//GEN-LAST:event_loginButtonIconMouseClicked

    private void nextQuoteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextQuoteButtonMouseClicked
        // TODO add your handling code here:
        if(dateCounter+1 == 12) dateCounter = 1;
        else dateCounter++;
        quoteTextLabel.setText(quotes.get(dateCounter)); 
    }//GEN-LAST:event_nextQuoteButtonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new LoginFrame().setVisible(true);
                LoginFrame loginFrame = new LoginFrame();
                loginFrame.setVisible(true);
                loginFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                loginFrame.setResizable(false);
                
                loginFrame.set();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JRadioButton coordinatorRadioButton;
    private javax.swing.JRadioButton facultyRadioButton;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel loginButtonIcon;
    private javax.swing.JLabel loginButtonText;
    private javax.swing.JPanel loginContainerPanel;
    private javax.swing.JLabel loginIcon;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JLabel loginTitle;
    private javax.swing.JPanel loginTitlePanel;
    private javax.swing.JLabel nextQuoteButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel quoteIconLabel;
    private javax.swing.JLabel quoteTextLabel;
    private javax.swing.JLabel quoteTitleLabel;
    private javax.swing.JPanel quoteTitlePanel;
    private javax.swing.JPanel quotesContainerPanel;
    private javax.swing.JPanel quotesPanel;
    private javax.swing.JLabel signInIcon;
    private javax.swing.JLabel signInTitle;
    private javax.swing.JPanel signInTitlePanel;
    private javax.swing.JRadioButton studentRadioButton;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
