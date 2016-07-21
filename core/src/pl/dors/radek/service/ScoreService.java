package pl.dors.radek.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * Created by rdors on 2016-07-21.
 */
public class ScoreService {

    public final static String PREFS_NAME = "pl.dors.radek.matt.tutorial";
    public final static String PREFS_SCORE = "pl.dors.radek.matt.tutorial.score";

    private int points;

    private Preferences prefs;

    public ScoreService() {
        init();
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

    public int getPoints() {
        return points;
    }
}
