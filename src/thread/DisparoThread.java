/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Container;
import javax.swing.JLabel;

/**
 *
 * @author Carlos Ruiz
 */
public class DisparoThread extends Thread{
    
    private int x, y, step;
    private JLabel disparo;
    private Container container;

    public DisparoThread() {
    }

    public void DisparoThread(int x, int y, int step, JLabel disparo, Container container) {
        this.x = x;
        this.y = y;
        this.step = step;
        this.disparo = disparo;
        this.container = container;
    }

    @Override
    public void run() {
        Sonido();
        while (true){
            try {
                this.disparo.setLocation(x+=step, y);
                if (this.disparo.getX()>400){
                    container.remove(disparo);
                    
                }
                sleep(150);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    
    public void Sonido(){
        AudioClip audio;
        audio = Applet.newAudioClip(getClass().getResource("disparo.wav"));
        audio.play();
    }
    
}
