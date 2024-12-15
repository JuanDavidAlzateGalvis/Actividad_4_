/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UnicartagenaPoo.Ventana;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author juana
 */
public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {
        setTitle("Sistema de Gestión de Banco");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelFondo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(173, 216, 230)); 
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panelFondo.setLayout(new BorderLayout());

        ImageIcon icono = new ImageIcon(getClass().getResource("/UnicartagenaPoo/Ventana/Iconos/Google-Noto-Emoji-Travel-Places-42492-bank.24.png"));

        JLabel lblTitulo = new JLabel("Sistema de Gestión de Banco", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 30));  
        lblTitulo.setForeground(Color.DARK_GRAY);  
        lblTitulo.setIcon(icono);  
        lblTitulo.setIconTextGap(20);  

        panelFondo.add(lblTitulo, BorderLayout.NORTH);
        
        JMenuBar menuBar = new JMenuBar();
        
        JMenu menuBanco = new JMenu("Banco");
        JMenuItem itemBanco = new JMenuItem("Abrir Banco");
        itemBanco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Sistema de Gestión de Banco: Banco");
                new VentanaBanco();
            }
        });
        menuBanco.add(itemBanco);

        JMenu menuCliente = new JMenu("Cliente");
        JMenuItem itemCliente = new JMenuItem("Abrir Cliente");
        itemCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Sistema de Gestión de Banco: Cliente");
                new VentanaCliente();
            }
        });
        menuCliente.add(itemCliente);

        JMenu menuCuentaBancaria = new JMenu("Cuenta Bancaria");
        JMenuItem itemCuentaBancaria = new JMenuItem("Abrir Cuenta Bancaria");
        itemCuentaBancaria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Sistema de Gestión de Banco: Cuenta Bancaria");
                new VentanaCuentaBancaria(); 
            }
        });
        menuCuentaBancaria.add(itemCuentaBancaria);

        menuBar.add(menuBanco);
        menuBar.add(menuCliente);
        menuBar.add(menuCuentaBancaria);

        setJMenuBar(menuBar); 

        add(panelFondo);  
        setVisible(true); 
    }

    public static void main(String[] args) {
        new VentanaPrincipal(); 
    }
}
