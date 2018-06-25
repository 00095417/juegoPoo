/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JLabel;

/**
 *
 * @author Carlos Ruiz
 */
public class EnemigoThread extends Thread{
    
    private int x, y, limitex, limitey, step;
    private JLabel enemigo;

    public EnemigoThread() {}

    public void EnemigoThread(int x, int y, int limitex, int limitey, int step, JLabel enemigo) {
        this.x = x;
        this.y = y;
        this.limitex = limitex;
        this.limitey = limitey;
        this.step = step;
        this.enemigo = enemigo;
    }

    @Override
    public void run() {
        
        while(true){
        switch(getNumRandom(1,8))
        {
            case 1:
                if (estaEnVentana(x,y-step)){
                    this.enemigo.setLocation(x, y);
                }
                break;
            case 2:
                if (estaEnVentana(x+step,y-step)){
                    this.enemigo.setLocation(x,y);
                }
                break;
            case 3:
                if (estaEnVentana(x+step, y)){
                    this.enemigo.setLocation(x, y);
                }
                break;
            case 4:
                if (estaEnVentana(x+step, y+step)){
                    this.enemigo.setLocation(x, y);
                }
                break;
            case 5:
                if (estaEnVentana(x, y+step)){
                    this.enemigo.setLocation(x, y);
                }
                break;
            case 6:
                this.enemigo.setLocation(x-step, y+step);
                break;
            case 7:
                if (estaEnVentana(x-step, y)){
                    this.enemigo.setLocation(x,y);
                }
                break;
            case 8:
                if (estaEnVentana(x-step, y-step)){
                    this.enemigo.setLocation(x,y);
                }
                break;
        }
        try {
                sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    
    private int getNumRandom(int min,int max){
        return ThreadLocalRandom.current().nextInt(min, max);
    }
    
    public boolean estaEnVentana(int stepX,int stepY){
        if (stepX>0&&stepX<this.limitex&&stepY>0&&stepY<this.limitey)
        {
            x = stepX;
            y = stepY;
            return true;
        }
        else
        {
            return false;
        }
    }    
}
