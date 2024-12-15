/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UnicartagenaPoo.ModeloCrud;
import UnicartagenaPoo.ModeloEntidades.CuentaBancaria;
import java.util.*;

/**
 *
 * @author juana
 */
public class CuentaBancariaCrud {
    
    private List<CuentaBancaria> cuentas;

    public CuentaBancariaCrud() {
        this.cuentas = new ArrayList<>(); }

    public void agregarCuenta(CuentaBancaria cuenta) {
        cuentas.add(cuenta); }

    public List<CuentaBancaria> listarCuentas() {
        return cuentas; }

    public CuentaBancaria buscarCuenta(String numeroCuenta) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equalsIgnoreCase(numeroCuenta)) {
                return cuenta;
            }
        }
        return null;
    }

    public boolean eliminarCuenta(String numeroCuenta) {
        return cuentas.removeIf(cuenta -> cuenta.getNumeroCuenta().equalsIgnoreCase(numeroCuenta)); }
    
}
