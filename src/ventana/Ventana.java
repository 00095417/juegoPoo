/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventana;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Carlos Ruiz
 */
public class Ventana extends JFrame implements KeyListener{
    
    private JLabel imagen;
    private JButton seleccionar;
    private JComboBox animacion;
    private int step = 20,izquierda=37,arriba = 38,derecha=39,abajo=40;
    private Container container = getContentPane();

    public Ventana() {
        setLayout(null);
        iniciarComponentes();
        setTitle("Prueba de movimiento");
        setSize(500,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        eventos();
    }
    
    private void iniciarComponentes(){
        
        seleccionar = new JButton("Cambiar");
        seleccionar.addKeyListener(this);
        seleccionar.setBounds(20, 20, 100, 25);
        
        animacion = new JComboBox();
        animacion.setBounds(130, 20, 100, 25);
        animacion.addItem("canguro");
        animacion.addItem("dragon");
        animacion.addItem("murcielago");
        animacion.addItem("tortuga");        
        
        imagen = new JLabel();
        imagen.setIcon(new ImageIcon(getClass().getResource(animacion.getSelectedItem().toString()+".gif")));
        imagen.setBounds(60,100,200,200);

        container.add(seleccionar);
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
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==izquierda)
        {
            this.imagen.setLocation(imagen.getX()-step, imagen.getY());
        }
        if(e.getKeyCode()==arriba)
        {
            this.imagen.setLocation(imagen.getX(), imagen.getY()-step);
        }
        if(e.getKeyCode()==derecha)
        {
            this.imagen.setLocation(imagen.getX()+step, imagen.getY());
        }
        if(e.getKeyCode()==abajo)
        {
            this.imagen.setLocation(imagen.getX(), imagen.getY()+step);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }  
}
