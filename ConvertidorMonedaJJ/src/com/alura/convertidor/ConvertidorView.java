package com.alura.convertidor;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConvertidorView extends JFrame  {
	
	JPanel panelP, panel1, panel2;
    JLabel labelDe, labelA, labelCant, labelCambio;
    JTextField txtCantidad, txtCambio;
    JComboBox comboMoneda1, comboMoneda2;
    JButton botonConvertir;
    FlowLayout tipoAcomodo1;
    GridLayout tipoAcomodo2;
    int opcionMonedaDe = 0;
    int opcionMonedaA = 0;
    
    ConvertidorController control;
    
    public ConvertidorView() {
        crearFormulario();
    }
    
    private void crearFormulario() {
        this.setTitle("Convertidor de Moneda");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600,200);        
        this.setLocationRelativeTo(null);
        
        iniciarObjetos();
        agregarAlFormulario();
        
        this.setLayout(tipoAcomodo1);
        //this.setLayout(tipoAcomodo2);
        this.setVisible(true);
        
        ejecutarCambioMoneda();
                
    }
    
    private void iniciarObjetos() {
        labelDe = new JLabel("De:");
        labelA = new JLabel("A:");
        labelCant = new JLabel("Cantidad:");
        labelCambio = new JLabel("Cambio:");
        txtCantidad = new JTextField(5);
        txtCambio = new JTextField(7);
        comboMoneda1 = new JComboBox(Moneda.values());
        comboMoneda2 = new JComboBox(Moneda.values());
        botonConvertir = new JButton("Convertir");
        botonConvertir.setActionCommand(null);
        panelP = new JPanel();         
        panel1 = new JPanel();
//        panel1.setLocation(0, 0);
//        panel1.setSize(600,100);
        panel2 = new JPanel();
//        panel2.setLocation(0, 100);
//        panel2.setSize(600, 100);
        tipoAcomodo1 = new FlowLayout();
        tipoAcomodo2 = new GridLayout(1, 3);
        control = new ConvertidorController(this);
    }
    
    private void agregarAlFormulario(){
        panelP.add(labelDe);
        panelP.add(comboMoneda1);
        panelP.add(labelA);
        panelP.add(comboMoneda2);
        
        panel1.add(labelCant);
        panel1.add(txtCantidad);
        panel1.add(labelCambio);
        panel1.add(txtCambio);
        
        panel2.add(botonConvertir);
        
        this.add(panelP);
        this.add(panel1);
        this.add(panel2);
    }
    
    public double getCantidad() {
        return Double.parseDouble(txtCantidad.getText());
    }
    
    public void setCambio(double cambio) {
        txtCambio.setText("" + String.format("%.2f", cambio));
        //return String.format("%.2f", cambio);
    }
    
    public String getMonedaDe() {
        String moneda;
        if (comboMoneda1.getSelectedIndex() == 0){
            moneda = "USD";
        } else if (comboMoneda1.getSelectedIndex() == 1) {
            moneda = "MXN";
        } else {
            moneda = "EUR";
        }
        return moneda;
        //return (String)comboMoneda1.getSelectedItem();
    }
    
    public String getMonedaA() {
        String moneda;
        if (comboMoneda2.getSelectedIndex() == 0){
            moneda = "USD";
        } else if (comboMoneda2.getSelectedIndex() == 1) {
            moneda = "MXN";
        } else {
            moneda = "EUR";
        }
        return moneda;
    }
    
    private void ejecutarCambioMoneda() {
        botonConvertir.addActionListener(control);
    }
	
	
	
}
