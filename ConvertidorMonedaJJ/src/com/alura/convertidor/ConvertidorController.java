package com.alura.convertidor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConvertidorController implements ActionListener  {
	
	ConvertidorView viewControl;
    CambioModelo cambioModelo;
    double cantidad,cambio;
    String deMoneda, aMoneda;
    
    public ConvertidorController(ConvertidorView viewControl){
        this.viewControl = viewControl;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        cantidad = viewControl.getCantidad();        
        cambioModelo = new CambioModelo();
        cambioModelo.setCantidad(cantidad);        
        cambio = cambioModelo.cambiarMoneda(viewControl.getMonedaDe(), viewControl.getMonedaA());
        viewControl.setCambio(cambio);                
        
    }

}
