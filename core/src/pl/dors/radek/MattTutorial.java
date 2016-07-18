package pl.dors.radek;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import pl.dors.radek.screens.SplashScreen;

import static com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpawnShape.point;

public class MattTutorial extends Game {

    public final static String PREFS_NAME = "pl.dors.radek.matt.tutorial";
    public final static String PREFS_SCORE = "pl.dors.radek.matt.tutorial.score";

    public static final int WIDTH = 480;
    public static final int HEIGHT = 700;
    public static final boolean DEBUG_MODE = true;

    private boolean paused;
    private int points;

    private Preferences prefs;

    @Override
    public void create() {
        init();
        this.setScreen(new SplashScreen(this));
    }

    private void init() {
        prefs = Gdx.app.getPreferences(PREFS_NAME);
        loadScore();
    }

    private void loadScore() {
        points = prefs.getInteger(PREFS_SCORE);
    }

    public void addPoint() {
        points++;
        prefs.putInteger(PREFS_SCORE, points);
        prefs.flush();
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
