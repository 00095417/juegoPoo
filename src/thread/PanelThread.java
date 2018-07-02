/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.awt.Container;

/**
 *
 * @author Carlos Ruiz
 */
public class PanelThread extends Thread{
    
    private Container container;

    public PanelThread() {
    }

    public void PanelThread(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(container.getComponentCount());
            if (container.getComponentCount()>4)
            {
                if (container.getComponent(4).getX()>400)
                {
                    //System.out.println("la bala a salido de la pantalla");
                    container.remove(container.getComponent(4));
                }
            }
            try {
                sleep(250);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        
    }
    
    
    
}
