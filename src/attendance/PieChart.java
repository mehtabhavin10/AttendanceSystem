/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

/**
 *
 * @author priyamvora
 */
public class PieChart extends JFrame {
    public PieChart(String applicationTitle, String chartTitle,JPanel jp,float pper,float aper) {
        
        super(applicationTitle);
        System.out.println("In constructor");
        PieDataset dataset = createDataset(pper,aper);
        JFreeChart chart = createChart(dataset, chartTitle);
        ChartPanel chartPanel = new ChartPanel(chart);
        jp.removeAll();
        jp.setLayout(new BorderLayout());
        
        chartPanel.setPreferredSize(new java.awt.Dimension(652, 120));
        
        jp.setVisible(true);
        jp.add(chartPanel,BorderLayout.CENTER);
        
  
    }
    public PieChart(String applicationTitle, String chartTitle,JPanel jp,float pper,float aper,int option){
        super(applicationTitle);
        System.out.println("In constructor");
        PieDataset dataset = createDataset(pper,aper);
        JFreeChart chart = createChart(dataset, chartTitle);
        ChartPanel chartPanel = new ChartPanel(chart);
        jp.setVisible(true);
        jp.removeAll();
        jp.setLayout(new BorderLayout());
        
        chartPanel.setPreferredSize(new java.awt.Dimension(509, 476));
        
        
        jp.add(chartPanel,BorderLayout.CENTER);

    }
   
    
    private  PieDataset createDataset(float pper,float aper) {
        System.out.println("Create dataset");
        DefaultPieDataset result = new DefaultPieDataset();
        result.setValue("Present",pper);
        result.setValue("Absent", aper);
        
        return result;

    }
    private JFreeChart createChart(PieDataset dataset, String title) {
System.out.println("createchart");
        JFreeChart chart = ChartFactory.createPieChart3D(
            title,                  // chart title
            dataset,                // data
            true,                   // include legend
            true,
            false
        );
 PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setSectionPaint("Present", new Color(0, 230, 118));
        plot.setSectionPaint("Absent",new Color(229, 57, 53));
        plot.setForegroundAlpha(0.5f);
        return chart;

    }
    public static void main(String args[]){
       
    }
}


