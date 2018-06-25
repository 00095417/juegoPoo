/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Carlos Ruiz
 */
public class Ventana extends JFrame {
    
    private JLabel imagen;
    private JButton seleccionar,jugar;
    private JComboBox animacion;

    private Container container = getContentPane();

    public Ventana() {
        setLayout(null);
        iniciarComponentes();
        setTitle("Prueba de seleccion de personaje");
        setSize(350,350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        eventos();
    }
    
    private void iniciarComponentes(){
        
        seleccionar = new JButton("Mostrar");
        seleccionar.setBounds(20, 20, 100, 25);
        
        jugar = new JButton("Jugar");
        jugar.setBounds(20, 50, 100, 25);
        
        animacion = new JComboBox();
        animacion.setBounds(130, 20, 100, 25);
        animacion.addItem("canguro");
        animacion.addItem("dragon");
        animacion.addItem("murcielago");
        animacion.addItem("tortuga");
        animacion.addItem("fantasma");
        
        imagen = new JLabel();
        imagen.setIcon(new ImageIcon(getClass().getResource(animacion.getSelectedItem().toString()+".gif")));
        imagen.setBounds(60,100,200,200);

        container.add(seleccionar);
        container.add(jugar);
        container.add(animacion);
        container.add(imagen);
    }
    
    public void eventos(){
        seleccionar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                imagen.setIcon(new ImageIcon(getClass().getResource(animacion.getSelectedItem().toString()+".gif")));
            }
        });
        jugar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaJuego(animacion.getSelectedItem().toString()).setVisible(true);
                dispose();
            }
        });
    } 
}
