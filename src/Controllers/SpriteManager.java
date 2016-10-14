/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Components.Sprite;
import static Controllers.SpriteController.loadSpriteRoll;
import enums.FourDir;
import enums.PlayerStatus;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author frederik.larsen
 */
public class SpriteManager {
    ArrayList<Sprite> images = new ArrayList();
    Enum status = null;
    
    public SpriteManager(Enum status){
        this.status = status;
    }
    
    public void addSprite(Enum sheet, FourDir dir, int x, int y, int width, int height, int wSpace, int hSpace, int amount, Enum status){
        images.add(loadSpriteRoll(sheet, dir, x, y, width, height, wSpace, hSpace, amount, status));
    }
    
    public BufferedImage nextImage(){
        BufferedImage img = null;
        for (int i = 0; i < images.size(); i++) {
            if(status == images.get(i).getStatus()){
                img = images.get(i).getNextImage();
            }
        }
        return img;
    }

    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }
    
    
}
