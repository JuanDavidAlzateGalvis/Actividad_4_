/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UnicartagenaPoo.Controlador;

import UnicartagenaPoo.ModeloCrud.BancoCrud;
import UnicartagenaPoo.ModeloEntidades.Banco;
import java.util.*;

/**
 *
 * @author juana
 */
public class BancoControlador {
    
    private BancoCrud bancoPersistencia;

    public BancoControlador() {
        this.bancoPersistencia = new BancoCrud(); }

    public void agregarBanco(String nombre, String pais, int numeroSucursales, int numeroClientes) {
        Banco banco = new Banco(nombre, pais, numeroSucursales, numeroClientes);
        bancoPersistencia.agregarBanco(banco);
    }

    public List<Banco> listarBancos() {
        return bancoPersistencia.listarBancos(); }

    public Banco buscarBanco(String nombre) {
        return bancoPersistencia.buscarBanco(nombre); }

    public boolean eliminarBanco(String nombre) {
        return bancoPersistencia.eliminarBanco(nombre); }
    
    public boolean editarBanco(String nombre, String pais, int sucursales, int clientes) {
        Banco banco = buscarBanco(nombre);  
        if (banco != null) {
            banco.setPais(pais);
            banco.setNumeroSucursales(sucursales);
            banco.setNumeroClientes(clientes);
            bancoPersistencia.actualizarBanco(banco);
            return true;
        }
        return false;
    }
}
