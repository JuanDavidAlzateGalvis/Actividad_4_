/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UnicartagenaPoo.Ventana;

import UnicartagenaPoo.Controlador.BancoControlador;
import UnicartagenaPoo.ModeloEntidades.Banco;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author juana
 */
public class VentanaBanco extends JFrame {
    
    private BancoControlador bancoControlador;

    private JTextField txtNombre;
    private JTextField txtPais;
    private JTextField txtNumSucursales;
    private JTextField txtNumClientes;
    private JTextArea txtResultados;

    public VentanaBanco() {
        
        bancoControlador = new BancoControlador();

        setTitle("Gestión de Bancos");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelFormulario = new JPanel(new GridLayout(6, 2, 10, 10));
        panelFormulario.setBackground(new Color(200, 230, 255)); 
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 

        panelFormulario.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelFormulario.add(txtNombre);

        panelFormulario.add(new JLabel("País:"));
        txtPais = new JTextField();
        panelFormulario.add(txtPais);

        panelFormulario.add(new JLabel("Número de Sucursales:"));
        txtNumSucursales = new JTextField();
        panelFormulario.add(txtNumSucursales);

        panelFormulario.add(new JLabel("Número de Clientes:"));
        txtNumClientes = new JTextField();
        panelFormulario.add(txtNumClientes);

        JButton btnAgregar = new JButton("Agregar", new ImageIcon(getClass().getResource("/UnicartagenaPoo/Ventana/Iconos/Icojam-Blue-Bits-Math-add.24.png")));
        btnAgregar.setBackground(new Color(144, 238, 144)); 
        panelFormulario.add(btnAgregar);
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = txtNombre.getText();
                    String pais = txtPais.getText();
                    int sucursales = Integer.parseInt(txtNumSucursales.getText());
                    int clientes = Integer.parseInt(txtNumClientes.getText());

                    bancoControlador.agregarBanco(nombre, pais, sucursales, clientes);
                    txtResultados.setText("Banco agregado exitosamente.");
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
                String pais = txtPais.getText();
                try {
                    int sucursales = Integer.parseInt(txtNumSucursales.getText());
                    int clientes = Integer.parseInt(txtNumClientes.getText());

                    boolean resultado = bancoControlador.editarBanco(nombre, pais, sucursales, clientes);
                    if (resultado) {
                        txtResultados.setText("Banco editado exitosamente.");
                        limpiarCampos();
                    } else {
                        txtResultados.setText("Banco no encontrado.");
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
                boolean resultado = bancoControlador.eliminarBanco(nombre);
                if (resultado) {
                    txtResultados.setText("Banco eliminado exitosamente.");
                    limpiarCampos();
                } else {
                    txtResultados.setText("Banco no encontrado.");
                }
            }
        });
        
        JButton btnConsultar = new JButton("Consultar", new ImageIcon(getClass().getResource("/UnicartagenaPoo/Ventana/Iconos/Icons8-Windows-8-Food-List-Ingredients.24.png")));
        btnConsultar.setBackground(new Color(173, 216, 230)); 
        panelFormulario.add(btnConsultar);
        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtResultados.setText("\nLista de Bancos:\n");
                for (Banco banco : bancoControlador.listarBancos()) {
                    txtResultados.append(banco.getNombre() + " - " + banco.getPais() + "\n");
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
        txtPais.setText("");
        txtNumSucursales.setText("");
        txtNumClientes.setText("");
    }

    public static void main(String[] args) {
        new VentanaBanco();
    }
}
