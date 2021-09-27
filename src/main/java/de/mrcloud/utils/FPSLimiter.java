package de.mrcloud.utils;

public class FPSLimiter {
    int fps;
    double timePerTick;
    double delta = 0;
    long now;
    long lastTime = System.nanoTime();
    long timer = 0;
    int ticks = 0;


    public FPSLimiter(int fps) {
        this.fps = fps;
        timePerTick = 1000000000 / fps;
    }

    public boolean checkLastFrame() {
        now = System.nanoTime();
        delta += (now - lastTime) / timePerTick;
        timer += now - lastTime;
        lastTime = now;

        if (delta >= 1) {
            ticks++;
            delta--;
            return true;
        }

        if (timer >= 1000000000) {
//            System.out.println("Ticks and Frames: " + ticks);
            ticks = 0;
            timer = 0;
        }

        return false;

    }

    public int getFps() {
        return fps;
    }

    public void setFps(int fps) {
        this.fps = fps;
    }


    public double getDelta() {
        return delta;
    }

    public void setDelta(double delta) {
        this.delta = delta;
    }

    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }

    public long getLastTime() {
        return lastTime;
    }

    public void setLastTime(long lastTime) {
        this.lastTime = lastTime;
    }

    public long getTimer() {
        return timer;
    }

    public void setTimer(long timer) {
        this.timer = timer;
    }
}
