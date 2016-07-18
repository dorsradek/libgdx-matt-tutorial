package pl.dors.radek;

import com.badlogic.gdx.Game;
import pl.dors.radek.screens.SplashScreen;

public class MattTutorial extends Game {

    public static final int WIDTH = 480;
    public static final int HEIGHT = 700;
    public static final boolean DEBUG_MODE = true;

    private boolean paused;
    private int points;

    @Override
    public void create() {
        this.setScreen(new SplashScreen(this));
    }

    public void addPoint() {
        points++;
    }

    /**
     * getters and setters
     */

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public int getPoints() {
        return points;
    }

}
