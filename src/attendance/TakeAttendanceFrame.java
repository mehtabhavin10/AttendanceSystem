/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance;

//import com.mysql.jdbc.log.Log;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author priyamvora
 */
public class TakeAttendanceFrame extends javax.swing.JFrame {
    static String username;
    static Date d;
    static boolean batchSelectedFlag=false,lectureSelectedFlag=false,dateSelectedFlag=false;
    static String lectureSelected,batchSelected,dataSelected,dateSelected,table;
    ArrayList<String> sap;
    ArrayList<String> name;
    static int count1=0,count2=0,displayCount=0;
    
    static ResultSet rs,rs1;
    static Statement st,st1;
    static DbConnect db;
    static Connection conn,conn1;
    /**
     * Creates new form TakeAttendanceFrame
     */
    public TakeAttendanceFrame() {
        initComponents();
    }
    public TakeAttendanceFrame(String name){
        System.out.println("In constructor");
        System.out.println(name);
       username=name; 
    }
    public void setUserName(){
        
        
        usernameLabel.setText("Welcome "+username);
    }
    public void hideComboBox(){
        batchTypeCombo.setVisible(false);
    }
    public void setMinDate(){
        jDateChooser.setMinSelectableDate(new Date());
        jDateChooser.setMaxSelectableDate(new Date());
        
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
        lectureTypeCombo = new javax.swing.JComboBox<>();
        batchTypeCombo = new javax.swing.JComboBox<>();
        goJButton = new javax.swing.JButton();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        sapLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        stuNameLabel = new javax.swing.JLabel();
        presentButton = new javax.swing.JButton();
        absentButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setFloatable(false);
        jToolBar1.setForeground(new java.awt.Color(255, 255, 255));
        jToolBar1.setRollover(true);
        jToolBar1.setToolTipText("");

        takeAttendanceButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        takeAttendanceButton.setText("   Take Attendance   ");
        takeAttendanceButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(60, 60, 60, 60));
        takeAttendanceButton.setFocusable(false);
        takeAttendanceButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        takeAttendanceButton.setPreferredSize(new java.awt.Dimension(300, 50));
        takeAttendanceButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(takeAttendanceButton);

        trackAttendanceButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        trackAttendanceButton.setText("Track Attendance");
        trackAttendanceButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(60, 60, 60, 60));
        trackAttendanceButton.setFocusable(false);
        trackAttendanceButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        trackAttendanceButton.setPreferredSize(new java.awt.Dimension(300, 50));
        trackAttendanceButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        trackAttendanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trackAttendanceButtonActionPerformed(evt);
            }
        });
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

        lectureTypeCombo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lectureTypeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theory/Practical(Tutorial)", "Theory", "Practical" }));
        lectureTypeCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                lectureTypeComboItemStateChanged(evt);
            }
        });

        batchTypeCombo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        batchTypeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Batch", "D1", "D2", "D3", "D4" }));
        batchTypeCombo.setMinimumSize(new java.awt.Dimension(78, 26));
        batchTypeCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                batchTypeComboItemStateChanged(evt);
            }
        });

        goJButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        goJButton.setText("Go");
        goJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goJButtonActionPerformed(evt);
            }
        });

        jDateChooser.setDateFormatString("dd-MM-yyyy");
        jDateChooser.setMaxSelectableDate(null);
        jDateChooser.setMinSelectableDate(new java.util.Date(-62135785686000L));
        jDateChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooserPropertyChange(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Take Attendance");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Sap Id:");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        sapLabel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        sapLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        sapLabel.setText("60003188012");
        sapLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Name:");
        jLabel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        stuNameLabel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        stuNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        stuNameLabel.setText("Priyam Vora");
        stuNameLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        presentButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        presentButton.setText("Present");
        presentButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        presentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                presentButtonActionPerformed(evt);
            }
        });

        absentButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        absentButton.setText("Absent");
        absentButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        absentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                absentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(presentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(absentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sapLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(stuNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sapLabel)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stuNameLabel)
                    .addComponent(jLabel3))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(presentButton)
                    .addComponent(absentButton))
                .addGap(64, 64, 64))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lectureTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(batchTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(goJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addGroup(layout.createSequentialGroup()
                .addGap(540, 540, 540)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lectureTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(batchTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(goJButton)
                        .addGap(2, 2, 2)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void trackAttendanceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trackAttendanceButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        TrackAttendance trAtt=new TrackAttendance(username);
        TrackAttendance.main(null);
        
    }//GEN-LAST:event_trackAttendanceButtonActionPerformed

    private void lectureTypeComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_lectureTypeComboItemStateChanged
        // TODO add your handling code here:
        System.out.println("Item changed");
        if(evt.getStateChange()==ItemEvent.SELECTED){
            String lecType="";
            lecType=(String)lectureTypeCombo.getSelectedItem();
            System.out.println(lecType);
            if(!lecType.equals("Theory/Practical(Tutorial)")){
                System.out.println("in if");
                lectureSelectedFlag=true;
                lectureSelected=lecType;
            if(lecType.equals("Practical")){
                
                batchTypeCombo.setVisible(true);
                
            }else{
                batchTypeCombo.setVisible(false);
                
            }
        }else{
                lectureSelectedFlag=false;
                System.out.println(lectureSelectedFlag);
            }
        }
    }//GEN-LAST:event_lectureTypeComboItemStateChanged

    private void goJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goJButtonActionPerformed
        // TODO add your handling code here:
        sap=new ArrayList<String>();
        name=new ArrayList<String>();
        count1=count2=displayCount=0;
       if(!(lectureSelectedFlag)){
           JOptionPane.showMessageDialog(this, "Select Values from lecture combobox!", "Alert",JOptionPane.ERROR_MESSAGE);
           return;
       }if(lectureSelected.equals("Practical")||lectureSelected.equals("Theory")){
           if(lectureSelected.equals("Practical")){
                if(!batchSelectedFlag){
                    JOptionPane.showMessageDialog(this, "Select value from practical batch combo box", "Alert",JOptionPane.ERROR_MESSAGE);
                    return;
                }
           }if(lectureSelected.equals("Theory")||lectureSelected.equals("Practical")) {
           
           jPanel1.setVisible(true);
           conn=null;
           st=null;
           db=new DbConnect();
           conn=db.getConn();
           
           table="";
           String sql="";
           if(lectureSelected.equals("Theory")){
               
               sql="Select sapid,name from student";
               table="attendance";
           }else{
               String batch=batchSelected.toLowerCase();
               
              sql="Select sapid,name from student where batchid='"+batch+"'";
              table=batch;
           }
           
           try {
               st=conn.createStatement();
               rs = st.executeQuery(sql);
               while(rs.next()){
                   sap.add(count1,rs.getString("sapid"));
                   name.add(count2,rs.getString("name"));
                   count1++;
                   count2++;
               }
           } catch (SQLException ex) {
               System.out.print(ex);
             }
           System.out.println(count1);
           if(username.equals("Neha.Katre")){
               jLabel1.setText("Take Attendance for DBMS");
           }else if(username.equals("Arjun.Jaiswal")){
               jLabel1.setText("Take Attendance for DBMS");
           }else if(username.equals("Neepa.Shah")){
               jLabel1.setText("Take Attendance for DSA");
           }else if(username.equals("Pranit.Bari")){
               jLabel1.setText("Take Attendance for DSA");
           }else if(username.equals("Anusha.Vegesna")){
               jLabel1.setText("Take Attendance for LD");
           }else if(username.equals("Mitchell.DSilva")){
               jLabel1.setText("Take Attendance for LD");
           }else if(username.equals("Manisha.Keshab")){
               jLabel1.setText("Take Attendance for Maths");
           }else if(username.equals("Shefali.Pawar")){
               jLabel1.setText("Take Attendance for PCOM");
           }else{
               jLabel1.setText("Take Attendance for Java");
           }
          sapLabel.setText(sap.get(0));
          stuNameLabel.setText(name.get(0));
          
          
        }
      }
    }//GEN-LAST:event_goJButtonActionPerformed

    private void batchTypeComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_batchTypeComboItemStateChanged
        // TODO add your handling code here:
        System.out.println("Item changed");
        String batchType="";
        batchType=(String)batchTypeCombo.getSelectedItem();
        if(batchType.equals("Select")){
            batchSelectedFlag=false;
        }else{
            batchSelected=batchType;
            batchSelectedFlag=true;
        } 
    }//GEN-LAST:event_batchTypeComboItemStateChanged

    private void jDateChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserPropertyChange
        // TODO add your handling code here:
         d=jDateChooser.getDate();
         if(d!=null){
             java.sql.Date dsql=new java.sql.Date(d.getTime());
             SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
             dateSelected=sdf.format(dsql);
             dateSelectedFlag=true;
             System.out.print(dateSelected);
         }
          
        

    }//GEN-LAST:event_jDateChooserPropertyChange

    private void presentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_presentButtonActionPerformed
        try {
            String attSap,sid="",fid="",present,sname="",sql;
            present="Present";
            ResultSetOperations rso=new ResultSetOperations(username);
            sql="Select fid from faculty where name='"+username+"'";
            fid=rso.getFid(conn,sql);
            sql="Select sid from faculty_subject where fid='"+fid+"'";
            sid=rso.getSubId(conn,sql);
            sql="Select name from subject where sid='"+sid+"'";
            ResultSet rs=rso.getSubName(conn, sql);
            if(rs.next()){
            sname=rs.getString("name");
            }
            if(displayCount<(count1)){
                
                attSap=sap.get(displayCount);
                System.out.println(attSap);
                db=new DbConnect();
                conn1=db.getConn();
                
                if(table.equals("attendance")){
                    sql="Insert into attendance values('"+dateSelected+"','"+attSap+"','"+fid+"','"+sid+"','"+present+"','"+sname+"')";
                    rso.insertInAttendance(conn,sql);
                }
                
                if(table.equals("d1")){
                    sql="Insert into d1 values('"+dateSelected+"','"+attSap+"','"+fid+"','"+sid+"','"+present+"')";
                    rso.insertInD1(conn, sql);
                    sql="Insert into prac values('"+dateSelected+"','"+attSap+"','"+sid+"','"+fid+"','"+present+"','D1','"+sname+"')";
                    rso.insertInPrac(conn, sql);
                }
                if(table.equals("d2")){
                    sql="Insert into d2 values('"+dateSelected+"','"+attSap+"','"+fid+"','"+sid+"','"+present+"')";
                    rso.insertInD2(conn, sql);
                    sql="Insert into prac values('"+dateSelected+"','"+attSap+"','"+sid+"','"+fid+"','"+present+"','D2','"+sname+"')";
                    rso.insertInPrac(conn, sql);
                }if(table.equals("d3")){
                    sql="Insert into d3 values('"+dateSelected+"','"+attSap+"','"+fid+"','"+sid+"','"+present+"')";
                    rso.insertInD3(conn, sql);
                    sql="Insert into prac values('"+dateSelected+"','"+attSap+"','"+sid+"','"+fid+"','"+present+"','D3','"+sname+"')";
                    rso.insertInPrac(conn, sql);
                }if(table.equals("d4")){
                    sql="Insert into d4 values('"+dateSelected+"','"+attSap+"','"+fid+"','"+sid+"','"+present+"')";
                    rso.insertInD4(conn, sql);
                    sql="Insert into prac values('"+dateSelected+"','"+attSap+"','"+sid+"','"+fid+"','"+present+"','D4','"+sname+"')";
                    rso.insertInPrac(conn, sql);
                }
            }
            displayCount++;
            if(displayCount!=count1){
                sapLabel.setText(sap.get(displayCount));
                stuNameLabel.setText(name.get(displayCount));
            }   if(displayCount==count1){
                displayCount=0;
                jPanel1.setVisible(false);
                
            } } catch (SQLException ex) {
            Logger.getLogger(TakeAttendanceFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_presentButtonActionPerformed

    private void absentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_absentButtonActionPerformed
        try {
            String attSap,sid="",fid="",present,sname="";
            present="Absent";
            ResultSetOperations rso=new ResultSetOperations(username);
            String sql="Select fid from faculty where name='"+username+"'";
            fid=rso.getFid(conn,sql);
            sql="Select sid from faculty_subject where fid='"+fid+"'";
            sid=rso.getSubId(conn,sql);
            sql="Select name from subject where sid='"+sid+"'";
            ResultSet rs=rso.getSubName(conn, sql);
            if(rs.next()){
            sname=rs.getString("name");
            }
            if(displayCount<(count1)){
                
                attSap=sap.get(displayCount);
                System.out.println(attSap);
                db=new DbConnect();
                conn1=db.getConn();
                
                if(table.equals("attendance")){
                    sql="Insert into attendance values('"+dateSelected+"','"+attSap+"','"+fid+"','"+sid+"','"+present+"','"+sname+"')";
                    rso.insertInAttendance(conn,sql);
                }
                
                if(table.equals("d1")){
                    sql="Insert into d1 values('"+dateSelected+"','"+attSap+"','"+fid+"','"+sid+"','"+present+"')";
                    rso.insertInD1(conn, sql);
                    sql="Insert into prac values('"+dateSelected+"','"+attSap+"','"+sid+"','"+fid+"','"+present+"','D1','"+sname+"')";
                    rso.insertInPrac(conn, sql);
                }
                if(table.equals("d2")){
                    sql="Insert into d2 values('"+dateSelected+"','"+attSap+"','"+fid+"','"+sid+"','"+present+"')";
                    rso.insertInD2(conn, sql);
                    sql="Insert into prac values('"+dateSelected+"','"+attSap+"','"+sid+"','"+fid+"','"+present+"','D2','"+sname+"')";
                    rso.insertInPrac(conn, sql);
                }if(table.equals("d3")){
                    sql="Insert into d3 values('"+dateSelected+"','"+attSap+"','"+fid+"','"+sid+"','"+present+"')";
                    rso.insertInD3(conn, sql);
                    sql="Insert into prac values('"+dateSelected+"','"+attSap+"','"+sid+"','"+fid+"','"+present+"','D3','"+sname+"')";
                    rso.insertInPrac(conn, sql);
                }if(table.equals("d4")){
                    sql="Insert into d4 values('"+dateSelected+"','"+attSap+"','"+fid+"','"+sid+"','"+present+"')";
                    rso.insertInD4(conn, sql);
                    sql="Insert into prac values('"+dateSelected+"','"+attSap+"','"+sid+"','"+fid+"','"+present+"','D4','"+sname+"')";
                    rso.insertInPrac(conn, sql);
                }
            }
            displayCount++;
            if(displayCount!=count1){
                sapLabel.setText(sap.get(displayCount));
                stuNameLabel.setText(name.get(displayCount));
            }   if(displayCount==count1){
                displayCount=0;
                jPanel1.setVisible(false);
                
            } } catch (SQLException ex) {
            Logger.getLogger(TakeAttendanceFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_absentButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
         int op=JOptionPane.showConfirmDialog(this,"Are you sure you want to logout?");
        if(op==0){
            this.dispose();
            LoginFrame.main(null);
        }
    }//GEN-LAST:event_logoutButtonActionPerformed

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
            java.util.logging.Logger.getLogger(TakeAttendanceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TakeAttendanceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TakeAttendanceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TakeAttendanceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               TakeAttendanceFrame taf=new TakeAttendanceFrame();
               taf.setVisible(true);
               taf.setLocationRelativeTo(null);
               taf.setExtendedState(JFrame.MAXIMIZED_BOTH);
               taf.setResizable(false);
               taf.setUserName();
               taf.hideComboBox();
               taf.setMinDate();
//               taf.setResizable(false);
               jPanel1.setVisible(false);
           //    jDateChooser.setMinSelectableDate(new Date());
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton absentButton;
    private static javax.swing.JComboBox<String> batchTypeCombo;
    private javax.swing.JButton goJButton;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private static javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private static javax.swing.JComboBox<String> lectureTypeCombo;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton presentButton;
    private javax.swing.JLabel sapLabel;
    private javax.swing.JLabel stuNameLabel;
    private javax.swing.JButton takeAttendanceButton;
    private javax.swing.JButton trackAttendanceButton;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
