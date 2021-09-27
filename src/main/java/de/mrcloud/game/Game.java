package de.mrcloud.game;

import de.mrcloud.Handler;
import de.mrcloud.gfx.AssetsContainer;
import de.mrcloud.gfx.Camera;
import de.mrcloud.handlers.InputHandler;
import de.mrcloud.states.GameState;
import de.mrcloud.states.MenuState;
import de.mrcloud.states.State;
import de.mrcloud.utils.FPSLimiter;
import de.mrcloud.window.Display;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

    private int width, height;
    public String title;
    private Display display;
    private Thread gameThread;
    private boolean running = false;
    private AssetsContainer assets;

    private long ticks;

    //Rendering
    private Camera camera;

    //States
    private State gameState;
    private State menuState;

    //Input Handling
    private InputHandler inputHandler;

    //Handler
    private Handler handler;


    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    private void init() {

        display = new Display(title, width, height);
        inputHandler = new InputHandler();

        //For Input to be accepted
        display.getCanvas().setFocusable(true);
        display.getCanvas().addKeyListener(inputHandler);

        handler = new Handler(this);


        assets = new AssetsContainer();
        assets.init();
        assets.initCharacters();

        camera = new Camera(handler,0,0);

        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        State.setCurrentState(gameState);
    }



    private void tick() {
        inputHandler.tick();
        ticks++;

        if (State.getCurrentState() != null)
            State.getCurrentState().tick();
    }

    private void render() {
        BufferStrategy strategy = display.getCanvas().getBufferStrategy();

        if (strategy == null) {
            display.getCanvas().createBufferStrategy(2);
            return;
        }

        Graphics graphics = strategy.getDrawGraphics();
        graphics.clearRect(0, 0, width, height);

        if (State.getCurrentState() != null)
            State.getCurrentState().render(graphics);

        //End draw
        strategy.show();
        graphics.dispose();
    }

    @Override
    public void run() {
        init();

        FPSLimiter limiter = new FPSLimiter(60);


        while (running) {
            if (limiter.checkLastFrame()) {
                tick();
                render();
            }
        }

    }

    public synchronized void start() {
        if (running)
            return;
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    public synchronized void stop() {
        if (!running)
            return;
        running = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public long getTicks() {
        return ticks;
    }

    public Camera getCamera() {
        return camera;
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }
}
