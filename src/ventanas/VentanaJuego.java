/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import enemigothread.EnemigoThread;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Carlos Ruiz
 */
public class VentanaJuego extends JFrame implements KeyListener{
    
    private JLabel imagen,dato, enemigo;
    private ImageIcon img,enemi;
    private Icon player,fantasma1;
    private String personaje;
    private int step = 20,izquierda=37,arriba = 38,derecha=39,abajo=40, width = 400,heigth = 350;
    private EnemigoThread enemigo1 = new EnemigoThread();
    
    private Container container = getContentPane();
    
    public VentanaJuego(String personaje) {
        setLayout(null);
        this.personaje = personaje;
        iniciarComponentes();
        setTitle("Prueba de movimientos del personaje");
        setSize(width,heigth);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(this);
        enemigo1.start();
    }
    
    public void iniciarComponentes(){
        
        dato = new JLabel("Presione 'Enter' para salir");
        dato.setBounds(10, 10, 150, 25);
        
        imagen = new JLabel();
        imagen.setBounds(60,100,100,100);
        
        enemigo = new JLabel();
        enemigo.setBounds(160,100,50,50);
        
        img = new ImageIcon(getClass().getResource(personaje+".gif"));
        enemi = new ImageIcon(getClass().getResource("fantasma.gif"));
        
        player = new ImageIcon(img.getImage().getScaledInstance(imagen.getWidth(),imagen.getHeight(), Image.SCALE_DEFAULT));
        fantasma1 = new ImageIcon(enemi.getImage().getScaledInstance(enemigo.getWidth(),enemigo.getHeight(), Image.SCALE_DEFAULT));
        
        imagen.setIcon(player);
        enemigo.setIcon(fantasma1);
        
        enemigo1.EnemigoThread(enemigo.getX(),enemigo.getY(),width-50,heigth-50,step,enemigo);
        
        container.add(dato);
        container.add(imagen);
        container.add(enemigo);        
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
