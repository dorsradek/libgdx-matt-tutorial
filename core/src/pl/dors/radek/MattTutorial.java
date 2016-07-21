package pl.dors.radek;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import pl.dors.radek.screens.SplashScreen;
import pl.dors.radek.service.SoundService;

public class MattTutorial extends Game {

    public final static String PREFS_NAME = "pl.dors.radek.matt.tutorial";
    public final static String PREFS_SCORE = "pl.dors.radek.matt.tutorial.score";

    public static final int WIDTH = 480;
    public static final int HEIGHT = 700;
    public static final boolean DEBUG_MODE = true;

    private SoundService soundService;

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
        initSoundService();
    }

    private void initSoundService() {
        soundService = new SoundService();
    }

    private void loadScore() {
        points = prefs.getInteger(PREFS_SCORE);
    }

    public void addPoint() {
        points++;
        updatePointInPrefs();
    }

    public void addPoints(int points) {
        this.points += points;
        updatePointInPrefs();
    }

    public void addPassiveIncome() {
        //TODO: implement
    }

    public void resetGameScore() {
        points = 0;
        updatePointInPrefs();
    }

    private void updatePointInPrefs() {
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

    public SoundService getSoundService() {
        return soundService;
    }

}
