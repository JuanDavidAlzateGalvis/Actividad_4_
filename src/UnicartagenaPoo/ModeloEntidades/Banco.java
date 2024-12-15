/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UnicartagenaPoo.ModeloEntidades;

/**
 *
 * @author juana
 */
public class Banco {
    
    private String nombre;
    private String pais;
    private int numeroSucursales;
    private int numeroClientes;

    public Banco(String nombre, String pais, int numeroSucursales, int numeroClientes) {
        this.nombre = nombre;
        this.pais = pais;
        this.numeroSucursales = numeroSucursales;
        this.numeroClientes = numeroClientes;
    }

    public String getNombre() { 
        return nombre; }
    
    public void setNombre(String nombre) { 
        this.nombre = nombre; }

    public String getPais() { 
        return pais; }
    
    public void setPais(String pais) { 
        this.pais = pais; }

    public int getNumeroSucursales() { 
        return numeroSucursales; }
    
    public void setNumeroSucursales(int numeroSucursales) { 
        this.numeroSucursales = numeroSucursales; }

    public int getNumeroClientes() { 
        return numeroClientes; }
    
    public void setNumeroClientes(int numeroClientes) { 
        this.numeroClientes = numeroClientes; }
    
}
