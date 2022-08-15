package reto5.view;

import javax.swing.JFrame;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import reto5.controller.ReportesController;
import reto5.model.Dto.ComprasDto;
import reto5.model.Dto.LiderDto;
import reto5.model.Dto.ProyectosDto;

import java.awt.event.*;
import java.awt.*;

public class ReportesView extends JFrame implements ActionListener {
    private static ReportesController controller;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem primerInf, segundoInf, tercerInf;
    private JTable tabla;
    private DefaultTableModel modelo;
    private JLabel lblTitulo, lblConsulta;

    public ReportesView() {
        controller = new ReportesController();
        menu();
        etiqueta1();
        etiqueta2();
        tabla();
    }
    private void tabla() {
        tabla = new JTable(modelo);
        tabla.setPreferredScrollableViewportSize(new Dimension(500,200));
        add(tabla);
        JScrollPane pane = new JScrollPane(tabla);
        add(pane);   
    }
    private void etiqueta2() {
        lblConsulta = new JLabel();
        lblConsulta.setPreferredSize(new Dimension(500, 30)); 
        lblConsulta.setFont(new Font("Arial", Font.BOLD, 14));
        add(lblConsulta);
    }
    private void etiqueta1() {
        lblTitulo = new JLabel("Informe Reto 5");
        lblTitulo.setPreferredSize(new Dimension(500, 30));
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblTitulo);
    }
    private void menu() {
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menu = new JMenu("Informes");
        menuBar.add(menu);
        primerInf = new JMenuItem("Primer informe");
        segundoInf = new JMenuItem("Segundo informe");
        tercerInf = new JMenuItem("Tercer informe");
        menu.add(primerInf);
        menu.add(segundoInf);
        menu.add(tercerInf);
        primerInf.addActionListener(this);
        segundoInf.addActionListener(this);
        tercerInf.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == primerInf){
            primerInforme();
            lblConsulta.setText("Informe de líderes");
        }
        if(e.getSource() == segundoInf){
            segundoInforme();
            lblConsulta.setText("Informe de proyectos");
        }
        if(e.getSource() == tercerInf){
            tercerInforme();
            lblConsulta.setText("Informe de compras");
        }
    }
    private void primerInforme() {
        try{
            List<LiderDto> Lideres = controller.ListarLideres();
            modelo = new DefaultTableModel();
            modelo.addColumn("Id Lider");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Ciudad Residencia");

            for(LiderDto lider: Lideres){
                Object[] fila = new Object[4];
                fila[0] = lider.getID();
                fila[1] = lider.getNombre();
                fila[2] = lider.getPrimerApellido();
                fila[3] = lider.getCiudadResidencia();
                modelo.addRow(fila);
            }
            tabla.setModel(modelo);
            modelo.fireTableDataChanged();
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

    }
    private void segundoInforme() {
        try{
            List<ProyectosDto> Proyectos = controller.ListarProyectos();
            modelo = new DefaultTableModel();
            modelo.addColumn("ID Proyecto");
            modelo.addColumn("Constructora");
            modelo.addColumn("Numero Habitaciones");
            modelo.addColumn("Ciudad");

            for(ProyectosDto proyecto: Proyectos){
                Object[] fila = new Object[4];
                fila[0] = proyecto.getID_Proyecto();
                fila[1] = proyecto.getConstructora();
                fila[2] = proyecto.getNumero_Habitaciones();
                fila[3] = proyecto.getCiudad();
                modelo.addRow(fila);
            }
            tabla.setModel(modelo);
            modelo.fireTableDataChanged();
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    private void tercerInforme() {
        try{
            List<ComprasDto> Compras = controller.ListarCompras();
            modelo = new DefaultTableModel();
            modelo.addColumn("ID Compra");
            modelo.addColumn("Constructora");
            modelo.addColumn("Banco Vinculado");

            for (ComprasDto compra: Compras){
                Object[] fila = new Object[3];
                fila[0] = compra.getID_Compra();
                fila[1] = compra.getConstructora();
                fila[2] = compra.getBanco_Vinculado();
                modelo.addRow(fila);
            }
            tabla.setModel(modelo);
            modelo.fireTableDataChanged();
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }  
    }
}
