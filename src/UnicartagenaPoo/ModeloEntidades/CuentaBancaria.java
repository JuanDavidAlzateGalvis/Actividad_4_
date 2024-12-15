/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UnicartagenaPoo.ModeloEntidades;

/**
 *
 * @author juana
 */
public class CuentaBancaria {
    
    private String numeroCuenta;
    private String tipoCuenta;
    private double saldoCuenta;

    public CuentaBancaria(String numeroCuenta, String tipoCuenta, double saldoCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldoCuenta = saldoCuenta;
    }

    public String getNumeroCuenta() { 
        return numeroCuenta; }
    
    public void setNumeroCuenta(String numeroCuenta) { 
        this.numeroCuenta = numeroCuenta; }

    public String getTipoCuenta() { 
        return tipoCuenta; }
    
    public void setTipoCuenta(String tipoCuenta) { 
        this.tipoCuenta = tipoCuenta; }

    public double getSaldoCuenta() { 
        return saldoCuenta; }
    
    public void setSaldoCuenta(double saldoCuenta) { 
        this.saldoCuenta = saldoCuenta; }
    
}
