package pl.dors.radek;

import com.badlogic.gdx.Game;
import pl.dors.radek.screens.SplashScreen;

public class MattTutorial extends Game {

    public static final int WIDTH = 480;
    public static final int HEIGHT = 700;

    private boolean paused;

    @Override
    public void create() {
        this.setScreen(new SplashScreen(this));
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
}
