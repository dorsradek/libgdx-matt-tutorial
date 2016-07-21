package pl.dors.radek;

import com.badlogic.gdx.Game;
import pl.dors.radek.screens.SplashScreen;
import pl.dors.radek.service.ScoreService;
import pl.dors.radek.service.SoundService;

public class MattTutorial extends Game {

    public static final int WIDTH = 480;
    public static final int HEIGHT = 700;
    public static final boolean DEBUG_MODE = true;

    private SoundService soundService;
    private ScoreService scoreService;

    private boolean paused;

    @Override
    public void create() {
        init();
        this.setScreen(new SplashScreen(this));
    }

    private void init() {
        initSoundService();
        initScoreService();
    }

    private void initSoundService() {
        soundService = new SoundService();
    }

    private void initScoreService() {
        scoreService = new ScoreService();
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

    public SoundService getSoundService() {
        return soundService;
    }


    public ScoreService getScoreService() {
        return scoreService;
    }
}
