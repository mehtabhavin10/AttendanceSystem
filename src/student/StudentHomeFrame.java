/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import attendance.PieChart;
import connection.JDBCConnect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import login.LoginFrame;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Admin
 */
public class StudentHomeFrame extends javax.swing.JFrame {

    private static String sapId, name, subject;
    
    
    /**
     * Creates new form StudentHomeFrame
     */
    public StudentHomeFrame() {
        initComponents();
    }
    
    public StudentHomeFrame(String id, String username) {
        
        sapId = id;
        name = username;
        System.out.println("\nName set to " + name + " = " + username);
    }
    
    public void setUsername() {
        
        System.out.println("name: " + name);
        usernameLabel.setText(name);
    }
    
    public void logout() {
        
        int option = JOptionPane.showConfirmDialog(this,"Are you sure you want to logout?");
        if(option == 0){
            this.dispose();
            LoginFrame.main(null);
        }
    }
    
    public void displayTheoryData() {
        
        String query = "Select date as Date,name as Lecture,status as Status from attendance where sapid='"+sapId+"'order by date desc,name";
        ResultSet theoryData = JDBCConnect.getResults(query);
        theoryTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        theoryTable.setModel(DbUtils.resultSetToTableModel(theoryData));
    }
    
    
    public void displayPracticalData() {
        
        String query = "Select date as Date,name as Lecture,status as Status from prac where sapid='"+sapId+"'order by date desc,name";
        ResultSet practicalData = JDBCConnect.getResults(query);
        practicalTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        practicalTable.setModel(DbUtils.resultSetToTableModel(practicalData));
    }
    
    
    public void displaySubjectData() {
        
        String query = "Select sid from subject where name='"+subject+"'";
        String subjectId = "", status = "Present";
        ResultSet res = JDBCConnect.getResults(query);
        try {
        
        // THEORY ..............................................................
        System.out.println("RES initialized!, subjetc: " + subject);
        if(res.next())    
        subjectId = res.getString("sid");
        else
            JOptionPane.showMessageDialog(this, "No Subject Id!", "Alert",JOptionPane.ERROR_MESSAGE);                
            
        System.out.println("Sub id got!");
        query = "Select count(date) as lecCount from attendance where sid='"+subjectId+"' and sapid='"+sapId+"'";
        res = JDBCConnect.getResults(query);
        res.next();
        int totalLec = Integer.parseInt(res.getString("lecCount"));
        
        query = "Select count(status) as lecPresentCount from attendance where sapid='"+sapId+"' and sid='"+subjectId+"' and status='"+status+"'";        
        res = JDBCConnect.getResults(query);
        res.next();
        int presentLec = Integer.parseInt(res.getString("lecPresentCount"));
        int absentLec = totalLec - presentLec;
        
        if(totalLec == 0) {
            JOptionPane.showMessageDialog(this, "No data avilable for the Requested Subject!", "Alert",JOptionPane.ERROR_MESSAGE);                
            return;
        }
        
        double avgPresentLec = presentLec*100/totalLec;
        double avgAbsentLec = 100.00 - avgPresentLec;
        
        theoryPanel.removeAll();
        PieChart theoryPieChart = new PieChart("","Total theory lectures of "+subject+": "+totalLec,theoryPanel,(float)avgPresentLec,(float)avgAbsentLec,3);
                
    
        // PRACTICAL ...........................................................
        
        query = "Select count(date) as pracCount from prac where sid='"+subjectId+"' and sapid='"+sapId+"'";
        res = JDBCConnect.getResults(query);
        res.next();
        totalLec = Integer.parseInt(res.getString("pracCount"));
        query = "Select count(status) as pracPresentCount from prac where sapid='"+sapId+"' and sid='"+subjectId+"' and status='"+status+"'";
        res = JDBCConnect.getResults(query);
        res.next();
        presentLec = Integer.parseInt(res.getString("pracPresentCount"));
        absentLec = totalLec - presentLec;
        
        if(totalLec == 0) {
            JOptionPane.showMessageDialog(this, "No data avilable for the Requested Subject!", "Alert",JOptionPane.ERROR_MESSAGE);                
            return;
        }
        
        avgPresentLec = presentLec*100/totalLec;
        avgAbsentLec = 100.00 - avgPresentLec;
        
        practicalPanel.removeAll();
        PieChart practicalPieChart = new PieChart("","Total practical sessions of "+subject+": "+totalLec,practicalPanel,(float)avgPresentLec,(float)avgAbsentLec,3);
                        
        
        
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error while connecting to Database!", "Alert",JOptionPane.ERROR_MESSAGE);                
            Logger.getLogger(StudentHomeFrame.class.getName()).log(Level.SEVERE, null, ex);
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

        menuPanel = new javax.swing.JPanel();
        userIconPanel = new javax.swing.JPanel();
        userIcon = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        logoutIcon = new javax.swing.JLabel();
        logoutButton = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        contentTablePanel = new javax.swing.JPanel();
        theoryTableScrollPane = new javax.swing.JScrollPane();
        theoryTable = new javax.swing.JTable();
        parcticalTableScrollPane = new javax.swing.JScrollPane();
        practicalTable = new javax.swing.JTable();
        contentGraphPanel = new javax.swing.JPanel();
        theoryPanel = new javax.swing.JPanel();
        practicalPanel = new javax.swing.JPanel();
        findPanelPanel = new javax.swing.JPanel();
        subjectComboBox = new javax.swing.JComboBox<>();
        findIcon = new javax.swing.JLabel();
        findButton = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1105, 579));

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
        usernameLabel.setText("Student Name");

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
                .addComponent(logoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userIconPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logoutIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        contentPanel.setBackground(new java.awt.Color(153, 153, 153));

        contentTablePanel.setBackground(new java.awt.Color(78, 52, 46));

        theoryTableScrollPane.setBackground(new java.awt.Color(78, 52, 46));

        theoryTable.setBackground(new java.awt.Color(78, 52, 46));
        theoryTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        theoryTable.setForeground(new java.awt.Color(255, 255, 255));
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

        parcticalTableScrollPane.setBackground(new java.awt.Color(78, 52, 46));

        practicalTable.setBackground(new java.awt.Color(78, 52, 46));
        practicalTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        practicalTable.setForeground(new java.awt.Color(255, 255, 255));
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
        parcticalTableScrollPane.setViewportView(practicalTable);

        javax.swing.GroupLayout contentTablePanelLayout = new javax.swing.GroupLayout(contentTablePanel);
        contentTablePanel.setLayout(contentTablePanelLayout);
        contentTablePanelLayout.setHorizontalGroup(
            contentTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentTablePanelLayout.createSequentialGroup()
                .addComponent(theoryTableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(parcticalTableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        contentTablePanelLayout.setVerticalGroup(
            contentTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parcticalTableScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(theoryTableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        contentGraphPanel.setBackground(new java.awt.Color(78, 52, 46));

        javax.swing.GroupLayout theoryPanelLayout = new javax.swing.GroupLayout(theoryPanel);
        theoryPanel.setLayout(theoryPanelLayout);
        theoryPanelLayout.setHorizontalGroup(
            theoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        theoryPanelLayout.setVerticalGroup(
            theoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout practicalPanelLayout = new javax.swing.GroupLayout(practicalPanel);
        practicalPanel.setLayout(practicalPanelLayout);
        practicalPanelLayout.setHorizontalGroup(
            practicalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        practicalPanelLayout.setVerticalGroup(
            practicalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout contentGraphPanelLayout = new javax.swing.GroupLayout(contentGraphPanel);
        contentGraphPanel.setLayout(contentGraphPanelLayout);
        contentGraphPanelLayout.setHorizontalGroup(
            contentGraphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentGraphPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(theoryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(practicalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        contentGraphPanelLayout.setVerticalGroup(
            contentGraphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentGraphPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentGraphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(theoryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(practicalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        findPanelPanel.setBackground(new java.awt.Color(78, 52, 46));

        subjectComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        subjectComboBox.setForeground(new java.awt.Color(255, 255, 255));
        subjectComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Applied Maths 3", "Database Management System", "Data Structures", "Java Programming Language", "Logic Design", "Principles Of Communication" }));
        subjectComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                subjectComboBoxItemStateChanged(evt);
            }
        });

        findIcon.setBackground(new java.awt.Color(78, 52, 46));
        findIcon.setForeground(new java.awt.Color(255, 255, 255));
        findIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        findIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                findIconMouseClicked(evt);
            }
        });

        findButton.setBackground(new java.awt.Color(78, 52, 46));
        findButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        findButton.setForeground(new java.awt.Color(255, 255, 255));
        findButton.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        findButton.setText("Find");
        findButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                findButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout findPanelPanelLayout = new javax.swing.GroupLayout(findPanelPanel);
        findPanelPanel.setLayout(findPanelPanelLayout);
        findPanelPanelLayout.setHorizontalGroup(
            findPanelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, findPanelPanelLayout.createSequentialGroup()
                .addContainerGap(514, Short.MAX_VALUE)
                .addComponent(findButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(findIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(findPanelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(findPanelPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(subjectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(317, Short.MAX_VALUE)))
        );
        findPanelPanelLayout.setVerticalGroup(
            findPanelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(findIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
            .addComponent(findButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(findPanelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(findPanelPanelLayout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(subjectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(contentGraphPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(findPanelPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contentTablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contentTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(findPanelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentGraphPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutIconMouseClicked
        logout();
    }//GEN-LAST:event_logoutIconMouseClicked

    private void logoutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseClicked
        logout();
    }//GEN-LAST:event_logoutButtonMouseClicked

    private void subjectComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_subjectComboBoxItemStateChanged
        // TODO add your handling code here:
        
        subject = subjectComboBox.getSelectedItem().toString();
    }//GEN-LAST:event_subjectComboBoxItemStateChanged

    private void findButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_findButtonMouseClicked
        // TODO add your handling code here:
        
        displaySubjectData();
    }//GEN-LAST:event_findButtonMouseClicked

    private void findIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_findIconMouseClicked
        // TODO add your handling code here:
        
        displaySubjectData();
    }//GEN-LAST:event_findIconMouseClicked

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
            java.util.logging.Logger.getLogger(StudentHomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentHomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentHomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentHomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new StudentHomeFrame().setVisible(true);
                
                StudentHomeFrame studentFrame = new StudentHomeFrame();
                studentFrame.setVisible(true);
                studentFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                studentFrame.setResizable(false);
                studentFrame.setUsername();
                
                JDBCConnect.setConnection();
                studentFrame.displayTheoryData();
                studentFrame.displayPracticalData();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentGraphPanel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JPanel contentTablePanel;
    private javax.swing.JLabel findButton;
    private javax.swing.JLabel findIcon;
    private javax.swing.JPanel findPanelPanel;
    private javax.swing.JLabel logoutButton;
    private javax.swing.JLabel logoutIcon;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JScrollPane parcticalTableScrollPane;
    private javax.swing.JPanel practicalPanel;
    private javax.swing.JTable practicalTable;
    private javax.swing.JComboBox<String> subjectComboBox;
    private javax.swing.JPanel theoryPanel;
    private javax.swing.JTable theoryTable;
    private javax.swing.JScrollPane theoryTableScrollPane;
    private javax.swing.JLabel userIcon;
    private javax.swing.JPanel userIconPanel;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
