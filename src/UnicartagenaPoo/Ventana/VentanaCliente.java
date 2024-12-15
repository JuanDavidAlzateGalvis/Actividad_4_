/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UnicartagenaPoo.Ventana;

import UnicartagenaPoo.Controlador.ClienteControlador;
import UnicartagenaPoo.ModeloEntidades.Cliente;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author juana
 */
public class VentanaCliente extends JFrame {

    private ClienteControlador clienteControlador;

    private JTextField txtNombre;
    private JTextField txtEdad;
    private JTextField txtTipoCuenta;
    private JTextArea txtResultados;

    public VentanaCliente() {
        
        clienteControlador = new ClienteControlador();

        setTitle("Gestión de Clientes");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelFormulario = new JPanel(new GridLayout(5, 2, 10, 10));
        panelFormulario.setBackground(new Color(200, 230, 255));
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelFormulario.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelFormulario.add(txtNombre);

        panelFormulario.add(new JLabel("Edad:"));
        txtEdad = new JTextField();
        panelFormulario.add(txtEdad);

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
                    String nombre = txtNombre.getText();
                    int edad = Integer.parseInt(txtEdad.getText());
                    String tipoCuenta = txtTipoCuenta.getText();

                    clienteControlador.agregarCliente(nombre, edad, tipoCuenta);
                    txtResultados.setText("Cliente agregado exitosamente.");
                    limpiarCampos();
                } catch (NumberFormatException ex) {
                    txtResultados.setText("Error: Verifique que los datos sean correctos.");
                }
            }
        });

        JButton btnEditar = new JButton("Editar", new ImageIcon(getClass().getResource("/UnicartagenaPoo/Ventana/Iconos/Custom-Icon-Design-Flatastic-10-Edit-validated.24.png")));
        btnEditar.setBackground(new Color(255, 215, 0)); 
        panelFormulario.add(btnEditar);
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                try {
                    int edad = Integer.parseInt(txtEdad.getText());
                    String tipoCuenta = txtTipoCuenta.getText();

                    boolean resultado = clienteControlador.editarCliente(nombre, edad, tipoCuenta);
                    if (resultado) {
                        txtResultados.setText("Cliente editado exitosamente.");
                        limpiarCampos();
                    } else {
                        txtResultados.setText("Cliente no encontrado.");
                    }
                } catch (NumberFormatException ex) {
                    txtResultados.setText("Error: Verifique que los datos sean correctos.");
                }
            }
        });

        JButton btnEliminar = new JButton("Eliminar", new ImageIcon(getClass().getResource("/UnicartagenaPoo/Ventana/Iconos/Pictogrammers-Material-Delete.24.png")));
        btnEliminar.setBackground(new Color(255, 99, 71)); 
        panelFormulario.add(btnEliminar);
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                boolean resultado = clienteControlador.eliminarCliente(nombre);
                if (resultado) {
                    txtResultados.setText("Cliente eliminado exitosamente.");
                    limpiarCampos();
                } else {
                    txtResultados.setText("Cliente no encontrado.");
                }
            }
        });

        JButton btnConsultar = new JButton("Consultar", new ImageIcon(getClass().getResource("/UnicartagenaPoo/Ventana/Iconos/Icons8-Windows-8-Food-List-Ingredients.24.png")));
        btnConsultar.setBackground(new Color(173, 216, 230)); 
        panelFormulario.add(btnConsultar);
        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtResultados.setText("\nLista de Clientes:\n");
                for (Cliente cliente : clienteControlador.listarClientes()) {
                    txtResultados.append(cliente.getNombre() + " - Edad: " + cliente.getEdad() + " - Tipo de Cuenta: " + cliente.getTipoCuenta() + "\n");
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
        txtNombre.setText("");
        txtEdad.setText("");
        txtTipoCuenta.setText("");
    }

    public static void main(String[] args) {
        new VentanaCliente();
    }
}
