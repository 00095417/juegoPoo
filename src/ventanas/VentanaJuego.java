/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Carlos Ruiz
 */
public class VentanaJuego extends JFrame implements KeyListener{
    
    private JLabel imagen,dato;
    private String personaje;
    private int step = 20,izquierda=37,arriba = 38,derecha=39,abajo=40;
    
    private Container container = getContentPane();
    
    public VentanaJuego(String personaje) {
        setLayout(null);
        this.personaje = personaje;
        iniciarComponentes();
        setTitle("Prueba de movimientos del personaje");
        setSize(400,350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(this);
    }
    
    public void iniciarComponentes(){
        
        dato = new JLabel("Presione 'Enter' para salir");
        dato.setBounds(10, 10, 150, 25);
        
        imagen = new JLabel();
        imagen.setIcon(new ImageIcon(getClass().getResource(personaje+".gif")));
        imagen.setBounds(60,100,200,200);
        
        container.add(dato);
        container.add(imagen);
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
        if (e.getKeyCode()==10)
        {
            dispose();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
