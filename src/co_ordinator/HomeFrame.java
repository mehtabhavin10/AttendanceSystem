/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co_ordinator;

import login.LoginFrame;
import connection.JDBCConnect;
import javax.swing.JFrame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class HomeFrame extends javax.swing.JFrame {
    
    public static String name, selectedDate = null;
    public static Date date;

    /**
     * Creates new form HomeFrame
     */
    public HomeFrame() {
        initComponents();
    }
    
    
    public HomeFrame(String username) {
        name = username;
    }
    
    public void setUserName() {
        
        usernameLabel.setText(name);
    }
    
    
    public void logout() {
        
        int option = JOptionPane.showConfirmDialog(this,"Are you sure you want to logout?");
        if(option == 0){
            this.dispose();
            LoginFrame.main(null);
        }
    }
    
    
    public void submit() {
        
        String subject = subjectComboBox.getSelectedItem().toString();
        String sapId = sapIdTextField.getText();
        String status = statusComboBox.getSelectedItem().toString();
        
        if(subject.isEmpty() || sapId.isEmpty() || status.isEmpty() || selectedDate.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all values!", "Alert",JOptionPane.ERROR_MESSAGE);
            return;
        } 
        
        String query = "Select sid from subject where name = '"+subject+"'";
        String subjectId = null;
        JDBCConnect.setConnection();
        ResultSet res = JDBCConnect.getResults(query);
        
        try {
            if(res.next()) {
                subjectId = res.getString("sid");
                
                query = "Update attendance set status = '"+status+"' where date = '"+selectedDate+"' and sapid = '"+sapId+"' and sid = '"+subjectId+"'";
                JDBCConnect.insertOrUpdateData(query);
                
                JOptionPane.showMessageDialog(this, "Successfully Updated!", "Info!",JOptionPane.INFORMATION_MESSAGE);
            
                
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Subject!", "Alert",JOptionPane.ERROR_MESSAGE);
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(HomeFrame.class.getName()).log(Level.SEVERE, null, ex);
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
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel2 = new javax.swing.JLabel();
        backgroundPanel = new javax.swing.JPanel();
        menuPanel = new javax.swing.JPanel();
        userIconPanel = new javax.swing.JPanel();
        userIcon = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        logoutIcon = new javax.swing.JLabel();
        logoutButton = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        contentTitlePanel = new javax.swing.JPanel();
        titleIcon = new javax.swing.JLabel();
        titleText = new javax.swing.JLabel();
        subjectPanel = new javax.swing.JPanel();
        subjectLabel = new javax.swing.JLabel();
        subjectComboBox = new javax.swing.JComboBox<>();
        sapIdPanel = new javax.swing.JPanel();
        sapIdLabel = new javax.swing.JLabel();
        sapIdTextField = new javax.swing.JTextField();
        statusPanel = new javax.swing.JPanel();
        statusDateChooser = new com.toedter.calendar.JDateChooser();
        statusComboBox = new javax.swing.JComboBox<>();
        submitIcon = new javax.swing.JLabel();
        submitButton = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backgroundPanel.setBackground(new java.awt.Color(255, 255, 255));

        menuPanel.setBackground(new java.awt.Color(62, 39, 35));

        userIconPanel.setBackground(new java.awt.Color(62, 39, 35));

        userIcon.setBackground(new java.awt.Color(230, 81, 0));
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
                .addComponent(logoutIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        contentPanel.setBackground(new java.awt.Color(121, 85, 72));
        contentPanel.setLayout(new java.awt.GridBagLayout());

        contentTitlePanel.setBackground(new java.awt.Color(121, 85, 72));

        titleIcon.setBackground(new java.awt.Color(13, 71, 161));
        titleIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.png"))); // NOI18N

        titleText.setBackground(new java.awt.Color(13, 71, 161));
        titleText.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titleText.setForeground(new java.awt.Color(255, 255, 255));
        titleText.setText("Update Student Attendance");

        javax.swing.GroupLayout contentTitlePanelLayout = new javax.swing.GroupLayout(contentTitlePanel);
        contentTitlePanel.setLayout(contentTitlePanelLayout);
        contentTitlePanelLayout.setHorizontalGroup(
            contentTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentTitlePanelLayout.createSequentialGroup()
                .addComponent(titleIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleText, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))
        );
        contentTitlePanelLayout.setVerticalGroup(
            contentTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(contentTitlePanelLayout.createSequentialGroup()
                .addComponent(titleIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 19;
        gridBagConstraints.ipady = -18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        contentPanel.add(contentTitlePanel, gridBagConstraints);

        subjectPanel.setBackground(new java.awt.Color(121, 85, 72));

        subjectLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        subjectLabel.setForeground(new java.awt.Color(255, 255, 255));
        subjectLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subjectLabel.setText("SUBJECT:");

        subjectComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        subjectComboBox.setForeground(new java.awt.Color(255, 255, 255));
        subjectComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Applied Maths 3", "Database Management System", "Data Structures", "Java Programming Language", "Logic Design", "Principles Of Communication" }));

        javax.swing.GroupLayout subjectPanelLayout = new javax.swing.GroupLayout(subjectPanel);
        subjectPanel.setLayout(subjectPanelLayout);
        subjectPanelLayout.setHorizontalGroup(
            subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subjectPanelLayout.createSequentialGroup()
                .addComponent(subjectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subjectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        subjectPanelLayout.setVerticalGroup(
            subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subjectPanelLayout.createSequentialGroup()
                .addGroup(subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subjectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subjectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        contentPanel.add(subjectPanel, gridBagConstraints);

        sapIdPanel.setBackground(new java.awt.Color(121, 85, 72));

        sapIdLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sapIdLabel.setForeground(new java.awt.Color(255, 255, 255));
        sapIdLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sapIdLabel.setText("SAP ID:");

        sapIdTextField.setBackground(new java.awt.Color(121, 85, 72));
        sapIdTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sapIdTextField.setForeground(new java.awt.Color(255, 255, 255));
        sapIdTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        javax.swing.GroupLayout sapIdPanelLayout = new javax.swing.GroupLayout(sapIdPanel);
        sapIdPanel.setLayout(sapIdPanelLayout);
        sapIdPanelLayout.setHorizontalGroup(
            sapIdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sapIdPanelLayout.createSequentialGroup()
                .addComponent(sapIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sapIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        sapIdPanelLayout.setVerticalGroup(
            sapIdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sapIdPanelLayout.createSequentialGroup()
                .addComponent(sapIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sapIdPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sapIdTextField)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 21;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        contentPanel.add(sapIdPanel, gridBagConstraints);

        statusPanel.setBackground(new java.awt.Color(121, 85, 72));

        statusDateChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                statusDateChooserPropertyChange(evt);
            }
        });

        statusComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        statusComboBox.setForeground(new java.awt.Color(255, 255, 255));
        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PRESENT", "ABSENT" }));

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statusDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(statusComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 27;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        contentPanel.add(statusPanel, gridBagConstraints);

        submitIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/submit.png"))); // NOI18N
        submitIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitIconMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 51;
        gridBagConstraints.ipady = 34;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 6, 26, 0);
        contentPanel.add(submitIcon, gridBagConstraints);

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
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 36;
        gridBagConstraints.ipady = 43;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 74, 26, 0);
        contentPanel.add(submitButton, gridBagConstraints);

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(31, 31, 31))
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutIconMouseClicked
        logout();
    }//GEN-LAST:event_logoutIconMouseClicked

    private void submitIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitIconMouseClicked
        submit();
    }//GEN-LAST:event_submitIconMouseClicked

    private void logoutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseClicked
        logout();
    }//GEN-LAST:event_logoutButtonMouseClicked

    private void submitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitButtonMouseClicked
        submit();
    }//GEN-LAST:event_submitButtonMouseClicked

    private void statusDateChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_statusDateChooserPropertyChange
        
        
       /* date = ((java.util.Date)statusDateChooser.getDate()).getTime();
        if(date != null) {
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
            selectedDate = sdf.format(date);
        }*/
        
         date = statusDateChooser.getDate();
         if(date !=null){
             java.sql.Date dsql=new java.sql.Date(date.getTime());
             SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
             selectedDate = sdf.format(dsql);
         }
    }//GEN-LAST:event_statusDateChooserPropertyChange

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
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new HomeFrame().setVisible(true);
                HomeFrame homeFrame = new HomeFrame();
                homeFrame.setVisible(true);
                homeFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                homeFrame.setResizable(false);
                homeFrame.setUserName();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JPanel contentTitlePanel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel logoutButton;
    private javax.swing.JLabel logoutIcon;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JLabel sapIdLabel;
    private javax.swing.JPanel sapIdPanel;
    private javax.swing.JTextField sapIdTextField;
    private javax.swing.JComboBox<String> statusComboBox;
    private com.toedter.calendar.JDateChooser statusDateChooser;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JComboBox<String> subjectComboBox;
    private javax.swing.JLabel subjectLabel;
    private javax.swing.JPanel subjectPanel;
    private javax.swing.JLabel submitButton;
    private javax.swing.JLabel submitIcon;
    private javax.swing.JLabel titleIcon;
    private javax.swing.JLabel titleText;
    private javax.swing.JLabel userIcon;
    private javax.swing.JPanel userIconPanel;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
