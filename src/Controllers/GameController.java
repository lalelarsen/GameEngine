/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Objects.SceneOne;
import Panels.MainPanel;
import enums.PlayerStatus;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import javax.swing.JFrame;

/**
 *
 * @author frederik.larsen
 */
public class GameController {

    SceneOne currScene;
    KeyboardController KC = new KeyboardController();
    int FRAMES60_PER_SECOND = 16;
    int counter1 = 1;
    int counter2 = 1;
    int counter3 = 1;
    int counter4 = 1;
    int counter5 = 1;
    int counter6 = 1;
    int counter7 = 1;
    int counter8 = 1;
    int counter9 = 1;
    int counter10 = 1;
    

    public void StartGame() {
        SpriteController sController = new SpriteController();
        currScene = new SceneOne();
        MainPanel mp = new MainPanel(KC, currScene);
        JFrame frame = new JFrame("Test");
        frame.setLayout(new BorderLayout());
        frame.add(mp);
        //frame.setUndecorated(true);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setLocation(150, 150);
        frame.setVisible(true);

        run(mp);
    }

    public void run(MainPanel mp) {
        while (true) {
            //manage the keys currently pressed
            mp.repaint();
            manageKeys();
            currScene.frame1();
            if(counter2 == 2){currScene.frame2(); counter2 = 0; }
            if(counter3 == 3){currScene.frame3(); counter3 = 0;}
            if(counter4 == 4){currScene.frame4(); counter4 = 0;}
            if(counter5 == 5){currScene.frame5(); counter5 = 0;}
            if(counter6 == 6){currScene.frame6(); counter6 = 0;}
            if(counter7 == 7){currScene.frame7(); counter7 = 0;}
            if(counter7 == 8){currScene.frame8(); counter8 = 0;}
            if(counter8 == 9){currScene.frame9(); counter8 = 0;manageKeys();}
            if(counter10 == 10){currScene.frame10(); counter10 = 0;}
            counter1++;
            counter2++;
            counter3++;
            counter4++;
            counter5++;
            counter6++;
            counter7++;
            counter8++;
            counter9++; 
            counter10++;
            
            
            try {
                Thread.sleep(FRAMES60_PER_SECOND);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //the function manages the keys currently pressed associating concrete
    //actions to them
    private void manageKeys() {
        //get the currently pressed keys from the KeyboardController
        HashSet<Integer> currentKeys = KeyboardController.getActiveKeys();

        if (currentKeys.contains(KeyEvent.VK_RIGHT)) {
            //move right
            currScene.OC.Hero.move(KeyEvent.VK_RIGHT);
        }
        if (currentKeys.contains(KeyEvent.VK_LEFT)) {
            //move left
            currScene.OC.Hero.move(KeyEvent.VK_LEFT);
        } 
        if (currentKeys.contains(KeyEvent.VK_DOWN)) {
            //move left
            currScene.OC.Hero.move(KeyEvent.VK_DOWN);
        }
        if (currentKeys.contains(KeyEvent.VK_UP)) {
            //move left
            currScene.OC.Hero.move(KeyEvent.VK_UP);
        }
        if(currentKeys.contains(KeyEvent.VK_SPACE)){
            currScene.OC.Hero.move(KeyEvent.VK_SPACE);
            currScene.OC.Hero.getPhysics().gravity = true;
        }
        if (currentKeys.isEmpty()) {
            //if the player is not pressing keys, the protagonist stands still
            currScene.OC.Hero.getSpriteManager().setStatus(PlayerStatus.IDLE);
        }

    }
}
