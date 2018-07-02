/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.applet.Applet;
import java.applet.AudioClip;
import javax.swing.JLabel;

/**
 *
 * @author Carlos Ruiz
 */
public class DisparoThread extends Thread{
    
    private int x, y, step;
    private JLabel disparo;

    public DisparoThread() {
    }

    public void DisparoThread(int x, int y, int step, JLabel disparo) {
        this.x = x;
        this.y = y;
        this.step = step;
        this.disparo = disparo;
    }

    @Override
    public void run() {
        Sonido();
        while (true){
            this.disparo.setLocation(x+=step, y);
            try {
                sleep(250);
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
