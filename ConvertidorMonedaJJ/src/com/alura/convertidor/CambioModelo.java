package com.alura.convertidor;

public class CambioModelo {
	
	private double cantidad;
    private double cambio;
    
    public CambioModelo() {
    }        

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getCambio() {
        return cambio;
    }

    public void setCambio(double cambio) {
        this.cambio = cambio;
    }
    
    public double cambiarMoneda(String deMoneda, String aMoneda)  {        
        
        switch (deMoneda) {
            case "USD":
                if (aMoneda.equals("MXN")) {
                    this.cambio = this.cantidad * 17.70;
                } else if (aMoneda.equals("EUR")) {
                    this.cambio = this.cantidad * 0.91;
                } else if (aMoneda.equals("YENES")) {
                    this.cambio = this.cantidad * 6.92;
                } else {
                    this.cambio = this.cantidad;
                }
                break;
            case "MXN":
                if (aMoneda.equals("USD")) {
                    this.cambio = this.cantidad * 0.056;
                } else if (aMoneda.equals("EUR")) {
                    this.cambio = this.cantidad * 0.051;
                } else {
                    this.cambio = this.cantidad;
                }
                break;
            case "EUR":
                if (aMoneda.equals("MXN")) {
                    this.cambio = this.cantidad * 19.47;
                } else if (aMoneda.equals("USD")) {
                    this.cambio = this.cantidad * 1.10;
                } else {
                    this.cambio = this.cantidad;
                }
                break;            
        }

        return this.cambio;
    }

}
