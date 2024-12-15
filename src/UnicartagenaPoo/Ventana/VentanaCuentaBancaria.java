/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UnicartagenaPoo.Ventana;

import UnicartagenaPoo.Controlador.CuentaBancariaControlador;
import UnicartagenaPoo.ModeloEntidades.CuentaBancaria;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author juana
 */
public class VentanaCuentaBancaria extends JFrame {

    private CuentaBancariaControlador cuentaBancariaControlador;

    private JTextField txtNumeroCuenta;
    private JTextField txtSaldo;
    private JTextField txtTipoCuenta;
    private JTextArea txtResultados;

    public VentanaCuentaBancaria() {
        
        cuentaBancariaControlador = new CuentaBancariaControlador();

        setTitle("Gestión de Cuentas Bancarias");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelFormulario = new JPanel(new GridLayout(5, 2, 10, 10));
        panelFormulario.setBackground(new Color(200, 230, 255));
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelFormulario.add(new JLabel("Número de Cuenta:"));
        txtNumeroCuenta = new JTextField();
        panelFormulario.add(txtNumeroCuenta);

        panelFormulario.add(new JLabel("Saldo:"));
        txtSaldo = new JTextField();
        panelFormulario.add(txtSaldo);

        panelFormulario.add(new JLabel("Tipo de Cuenta:"));
        txtTipoCuenta = new JTextField();
        panelFormulario.add(txtTipoCuenta);

        JButton btnAgregar = new JButton("Agregar", new ImageIcon(getClass().getResource("/UnicartagenaPoo/Ventana/Iconos/Icojam-Blue-Bits-Math-add.24.png")));
        btnAgregar.setBackground(new Color(144, 238, 144)); 
        panelFormulario.add(btnAgregar);
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String numeroCuenta = txtNumeroCuenta.getText();
                    double saldo = Double.parseDouble(txtSaldo.getText());
                    String tipoCuenta = txtTipoCuenta.getText();

                    cuentaBancariaControlador.agregarCuentaBancaria(numeroCuenta, tipoCuenta, saldo);
                    txtResultados.setText("Cuenta bancaria agregada exitosamente.");
                    limpiarCampos();
                } catch (NumberFormatException ex) {
                    txtResultados.setText("Error: Verifique que el saldo sea un número válido.");
                }
            }
        });

        JButton btnEditar = new JButton("Editar", new ImageIcon(getClass().getResource("/UnicartagenaPoo/Ventana/Iconos/Custom-Icon-Design-Flatastic-10-Edit-validated.24.png")));
        btnEditar.setBackground(new Color(255, 215, 0));
        panelFormulario.add(btnEditar);
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroCuenta = txtNumeroCuenta.getText();
                try {
                    double saldo = Double.parseDouble(txtSaldo.getText());
                    String tipoCuenta = txtTipoCuenta.getText();

                    boolean resultado = cuentaBancariaControlador.editarCuentaBancaria(numeroCuenta, saldo, tipoCuenta);
                    if (resultado) {
                        txtResultados.setText("Cuenta bancaria editada exitosamente.");
                        limpiarCampos();
                    } else {
                        txtResultados.setText("Cuenta bancaria no encontrada.");
                    }
                } catch (NumberFormatException ex) {
                    txtResultados.setText("Error: Verifique que el saldo sea un número válido.");
                }
            }
        });

        JButton btnEliminar = new JButton("Eliminar", new ImageIcon(getClass().getResource("/UnicartagenaPoo/Ventana/Iconos/Pictogrammers-Material-Delete.24.png")));
        btnEliminar.setBackground(new Color(255, 99, 71));
        panelFormulario.add(btnEliminar);
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroCuenta = txtNumeroCuenta.getText();
                boolean resultado = cuentaBancariaControlador.eliminarCuentaBancaria(numeroCuenta);
                if (resultado) {
                    txtResultados.setText("Cuenta bancaria eliminada exitosamente.");
                    limpiarCampos();
                } else {
                    txtResultados.setText("Cuenta bancaria no encontrada.");
                }
            }
        });

        JButton btnConsultar = new JButton("Consultar", new ImageIcon(getClass().getResource("/UnicartagenaPoo/Ventana/Iconos/Icons8-Windows-8-Food-List-Ingredients.24.png")));
        btnConsultar.setBackground(new Color(173, 216, 230));
        panelFormulario.add(btnConsultar);
        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtResultados.setText("\nLista de Cuentas Bancarias:\n");
                for (CuentaBancaria cuenta : cuentaBancariaControlador.listarCuentasBancarias()) {
                    txtResultados.append(cuenta.getNumeroCuenta() + " - Saldo: " + cuenta.getSaldoCuenta() + " - Tipo de Cuenta: " + cuenta.getTipoCuenta() + "\n");
                }
            }
        });

        add(panelFormulario, BorderLayout.NORTH);

        txtResultados = new JTextArea();
        txtResultados.setEditable(false);
        txtResultados.setBackground(new Color(245, 245, 245)); 
        add(new JScrollPane(txtResultados), BorderLayout.CENTER);

        setVisible(true);
    }

    private void limpiarCampos() {
        txtNumeroCuenta.setText("");
        txtSaldo.setText("");
        txtTipoCuenta.setText("");
    }

    public static void main(String[] args) {
        new VentanaCuentaBancaria();
    }
}
