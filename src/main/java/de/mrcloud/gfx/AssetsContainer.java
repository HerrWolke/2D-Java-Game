package de.mrcloud.gfx;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AssetsContainer {
    public static BufferedImage grass, dirt, stone;
    private static int width = 64;
    private static int height = 64;
    public List<BufferedImage> assets = new ArrayList<>();
    public List<BufferedImage> chracterSprites = new ArrayList<>();

    public void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/creatures/tiles_gras.png"));
//
//        for (int i = 0; i < sheet.getBuffImg().getWidth() / 32; i++) {
//            assets.add(sheet.crop(i * width, 0, width, height));
//            assets.add(sheet.crop(i * width, height, width, height));
//            assets.add(sheet.crop(i * width, height * 2, width, height));
//            assets.add(sheet.crop(i * width, height * 3, width, height));
//        }

        grass = sheet.crop(0, 0, width, height);
        dirt = sheet.crop(64, 0, width, height);
        stone = sheet.crop(128, 0, width, height);

    }


    public void initCharacters() {
        URL url = AssetsContainer.class.getResource("/textures/creatures/");
//        System.out.println(url);
        File dir = null;
        try {
            dir = new File(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


        for (File file : dir.listFiles()) {
            System.out.println(file.getAbsolutePath());
//            System.out.println("/textures/creatures/" + file.getName());
            SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/creatures/" + file.getName()));
            chracterSprites.add(sheet.getBuffImg());
        }
    }

}
