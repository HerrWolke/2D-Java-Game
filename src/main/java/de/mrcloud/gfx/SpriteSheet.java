package de.mrcloud.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {
    private BufferedImage buffImg;

    public SpriteSheet(BufferedImage buffImg) {
        this.buffImg = buffImg;
    }

    public BufferedImage crop(int x, int y, int width, int height) {
        return buffImg.getSubimage(x, y, width, height);
    }

    public BufferedImage getBuffImg() {
        return buffImg;
    }

    public void setBuffImg(BufferedImage buffImg) {
        this.buffImg = buffImg;
    }
}
