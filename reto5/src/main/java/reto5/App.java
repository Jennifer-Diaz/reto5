package reto5;

import reto5.view.ReportesView;
import java.awt.*;

import javax.swing.JFrame;
public class App 
{
    public static void main( String[] args )
    {
        ReportesView reportesView = new ReportesView();
        reportesView.setLayout(new FlowLayout());
        reportesView.setSize(600, 400);
        reportesView.setVisible(true);
        reportesView.setResizable(false);
        reportesView.setTitle("Informes - Reto 5");
        reportesView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        reportesView.setLocationRelativeTo(null);
    }
}
