/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UnicartagenaPoo.ModeloEntidades;

/**
 *
 * @author juana
 */
public class Cliente {
 
    private String nombre; 
    private int edad; 
    private String tipoCuenta; 

    public Cliente(String nombre, int edad, String tipoCuenta) {
        this.nombre = nombre;
        this.edad = edad;
        this.tipoCuenta = tipoCuenta;
    }

    public String getNombre() { 
        return nombre; }
    
    public void setNombre(String nombre) { 
        this.nombre = nombre; }

    public int getEdad() { 
        return edad; }
    
    public void setEdad(int edad) { 
        this.edad = edad; }

    public String getTipoCuenta() { 
        return tipoCuenta; }
    
    public void setTipoCuenta(String tipoCuenta) { 
        this.tipoCuenta = tipoCuenta; }
    
}

