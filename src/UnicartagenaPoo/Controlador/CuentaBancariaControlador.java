/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UnicartagenaPoo.Controlador;

import UnicartagenaPoo.ModeloEntidades.CuentaBancaria;
import java.util.*;

/**
 *
 * @author juana
 */
public class CuentaBancariaControlador {

    private ArrayList<CuentaBancaria> cuentas;

    public CuentaBancariaControlador() {
        cuentas = new ArrayList<>();
    }

    public void agregarCuentaBancaria(String numeroCuenta, String tipoCuenta, double saldoCuents) {
        CuentaBancaria cuenta = new CuentaBancaria(numeroCuenta, tipoCuenta, saldoCuents);
        cuentas.add(cuenta);
    }

    public boolean editarCuentaBancaria(String numeroCuenta, double saldo, String tipoCuenta) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                cuenta.setSaldoCuenta(saldo);
                cuenta.setTipoCuenta(tipoCuenta);
                return true; 
            }
        }
        return false;
    }

    public boolean eliminarCuentaBancaria(String numeroCuenta) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                cuentas.remove(cuenta);
                return true; 
            }
        }
        return false;
    }

    public ArrayList<CuentaBancaria> listarCuentasBancarias() {
        return cuentas;
    }
}
