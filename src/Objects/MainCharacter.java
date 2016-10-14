/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Components.BaseObject;
import Components.Physics;
import Components.Sprite;
import static Controllers.SpriteController.loadSpriteRoll;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import Interfaces.Plottable;
import enums.FourDir;
import enums.PlayerStatus;
import java.util.Date;
import javafx.scene.chart.PieChart;

/**
 *
 * @author frederik.larsen
 */
public class MainCharacter extends BaseObject implements Plottable {
    long lastJump;
    public int speed = 5;
    public MainCharacter() {
        lastJump = System.currentTimeMillis();
        String path = "stickman.png";
        File fil = new File(path);
        BufferedImage imgg = null;
        //Get Image from path
        try {
            imgg = ImageIO.read(fil);
        } catch (Exception e) {
            System.out.println("The image was not loaded.");
        }
        
        addSpriteManager(PlayerStatus.NORTH);
//        getSpriteManager().addSprite(SpriteSheet.KNIGHTANIM, FourDir.RIGHT, 40, 8, 16, 16,16,0, 2, PlayerStatus.SOUTH);
//        getSpriteManager().addSprite(SpriteSheet.KNIGHTANIM, FourDir.RIGHT, 40, 40, 16, 16,16,0, 2, PlayerStatus.EAST);
//        getSpriteManager().addSprite(SpriteSheet.KNIGHTANIM, FourDir.RIGHT, 40, 104, 16, 16,16,0, 2, PlayerStatus.NORTH);
//        getSpriteManager().addSprite(SpriteSheet.KNIGHTANIM, FourDir.RIGHT, 40, 168, 16, 16,16,0, 2, PlayerStatus.WEST);
//        getSpriteManager().addSprite(SpriteSheet.KNIGHTANIM, FourDir.RIGHT, 8, 8, 16, 16, 0, 0, 1, PlayerStatus.IDLE);
        
        addPhysics();
        addHitbox(64, 64);
        getPhysics().gravity = false;
        img = imgg;
        
    }

    public void move(int dir) {
        Point currPoint = getCords();
        switch (dir) {
            case 37:
                //physics.applyForce(new Point(-1,0));
                setCords(currPoint.x - speed, currPoint.y);
                getSpriteManager().setStatus(PlayerStatus.WEST);
                break;
            case 38:
                //physics.applyForce(new Point(0,-1));
                getSpriteManager().setStatus(PlayerStatus.NORTH);
                setCords(currPoint.x, currPoint.y-speed);
                break;
            case 39:
                //physics.applyForce(new Point(1,0));
                getSpriteManager().setStatus(PlayerStatus.EAST);
                setCords(currPoint.x + speed, currPoint.y);
                break;
            case 40:
                //physics.applyForce(new Point(0,1));
                getSpriteManager().setStatus(PlayerStatus.SOUTH);
                setCords(currPoint.x, currPoint.y+speed);
                break;
            case 32:
                if (!physics.gravity) {
                    if(lastJump + 1000 < System.currentTimeMillis()){
                        lastJump = System.currentTimeMillis();
                        physics.applyForce(new Point(0, -5));
                        physics.gravity = true;
                    }
                }
                break;

        }
    }

    public void stop() {

    }

}
