/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UnicartagenaPoo.ModeloCrud;
import UnicartagenaPoo.ModeloEntidades.Cliente;
import java.util.*;

/**
 *
 * @author juana
 */
public class ClienteCrud {
    
    private List<Cliente> clientes;

    public ClienteCrud() {
        this.clientes = new ArrayList<>(); }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente); }

    public List<Cliente> listarClientes() {
        return clientes; }

    public Cliente buscarCliente(String nombre) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombre)) {
                return cliente;
            }
        }
        return null;
    }

    public boolean eliminarCliente(String nombre) {
        return clientes.removeIf(cliente -> cliente.getNombre().equalsIgnoreCase(nombre)); }
    
}
