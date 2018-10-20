/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author priyamvora
 */
public class ExportToText extends javax.swing.JFrame {

JTable jt;
    /**
     * Creates new form ExportToText
     */
    public ExportToText() {
        initComponents();
    }
    
    public ExportToText(JTable jt,int option){
        String text="";
         if(option==1){
             text="theory";
         }else{
             text="practical";
         }
        this.jt=jt;
          try {
            Date d=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
            String date=sdf.format(d);
            File file = new File("/Users/priyamvora/desktop/Attendance_"+date+"_"+text+".txt");
            file.createNewFile();
             FileWriter fw = new FileWriter(file.getAbsoluteFile());
               BufferedWriter bw = new BufferedWriter(fw);
                 for(int i = 0; i < jt.getRowCount(); i++){
                   //loop for jtable column
                   for(int j = 0; j < jt.getColumnCount(); j++){
                       bw.write(jt.getModel().getValueAt(i, j)+" ");
                   }
                    
                   bw.write("\n_________________________________________________\n");
               }
                              bw.close();
                
               fw.close();
               JOptionPane.showMessageDialog(null, "Data Exported and saved on desktop");
        } catch (IOException ex) {
            System.out.println(ex);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 962, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 609, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ExportToText.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExportToText.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExportToText.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExportToText.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ExportToText ett=new ExportToText();
                ett.setVisible(true);
                ett.setExtendedState(JFrame.MAXIMIZED_BOTH);
                ett.setResizable(false);
                ett.setLocationRelativeTo(null);
                
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
