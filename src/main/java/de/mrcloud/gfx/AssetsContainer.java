package de.mrcloud.gfx;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AssetsContainer {
    public static BufferedImage grass, dirt, stone, wandglow, tree;
    private static int width = 64;
    private static int height = 64;
    public static List<BufferedImage> assets = new ArrayList<>();
    public static BufferedImage[] player_down, player_up, player_left, player_right;

    public static List<BufferedImage> chracterSprites = new ArrayList<>();

    public void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/creatures/tiles_gras.png"));
        SpriteSheet playerAnim = new SpriteSheet(ImageLoader.loadImage("/textures/creatures/anim_player_v2.png"));
        SpriteSheet treeSheet = new SpriteSheet(ImageLoader.loadImage("/textures/tree.png"));

        tree = treeSheet.crop(0,0,width,height);
        player_down = new BufferedImage[3];
        player_up = new BufferedImage[3];
        player_right = new BufferedImage[3];
        player_left = new BufferedImage[3];

        player_down[0] = playerAnim.crop(0, 0,width,height);
        player_down[1] = playerAnim.crop(width , 0,width,height);
        player_down[2] = playerAnim.crop(width * 2, 0,width,height);

        player_up[0] = playerAnim.crop(width * 3, 0,width,height);
        player_up[1] = playerAnim.crop(width * 4 , 0,width,height);
        player_up[2] = playerAnim.crop(width * 5, 0,width,height);

        player_right[0] = playerAnim.crop(0, height,width,height);
        player_right[1] = playerAnim.crop(width , height,width,height);
        player_right[2] = playerAnim.crop(width  * 2, height,width,height);

        player_left[0] = playerAnim.crop(width * 3, height,width,height);
        player_left[1] = playerAnim.crop(width * 4, height,width,height);
        player_left[2] = playerAnim.crop(width * 5, height,width,height);

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
        wandglow = sheet.crop(192, 0, width, height);

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
