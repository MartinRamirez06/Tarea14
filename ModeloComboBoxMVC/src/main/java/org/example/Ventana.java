package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Ventana extends JFrame {
    private JLabel lblnombre;
    private JTextField txtNombre;
    private JButton boton;
    private JComboBox combo;
    private NombreComboModelo modelo;

    public Ventana(String title) throws HeadlessException {
        super(title);
        this.setSize(400,400);
        setLayout(new FlowLayout());
        lblnombre=new JLabel("Ingresa un nombre:");
        this.getContentPane().add(lblnombre);
        txtNombre=new JTextField(30);
        this.getContentPane().add(txtNombre);
        boton=new JButton("Agregar");
        this.getContentPane().add(boton);
        //Configurar el modelo
        modelo=new NombreComboModelo();
        modelo.agregarNombre("Diana");
        modelo.agregarNombre("Diego");
        modelo.agregarNombre("Susana");
        combo=new JComboBox<>(modelo);
        this.getContentPane().add(combo);

        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String nuevo= txtNombre.getText();
                modelo.agregarNombre(nuevo);
                txtNombre.setText("");

            }
        });
            combo.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(combo.getSelectedIndex());
                    System.out.println(combo.getSelectedItem());
                    JOptionPane.showMessageDialog(null,"Hola "+ combo.getSelectedItem());
                }
            });


        //Para que se vea
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //para que funcione la X de la ventana
        /*this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
         */
    }
}
