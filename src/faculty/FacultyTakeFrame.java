/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faculty;

import attendance.TrackAttendance;
import connection.JDBCConnect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import login.LoginFrame;

/**
 *
 * @author Admin
 */
public class FacultyTakeFrame extends javax.swing.JFrame {

    private static String username;
    private String sessionType, batchNo, dateSelected, table;
    private ArrayList<String> sap = new ArrayList<String>();
    private ArrayList<String> name = new ArrayList<String>();
    private int counter=0, maxCount = 0;
    
    
    /**
     * Creates new form FacultyHomeFrame
     */
    public FacultyTakeFrame() {
        initComponents();
    }
    
    public FacultyTakeFrame(String name) {
        
        username = name;
    } 
    
    public void setUsername() {
        
        System.out.println("name: " + username);
        usernameLabel.setText(username);
    }
    
    public void logout() {
        
        int option = JOptionPane.showConfirmDialog(this,"Are you sure you want to logout?");
        if(option == 0){
            this.dispose();
            LoginFrame.main(null);
        }
    }
    
    
    public void submit() {
        
        
        if((theoryRadioButton.isSelected() && practicalRadioButton.isSelected())
                || (!theoryRadioButton.isSelected() && !practicalRadioButton.isSelected())) {
            
             JOptionPane.showMessageDialog(this, "Only One Session Type Should be selected!", "Alert",JOptionPane.ERROR_MESSAGE);
             return;
        } else if(theoryRadioButton.isSelected()) sessionType = "theory";
        else if(practicalRadioButton.isSelected()) sessionType = "practical";
        
        batchNo = batchTextField.getText();
        System.out.println("batch: " + batchNo);
        if(practicalRadioButton.isSelected()) {
           
            if(!"d1".equals(batchNo) && !"d2".equals(batchNo) && !"d3".equals(batchNo) && !"d4".equals(batchNo)) {
            
                 JOptionPane.showMessageDialog(this, "Invalid batch type! Enter as d1/d2/d3/d4", "Alert",JOptionPane.ERROR_MESSAGE);
                 return;
            }
        }
        
        long currentTime = System.currentTimeMillis();
        Date date = new Date(currentTime);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        dateSelected = sdf.format(date);
        
        
        String query;
        if(sessionType.equals("theory")) {
            
            query = "Select sapid,name from student";
            table="attendance";
        } else {
            query = "Select sapid,name from student where batchid='"+batchNo+"'";
            table = batchNo;
        }
        
        ResultSet res = JDBCConnect.getResults(query);
        
        try {
            while(res.next()) {
                
                sap.add(res.getString("sapid"));
                name.add(res.getString("name"));
            }
            maxCount = sap.size();
            contentStatusPanel.setVisible(true);
            userSapIdLabel.setText(sap.get(0));
            userNameLabel.setText(name.get(0));
            
        } catch (SQLException ex) {
            Logger.getLogger(FacultyTakeFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void markStatus(String status) {
        
        try {
            String query,query2,fid,sid,sname;
            query = "Select fid from faculty where name='"+username+"'";
            ResultSet res = JDBCConnect.getResults(query);
            res.next(); 
            fid = res.getString("fid");
            query = "Select sid from faculty_subject where fid='"+fid+"'";
            res = JDBCConnect.getResults(query);
            res.next();
            sid = res.getString("sid");
            query = "Select name from subject where sid='"+sid+"'";
            res = JDBCConnect.getResults(query);
            res.next();
            sname = res.getString("name");
            
            if(counter < maxCount) {
                
                String sapId = sap.get(counter);
                String present = status;
                if(table.equals("attendance")) {
                    
                    query = "Insert into attendance values('"+dateSelected+"','"+sapId+"','"+fid+"','"+sid+"','"+present+"','"+sname+"')";
                    JDBCConnect.insertOrUpdateData(query);
                    
                } else {
                    query="Insert into d1 values('"+dateSelected+"','"+sapId+"','"+fid+"','"+sid+"','"+present+"')";
                    query2="Insert into prac values('"+dateSelected+"','"+sapId+"','"+sid+"','"+fid+"','"+present+"','"+batchNo+"','"+sname+"')";                    
                    JDBCConnect.insertOrUpdateData(query);
                    JDBCConnect.insertOrUpdateData(query2);
                }
            }
            counter++;
            if(counter != maxCount) {
                
                userSapIdLabel.setText(sap.get(counter));
                userNameLabel.setText(name.get(counter));
            } else {
                
                contentStatusPanel.setVisible(false);
            }
            
                    
                    
        } catch (SQLException ex) {
            Logger.getLogger(FacultyTakeFrame.class.getName()).log(Level.SEVERE, null, ex);
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

        backgroundPanel = new javax.swing.JPanel();
        menuPanel = new javax.swing.JPanel();
        userIconPanel = new javax.swing.JPanel();
        userIcon = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        logoutIcon = new javax.swing.JLabel();
        logoutButton = new javax.swing.JLabel();
        trackIcon = new javax.swing.JLabel();
        trackButton = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        contentSessiontPanel = new javax.swing.JPanel();
        theoryRadioButton = new javax.swing.JRadioButton();
        sessionIcon = new javax.swing.JLabel();
        sessionLabel = new javax.swing.JLabel();
        practicalRadioButton = new javax.swing.JRadioButton();
        contentBatchPanel = new javax.swing.JPanel();
        batchLabel = new javax.swing.JLabel();
        batchIcon = new javax.swing.JLabel();
        batchNoLabel = new javax.swing.JLabel();
        batchTextField = new javax.swing.JTextField();
        contentSubmitPanel = new javax.swing.JPanel();
        submitButton = new javax.swing.JLabel();
        submitIcon = new javax.swing.JLabel();
        contentStatusPanel = new javax.swing.JPanel();
        userInfoPanel = new javax.swing.JPanel();
        sapIdLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        userSapIdLabel = new javax.swing.JLabel();
        userNameLabel = new javax.swing.JLabel();
        statusPanel = new javax.swing.JPanel();
        presentIcon = new javax.swing.JLabel();
        absentIcon = new javax.swing.JLabel();
        presentLabel = new javax.swing.JLabel();
        absentLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuPanel.setBackground(new java.awt.Color(191, 54, 12));

        userIconPanel.setBackground(new java.awt.Color(191, 54, 12));

        userIcon.setBackground(new java.awt.Color(191, 54, 12));
        userIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N

        javax.swing.GroupLayout userIconPanelLayout = new javax.swing.GroupLayout(userIconPanel);
        userIconPanel.setLayout(userIconPanelLayout);
        userIconPanelLayout.setHorizontalGroup(
            userIconPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(userIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        userIconPanelLayout.setVerticalGroup(
            userIconPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userIconPanelLayout.createSequentialGroup()
                .addComponent(userIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
        );

        usernameLabel.setBackground(new java.awt.Color(74, 20, 140));
        usernameLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(255, 255, 255));
        usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernameLabel.setText("Faculty Name");

        logoutIcon.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        logoutIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout2.png"))); // NOI18N
        logoutIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutIconMouseClicked(evt);
            }
        });

        logoutButton.setBackground(new java.awt.Color(74, 20, 140));
        logoutButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        logoutButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutButton.setText("LOGOUT");
        logoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutButtonMouseClicked(evt);
            }
        });

        trackIcon.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        trackIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/track_attendance.png"))); // NOI18N
        trackIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trackIconMouseClicked(evt);
            }
        });

        trackButton.setBackground(new java.awt.Color(74, 20, 140));
        trackButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        trackButton.setForeground(new java.awt.Color(255, 255, 255));
        trackButton.setText("TRACK ATTENDANCE");
        trackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trackButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(usernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userIconPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addComponent(logoutIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addComponent(trackIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trackButton, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userIconPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(trackIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(trackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logoutIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        contentPanel.setBackground(new java.awt.Color(153, 153, 153));

        contentSessiontPanel.setBackground(new java.awt.Color(78, 52, 46));

        theoryRadioButton.setBackground(new java.awt.Color(78, 52, 46));
        theoryRadioButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        theoryRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        theoryRadioButton.setText("THEORY");

        sessionIcon.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        sessionIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lec_type.png"))); // NOI18N

        sessionLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        sessionLabel.setForeground(new java.awt.Color(255, 255, 255));
        sessionLabel.setText("SESSION TYPE ");

        practicalRadioButton.setBackground(new java.awt.Color(78, 52, 46));
        practicalRadioButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        practicalRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        practicalRadioButton.setText("PRACTICAL / TUTORIAL");

        javax.swing.GroupLayout contentSessiontPanelLayout = new javax.swing.GroupLayout(contentSessiontPanel);
        contentSessiontPanel.setLayout(contentSessiontPanelLayout);
        contentSessiontPanelLayout.setHorizontalGroup(
            contentSessiontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentSessiontPanelLayout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(theoryRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(practicalRadioButton)
                .addGap(106, 106, 106))
            .addGroup(contentSessiontPanelLayout.createSequentialGroup()
                .addComponent(sessionIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sessionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentSessiontPanelLayout.setVerticalGroup(
            contentSessiontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentSessiontPanelLayout.createSequentialGroup()
                .addGroup(contentSessiontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sessionIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .addComponent(sessionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentSessiontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(theoryRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                    .addComponent(practicalRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1))
        );

        contentBatchPanel.setBackground(new java.awt.Color(78, 52, 46));

        batchLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        batchLabel.setForeground(new java.awt.Color(255, 255, 255));
        batchLabel.setText("BATCH NUMBER");

        batchIcon.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        batchIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/batch.png"))); // NOI18N

        batchNoLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        batchNoLabel.setForeground(new java.awt.Color(255, 255, 255));
        batchNoLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        batchNoLabel.setText("Enter Batch Number:  (D1 / D2 / D3 / D4)");

        batchTextField.setBackground(new java.awt.Color(78, 52, 46));
        batchTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        batchTextField.setForeground(new java.awt.Color(255, 255, 255));
        batchTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        javax.swing.GroupLayout contentBatchPanelLayout = new javax.swing.GroupLayout(contentBatchPanel);
        contentBatchPanel.setLayout(contentBatchPanelLayout);
        contentBatchPanelLayout.setHorizontalGroup(
            contentBatchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentBatchPanelLayout.createSequentialGroup()
                .addGroup(contentBatchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(batchNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(batchIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentBatchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentBatchPanelLayout.createSequentialGroup()
                        .addComponent(batchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(batchLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        contentBatchPanelLayout.setVerticalGroup(
            contentBatchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentBatchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentBatchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(batchLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(batchIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentBatchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(batchNoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(batchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        contentSubmitPanel.setBackground(new java.awt.Color(78, 52, 46));

        submitButton.setBackground(new java.awt.Color(74, 20, 140));
        submitButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        submitButton.setForeground(new java.awt.Color(255, 255, 255));
        submitButton.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        submitButton.setText("SUBMIT");
        submitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitButtonMouseClicked(evt);
            }
        });

        submitIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/submit.png"))); // NOI18N
        submitIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitIconMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout contentSubmitPanelLayout = new javax.swing.GroupLayout(contentSubmitPanel);
        contentSubmitPanel.setLayout(contentSubmitPanelLayout);
        contentSubmitPanelLayout.setHorizontalGroup(
            contentSubmitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentSubmitPanelLayout.createSequentialGroup()
                .addGap(335, 335, 335)
                .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(submitIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentSubmitPanelLayout.setVerticalGroup(
            contentSubmitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(submitButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(submitIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        contentStatusPanel.setBackground(new java.awt.Color(0, 77, 64));

        userInfoPanel.setBackground(new java.awt.Color(0, 77, 64));

        sapIdLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        sapIdLabel.setForeground(new java.awt.Color(255, 255, 255));
        sapIdLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        sapIdLabel.setText("SAP ID: ");

        nameLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(255, 255, 255));
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        nameLabel.setText("NAME: ");
        nameLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        userSapIdLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        userSapIdLabel.setForeground(new java.awt.Color(255, 255, 255));
        userSapIdLabel.setText("12345678901");

        userNameLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        userNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        userNameLabel.setText("MY NAME");
        userNameLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout userInfoPanelLayout = new javax.swing.GroupLayout(userInfoPanel);
        userInfoPanel.setLayout(userInfoPanelLayout);
        userInfoPanelLayout.setHorizontalGroup(
            userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sapIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userSapIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                    .addComponent(userNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        userInfoPanelLayout.setVerticalGroup(
            userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userInfoPanelLayout.createSequentialGroup()
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sapIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userSapIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                    .addComponent(userNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        statusPanel.setBackground(new java.awt.Color(0, 77, 64));

        presentIcon.setForeground(new java.awt.Color(255, 255, 255));
        presentIcon.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        presentIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/present.png"))); // NOI18N
        presentIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                presentIconMouseClicked(evt);
            }
        });

        absentIcon.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        absentIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/absent.png"))); // NOI18N
        absentIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                absentIconMouseClicked(evt);
            }
        });

        presentLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        presentLabel.setForeground(new java.awt.Color(255, 255, 255));
        presentLabel.setText("PRESENT");
        presentLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                presentLabelMouseClicked(evt);
            }
        });

        absentLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        absentLabel.setForeground(new java.awt.Color(255, 255, 255));
        absentLabel.setText("ABSENT");
        absentLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                absentLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(presentIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(absentIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(presentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(absentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(presentIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                    .addComponent(presentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(absentIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(absentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout contentStatusPanelLayout = new javax.swing.GroupLayout(contentStatusPanel);
        contentStatusPanel.setLayout(contentStatusPanelLayout);
        contentStatusPanelLayout.setHorizontalGroup(
            contentStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentStatusPanelLayout.createSequentialGroup()
                .addComponent(userInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(statusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        contentStatusPanelLayout.setVerticalGroup(
            contentStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(userInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(statusPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contentSessiontPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contentBatchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contentSubmitPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contentStatusPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contentSessiontPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentBatchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentSubmitPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(contentStatusPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void logoutIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutIconMouseClicked
        logout();
    }//GEN-LAST:event_logoutIconMouseClicked

    private void logoutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseClicked
        logout();
    }//GEN-LAST:event_logoutButtonMouseClicked

    private void trackIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trackIconMouseClicked
        // TODO add your handling code here:
        
                this.dispose();
        FacultyTrackFrame trAtt = new FacultyTrackFrame(username);
        FacultyTrackFrame.main(null);
        
        
    }//GEN-LAST:event_trackIconMouseClicked

    private void trackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trackButtonMouseClicked
        // TODO add your handling code here:
        
                this.dispose();
        FacultyTrackFrame trAtt = new FacultyTrackFrame(username);
        FacultyTrackFrame.main(null);
    }//GEN-LAST:event_trackButtonMouseClicked

    private void submitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitButtonMouseClicked
        submit();
    }//GEN-LAST:event_submitButtonMouseClicked

    private void submitIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitIconMouseClicked
        submit();
    }//GEN-LAST:event_submitIconMouseClicked

    private void presentIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_presentIconMouseClicked
        // TODO add your handling code here:
        
        markStatus("PRESENT");
    }//GEN-LAST:event_presentIconMouseClicked

    private void presentLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_presentLabelMouseClicked
        // TODO add your handling code here:
        
        markStatus("PRESENT");
    }//GEN-LAST:event_presentLabelMouseClicked

    private void absentIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_absentIconMouseClicked
        // TODO add your handling code here:
        
        markStatus("ABSENT");
    }//GEN-LAST:event_absentIconMouseClicked

    private void absentLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_absentLabelMouseClicked
        // TODO add your handling code here:
        
        markStatus("ABSENT");
    }//GEN-LAST:event_absentLabelMouseClicked

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
            java.util.logging.Logger.getLogger(FacultyTakeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacultyTakeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacultyTakeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacultyTakeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new FacultyTakeFrame().setVisible(true);
            
                FacultyTakeFrame takeFrame = new FacultyTakeFrame();
                takeFrame.setVisible(true);
                takeFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                takeFrame.setResizable(false);
                        
                JDBCConnect.setConnection();
                
                //--------------------------
                
                takeFrame.contentStatusPanel.setVisible(false);
                
                //--------------------------
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel absentIcon;
    private javax.swing.JLabel absentLabel;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JLabel batchIcon;
    private javax.swing.JLabel batchLabel;
    private javax.swing.JLabel batchNoLabel;
    private javax.swing.JTextField batchTextField;
    private javax.swing.JPanel contentBatchPanel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JPanel contentSessiontPanel;
    private javax.swing.JPanel contentStatusPanel;
    private javax.swing.JPanel contentSubmitPanel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JLabel logoutButton;
    private javax.swing.JLabel logoutIcon;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JRadioButton practicalRadioButton;
    private javax.swing.JLabel presentIcon;
    private javax.swing.JLabel presentLabel;
    private javax.swing.JLabel sapIdLabel;
    private javax.swing.JLabel sessionIcon;
    private javax.swing.JLabel sessionLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JLabel submitButton;
    private javax.swing.JLabel submitIcon;
    private javax.swing.JRadioButton theoryRadioButton;
    private javax.swing.JLabel trackButton;
    private javax.swing.JLabel trackIcon;
    private javax.swing.JLabel userIcon;
    private javax.swing.JPanel userIconPanel;
    private javax.swing.JPanel userInfoPanel;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JLabel userSapIdLabel;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
