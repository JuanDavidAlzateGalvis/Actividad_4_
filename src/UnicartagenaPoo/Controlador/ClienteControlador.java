/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UnicartagenaPoo.Controlador;

import UnicartagenaPoo.ModeloEntidades.Cliente;
import java.util.*;

/**
 *
 * @author juana
 */
public class ClienteControlador {

    private ArrayList<Cliente> clientes;

    public ClienteControlador() {
        clientes = new ArrayList<>();
    }

    public void agregarCliente(String nombre, int edad, String tipoCuenta) {
        Cliente cliente = new Cliente(nombre, edad, tipoCuenta);
        clientes.add(cliente);
    }

    public boolean editarCliente(String nombre, int edad, String tipoCuenta) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombre)) {
                cliente.setEdad(edad);
                cliente.setTipoCuenta(tipoCuenta);
                return true;
            }
        }
        return false; 
    }

    public boolean eliminarCliente(String nombre) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombre)) {
                clientes.remove(cliente);
                return true; 
            }
        }
        return false;
    }

    public ArrayList<Cliente> listarClientes() {
        return clientes;
    }
}
