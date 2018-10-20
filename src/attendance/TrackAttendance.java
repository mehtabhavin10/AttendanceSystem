/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance;

import static attendance.TakeAttendanceFrame.d;
import static attendance.TakeAttendanceFrame.username;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author priyamvora
 */
public class TrackAttendance extends javax.swing.JFrame {
    static String username,fid,dateSelected,sql;
    DbConnect db;
    Connection conn;
    static Date d;
    boolean dateSelectedFlag=false;
    int presentCount=0,absentCount=0,lecCount=0;
    float presentPercent=0.0f,absentPercent=0.0f;
    
    /**
     * Creates new form TrackAttendance
     */
    public TrackAttendance() {
        initComponents();
        
    }
    TrackAttendance(String username){
        this.username=username;
    }
    public void setUsername(){
        usernameLabel.setText("Welcome "+username);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        takeAttendanceButton = new javax.swing.JButton();
        trackAttendanceButton = new javax.swing.JButton();
        usernameLabel = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        theoryButton = new javax.swing.JButton();
        pracicalButton = new javax.swing.JButton();
        moreButton = new javax.swing.JButton();
        tablePanel = new javax.swing.JPanel();
        jsp = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        piechartContainerPanel = new javax.swing.JPanel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        goJButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(894, 638));

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setMaximumSize(new java.awt.Dimension(900, 145));
        jToolBar1.setMinimumSize(new java.awt.Dimension(783, 145));
        jToolBar1.setPreferredSize(new java.awt.Dimension(900, 145));

        takeAttendanceButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        takeAttendanceButton.setText("   Take Attendance   ");
        takeAttendanceButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(60, 60, 60, 60));
        takeAttendanceButton.setFocusable(false);
        takeAttendanceButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        takeAttendanceButton.setPreferredSize(new java.awt.Dimension(300, 50));
        takeAttendanceButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        takeAttendanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                takeAttendanceButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(takeAttendanceButton);

        trackAttendanceButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        trackAttendanceButton.setText("Track Attendance");
        trackAttendanceButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(60, 60, 60, 60));
        trackAttendanceButton.setFocusable(false);
        trackAttendanceButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        trackAttendanceButton.setPreferredSize(new java.awt.Dimension(300, 50));
        trackAttendanceButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(trackAttendanceButton);

        usernameLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        usernameLabel.setText("Hi,Neha.Katre");
        usernameLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 45, 10, 30));
        usernameLabel.setMaximumSize(new java.awt.Dimension(298, 41));
        usernameLabel.setPreferredSize(new java.awt.Dimension(600, 41));
        jToolBar1.add(usernameLabel);

        logoutButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        logoutButton.setText("Logout");
        logoutButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        logoutButton.setFocusable(false);
        logoutButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        logoutButton.setPreferredSize(new java.awt.Dimension(200, 50));
        logoutButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(logoutButton);

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);
        jToolBar2.setMaximumSize(new java.awt.Dimension(900, 145));
        jToolBar2.setMinimumSize(new java.awt.Dimension(738, 145));
        jToolBar2.setPreferredSize(new java.awt.Dimension(900, 145));

        theoryButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        theoryButton.setText("Theory");
        theoryButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(60, 60, 60, 60));
        theoryButton.setFocusable(false);
        theoryButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        theoryButton.setPreferredSize(new java.awt.Dimension(300, 50));
        theoryButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        theoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                theoryButtonActionPerformed(evt);
            }
        });
        jToolBar2.add(theoryButton);

        pracicalButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        pracicalButton.setText("Practical");
        pracicalButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(60, 60, 60, 60));
        pracicalButton.setFocusable(false);
        pracicalButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pracicalButton.setPreferredSize(new java.awt.Dimension(300, 50));
        pracicalButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pracicalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pracicalButtonActionPerformed(evt);
            }
        });
        jToolBar2.add(pracicalButton);

        moreButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        moreButton.setText("Export Theory Attendance");
        moreButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(60, 60, 60, 60));
        moreButton.setFocusable(false);
        moreButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        moreButton.setPreferredSize(new java.awt.Dimension(370, 50));
        moreButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        moreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moreButtonActionPerformed(evt);
            }
        });
        jToolBar2.add(moreButton);

        tablePanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        tablePanel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jTable1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Sap-Id", "Present/Absent"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setRowHeight(65);
        jTable1.setRowMargin(3);
        jTable1.setShowGrid(true);
        jsp.setViewportView(jTable1);

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jsp, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablePanelLayout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jsp, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jDateChooser1.setDateFormatString("dd-MM-yyyy");
        jDateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser1PropertyChange(evt);
            }
        });

        goJButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        goJButton.setText("Go");
        goJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 834, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout piechartContainerPanelLayout = new javax.swing.GroupLayout(piechartContainerPanel);
        piechartContainerPanel.setLayout(piechartContainerPanelLayout);
        piechartContainerPanelLayout.setHorizontalGroup(
            piechartContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(piechartContainerPanelLayout.createSequentialGroup()
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(goJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(piechartContainerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        piechartContainerPanelLayout.setVerticalGroup(
            piechartContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(piechartContainerPanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(piechartContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(goJButton)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(piechartContainerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(piechartContainerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:

        int op=JOptionPane.showConfirmDialog(this,"Are you sure you want to logout?");
        if(op==0){
            this.dispose();
            LoginFrame.main(null);
        }

    }//GEN-LAST:event_logoutButtonActionPerformed
    public void displayTableOnPanel(JFrame jframe){
        DbConnect db=new DbConnect();
        Connection conn=db.getConn();
        sql="Select fid from faculty where name='"+username+"'";
       ResultSetOperations rso=new ResultSetOperations(username);
       fid=rso.getFid(conn, sql);
       sql="Select sapid,date,status from attendance where fid='"+fid+"'order by sapid,date DESC";
       ResultSet attendanceResultSet=rso.populateTable(conn, sql);
       jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
       jTable1.setModel(DbUtils.resultSetToTableModel(attendanceResultSet));
       
       
       
       
        
    }
   
    private void takeAttendanceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_takeAttendanceButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        TakeAttendanceFrame.main(null);
    }//GEN-LAST:event_takeAttendanceButtonActionPerformed

    private void theoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_theoryButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_theoryButtonActionPerformed

    private void goJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goJButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("Go");
        if(!dateSelectedFlag){
             JOptionPane.showMessageDialog(this, "Select Values from datepicker!", "Alert",JOptionPane.ERROR_MESSAGE);
        }else{
            db=new DbConnect();
            conn=db.getConn();
            String present="Present";
            ResultSetOperations rso=new ResultSetOperations(username); 
            sql="Select * from attendance where date='"+dateSelected+"' and fid='"+fid+"'";
            System.out.println(sql);
            if(rso.checkIfTheoryConducted(conn, sql)){
                jPanel1.setVisible(false);
                sql="Select count(*) as lecCount from attendance where fid='"+fid+"' and date='"+dateSelected+"'";
                rso.setLecCount(conn, sql);
                sql="Select count(status) as lecPresentCount from attendance where status='"+present+"' and fid='"+fid+"' and date='"+dateSelected+"'";
                System.out.println(sql);
                presentCount=rso.returnLecPresentCount(conn, sql);
                absentCount=rso.returnLecAbsentCount();
                lecCount=absentCount+presentCount;
                presentPercent=((float)presentCount*100)/lecCount;
                System.out.println("Present %"+presentPercent);
                absentPercent=100.00f-presentPercent;
                jPanel1.setVisible(true);
                jPanel1.removeAll();
               // jPanel1.setLayout(new GridLayout(1,2));
                System.out.println(dateSelected);
                PieChart pc=new PieChart("","Present Absent ratio on  "+dateSelected,jPanel1,presentPercent,absentPercent);
                //PieChart pc1=new PieChart("","Presen Absent ratio on  "+dateSelected,jPanel1,presentPercent,absentPercent,1);
                
            }else{
                JOptionPane.showMessageDialog(this, "Lecture not conducted on "+dateSelected+"!", "Alert",JOptionPane.ERROR_MESSAGE);
            }
        }
    
    }//GEN-LAST:event_goJButtonActionPerformed

    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange
        // TODO add your handling code here:
        jDateChooser1.setMaxSelectableDate(new Date());
        d=jDateChooser1.getDate();
         
         
             if(d!=null){
             java.sql.Date dsql=new java.sql.Date(d.getTime());
             SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
             dateSelected=sdf.format(dsql);
             dateSelectedFlag=true;
             
            
             }
    }//GEN-LAST:event_jDateChooser1PropertyChange

    private void moreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moreButtonActionPerformed
        // TODO add your handling code here:
        new ExportToText(jTable1,1);
        
        
    }//GEN-LAST:event_moreButtonActionPerformed

    private void pracicalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pracicalButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
         new TrackPracAttendance(username);
         System.out.print("return");
        TrackPracAttendance.main(null);
       
    }//GEN-LAST:event_pracicalButtonActionPerformed

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
            java.util.logging.Logger.getLogger(TrackAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrackAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrackAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrackAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 TrackAttendance trAtt=new TrackAttendance();
                 trAtt.setVisible(true);
                 trAtt.setUsername();
                 trAtt.setLocationRelativeTo(null);
                 trAtt.setExtendedState(JFrame.MAXIMIZED_BOTH);
                 trAtt.setResizable(false);
                 trAtt.displayTableOnPanel(trAtt);
                 jPanel1.setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton goJButton;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private static javax.swing.JPanel jPanel1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JScrollPane jsp;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton moreButton;
    private javax.swing.JPanel piechartContainerPanel;
    private javax.swing.JButton pracicalButton;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JButton takeAttendanceButton;
    private javax.swing.JButton theoryButton;
    private javax.swing.JButton trackAttendanceButton;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
