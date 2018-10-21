/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faculty;

import attendance.PieChart;
import attendance.TakeAttendanceFrame;
import connection.JDBCConnect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
public class FacultyTrackFrame extends javax.swing.JFrame {
    
    private static String username;
    private String dateSelected = null, batchNo, fid;
    private Date date;
    

    /**
     * Creates new form FacultyTrackFrame
     */
    public FacultyTrackFrame() {
        initComponents();
    }

    public FacultyTrackFrame(String name) {
        username = name;
    }

    public void setUsername() {
        
        usernameLabel.setText(username);
    }
    
    public void logout() {
        
        int option = JOptionPane.showConfirmDialog(this,"Are you sure you want to logout?");
        if(option == 0){
            this.dispose();
            LoginFrame.main(null);
        }
    }
    
    
    public void setBatches() {
        
        try {
            //batchComboBox.removeAllItems();
            String query = "Select bid from faculty_batch where fid = (Select fid from faculty where name='"+username+"')";
            ResultSet res = JDBCConnect.getResults(query);
            while(res.next()){
                
                batchComboBox.addItem(res.getString("bid").toLowerCase());
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacultyTrackFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void submit() {
        
        
        try {
            if("".equals(dateSelected)) { 
                JOptionPane.showMessageDialog(this, "Select Values from datepicker!", "Alert",JOptionPane.ERROR_MESSAGE);
                return;
            }
            String query = "Select fid from faculty where name='"+username+"'";
            ResultSet res = JDBCConnect.getResults(query);
            res.next();
            fid = res.getString("fid");
            query = "Select * from attendance where date='"+dateSelected+"' and fid='"+fid+"'";
            res = JDBCConnect.getResults(query);
            if(!res.next()) {
                 JOptionPane.showMessageDialog(this, "Lecture not conducted on "+dateSelected+"!", "Alert",JOptionPane.ERROR_MESSAGE);
                 return;
            }
            
            query = "Select count(*) as lecCount from attendance where fid='"+fid+"' and date='"+dateSelected+"'";
            res = JDBCConnect.getResults(query);
            res.next();
            String present = "PRESENT";
            float totalLec = Float.parseFloat( res.getString("lecCount"));
            query = "Select count(status) as lecPresentCount from attendance where status='"+present+"' and fid='"+fid+"' and date='"+dateSelected+"'";
            res = JDBCConnect.getResults(query);
            res.next();
            float presentLec = Float.parseFloat(res.getString("lecPresentCount"));
            float absentLec = totalLec - presentLec;
            float presentPercent = presentLec*100 / totalLec;
            float absentPercent = 100.00f - presentLec;
            
            theoryGraphPanel.removeAll();
            
            PieChart pc = new PieChart("","Present Absent ratio on  "+dateSelected,theoryGraphPanel,presentPercent,absentPercent);
            
            
            query = "Select count(*) as pracCount from "+batchNo+" where fid='"+fid+"'";
            res = JDBCConnect.getResults(query);
            res.next();
            totalLec = Float.parseFloat(res.getString("pracCount"));
            query = "Select count(status) as pracPresentCount from "+batchNo+" where fid ='"+fid+"'"+" and status='"+present+"'";
            res = JDBCConnect.getResults(query);
            res.next();
            presentLec = Float.parseFloat(res.getString("pracPresentCount"));
            absentLec = totalLec - presentLec;
            presentPercent = presentLec*100 / totalLec;
            absentPercent = 100.00f - presentLec;
            
            practicalGraphPanel.removeAll();
            
             PieChart pc2 = new PieChart("","Average Present Absent ratio of  "+batchNo,practicalGraphPanel,presentPercent,absentPercent,2);
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FacultyTrackFrame.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        menuPanel = new javax.swing.JPanel();
        userIconPanel = new javax.swing.JPanel();
        userIcon = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        logoutIcon = new javax.swing.JLabel();
        logoutButton = new javax.swing.JLabel();
        trackIcon = new javax.swing.JLabel();
        trackButton = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        theoryTablePanel = new javax.swing.JPanel();
        theoryTableScrollPane = new javax.swing.JScrollPane();
        theoryTable = new javax.swing.JTable();
        theoryGraphPanel = new javax.swing.JPanel();
        contentTitlePanel = new javax.swing.JPanel();
        titleTheoryPanel = new javax.swing.JPanel();
        theoryLabel = new javax.swing.JLabel();
        theoryDateChooser = new com.toedter.calendar.JDateChooser();
        titlePracticalPanel = new javax.swing.JPanel();
        batchComboBox = new javax.swing.JComboBox<>();
        practicalLabel = new javax.swing.JLabel();
        submitButton = new javax.swing.JLabel();
        submitIcon = new javax.swing.JLabel();
        contentPracticalPanel = new javax.swing.JPanel();
        practicalTableScrollPane = new javax.swing.JScrollPane();
        practicalTable = new javax.swing.JTable();
        practicalGraphPanel = new javax.swing.JPanel();

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
        trackIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/take_attendance.png"))); // NOI18N
        trackIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trackIconMouseClicked(evt);
            }
        });

        trackButton.setBackground(new java.awt.Color(74, 20, 140));
        trackButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        trackButton.setForeground(new java.awt.Color(255, 255, 255));
        trackButton.setText("TAKE ATTENDANCE");
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
                .addContainerGap(215, Short.MAX_VALUE))
        );

        contentPanel.setBackground(new java.awt.Color(153, 153, 153));

        theoryTableScrollPane.setBackground(new java.awt.Color(78, 52, 46));

        theoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        theoryTableScrollPane.setViewportView(theoryTable);

        javax.swing.GroupLayout theoryTablePanelLayout = new javax.swing.GroupLayout(theoryTablePanel);
        theoryTablePanel.setLayout(theoryTablePanelLayout);
        theoryTablePanelLayout.setHorizontalGroup(
            theoryTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(theoryTableScrollPane)
        );
        theoryTablePanelLayout.setVerticalGroup(
            theoryTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(theoryTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
        );

        theoryGraphPanel.setBackground(new java.awt.Color(78, 52, 46));

        javax.swing.GroupLayout theoryGraphPanelLayout = new javax.swing.GroupLayout(theoryGraphPanel);
        theoryGraphPanel.setLayout(theoryGraphPanelLayout);
        theoryGraphPanelLayout.setHorizontalGroup(
            theoryGraphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        theoryGraphPanelLayout.setVerticalGroup(
            theoryGraphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        contentTitlePanel.setBackground(new java.awt.Color(78, 52, 46));

        titleTheoryPanel.setBackground(new java.awt.Color(78, 52, 46));

        theoryLabel.setBackground(new java.awt.Color(78, 52, 46));
        theoryLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        theoryLabel.setForeground(new java.awt.Color(255, 255, 255));
        theoryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        theoryLabel.setText("THEORY");

        theoryDateChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                theoryDateChooserPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout titleTheoryPanelLayout = new javax.swing.GroupLayout(titleTheoryPanel);
        titleTheoryPanel.setLayout(titleTheoryPanelLayout);
        titleTheoryPanelLayout.setHorizontalGroup(
            titleTheoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titleTheoryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(theoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(theoryDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        titleTheoryPanelLayout.setVerticalGroup(
            titleTheoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleTheoryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(titleTheoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(theoryDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(theoryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        titlePracticalPanel.setBackground(new java.awt.Color(78, 52, 46));

        batchComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        batchComboBox.setForeground(new java.awt.Color(255, 255, 255));
        batchComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "D1", "D2", "D3", "D4" }));
        batchComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batchComboBoxActionPerformed(evt);
            }
        });

        practicalLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        practicalLabel.setForeground(new java.awt.Color(255, 255, 255));
        practicalLabel.setText("PRACTICAL");

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

        javax.swing.GroupLayout titlePracticalPanelLayout = new javax.swing.GroupLayout(titlePracticalPanel);
        titlePracticalPanel.setLayout(titlePracticalPanelLayout);
        titlePracticalPanelLayout.setHorizontalGroup(
            titlePracticalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titlePracticalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(practicalLabel)
                .addGap(29, 29, 29)
                .addComponent(batchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submitButton, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submitIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        titlePracticalPanelLayout.setVerticalGroup(
            titlePracticalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePracticalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(titlePracticalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(titlePracticalPanelLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(batchComboBox))
                    .addGroup(titlePracticalPanelLayout.createSequentialGroup()
                        .addGroup(titlePracticalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(submitButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(submitIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(practicalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout contentTitlePanelLayout = new javax.swing.GroupLayout(contentTitlePanel);
        contentTitlePanel.setLayout(contentTitlePanelLayout);
        contentTitlePanelLayout.setHorizontalGroup(
            contentTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentTitlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleTheoryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(titlePracticalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        contentTitlePanelLayout.setVerticalGroup(
            contentTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(contentTitlePanelLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(contentTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(titleTheoryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titlePracticalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        practicalTableScrollPane.setBackground(new java.awt.Color(78, 52, 46));

        practicalTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        practicalTableScrollPane.setViewportView(practicalTable);

        javax.swing.GroupLayout contentPracticalPanelLayout = new javax.swing.GroupLayout(contentPracticalPanel);
        contentPracticalPanel.setLayout(contentPracticalPanelLayout);
        contentPracticalPanelLayout.setHorizontalGroup(
            contentPracticalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(practicalTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
        );
        contentPracticalPanelLayout.setVerticalGroup(
            contentPracticalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(practicalTableScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        practicalGraphPanel.setBackground(new java.awt.Color(78, 52, 46));

        javax.swing.GroupLayout practicalGraphPanelLayout = new javax.swing.GroupLayout(practicalGraphPanel);
        practicalGraphPanel.setLayout(practicalGraphPanelLayout);
        practicalGraphPanelLayout.setHorizontalGroup(
            practicalGraphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        practicalGraphPanelLayout.setVerticalGroup(
            practicalGraphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contentTitlePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(contentPracticalPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(theoryTablePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(theoryGraphPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(practicalGraphPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contentTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(theoryTablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(theoryGraphPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contentPracticalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(practicalGraphPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
/*
        this.dispose();
        TrackAttendance trAtt = new TrackAttendance(username);
        TrackAttendance.main(null);
*/
        this.dispose();
        TakeAttendanceFrame.main(null);
    }//GEN-LAST:event_trackIconMouseClicked

    private void trackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trackButtonMouseClicked
        // TODO add your handling code here:
/*
        this.dispose();
        TrackAttendance trAtt=new TrackAttendance(username);
        TrackAttendance.main(null);*/

        this.dispose();
        TakeAttendanceFrame.main(null);
    }//GEN-LAST:event_trackButtonMouseClicked

    private void theoryDateChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_theoryDateChooserPropertyChange

        date = theoryDateChooser.getDate();
        if(date != null){
            java.sql.Date dsql=new java.sql.Date(date.getTime());
            SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
            dateSelected = sdf.format(dsql);
        }
    }//GEN-LAST:event_theoryDateChooserPropertyChange

    private void batchComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batchComboBoxActionPerformed
        // TODO add your handling code here:
        
        batchNo = batchComboBox.getSelectedItem().toString();
    }//GEN-LAST:event_batchComboBoxActionPerformed

    private void submitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitButtonMouseClicked
        submit();
    }//GEN-LAST:event_submitButtonMouseClicked

    private void submitIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitIconMouseClicked
        submit();
    }//GEN-LAST:event_submitIconMouseClicked

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
            java.util.logging.Logger.getLogger(FacultyTrackFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacultyTrackFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacultyTrackFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacultyTrackFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new FacultyTrackFrame().setVisible(true);
                
                FacultyTrackFrame trackFrame = new FacultyTrackFrame();
                trackFrame.setVisible(true);
                trackFrame.setResizable(false);
                trackFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            
                JDBCConnect.setConnection();
                trackFrame.setUsername();
                trackFrame.setBatches();
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> batchComboBox;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JPanel contentPracticalPanel;
    private javax.swing.JPanel contentTitlePanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logoutButton;
    private javax.swing.JLabel logoutIcon;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JPanel practicalGraphPanel;
    private javax.swing.JLabel practicalLabel;
    private javax.swing.JTable practicalTable;
    private javax.swing.JScrollPane practicalTableScrollPane;
    private javax.swing.JLabel submitButton;
    private javax.swing.JLabel submitIcon;
    private com.toedter.calendar.JDateChooser theoryDateChooser;
    private javax.swing.JPanel theoryGraphPanel;
    private javax.swing.JLabel theoryLabel;
    private javax.swing.JTable theoryTable;
    private javax.swing.JPanel theoryTablePanel;
    private javax.swing.JScrollPane theoryTableScrollPane;
    private javax.swing.JPanel titlePracticalPanel;
    private javax.swing.JPanel titleTheoryPanel;
    private javax.swing.JLabel trackButton;
    private javax.swing.JLabel trackIcon;
    private javax.swing.JLabel userIcon;
    private javax.swing.JPanel userIconPanel;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
