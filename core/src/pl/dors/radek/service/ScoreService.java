package pl.dors.radek.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.utils.TimeUtils;

/**
 * Created by rdors on 2016-07-21.
 */
public class ScoreService {

    public final static String PREFS_NAME = "pl.dors.radek.matt.tutorial";
    public final static String PREFS_SCORE = "pl.dors.radek.matt.tutorial.score";
    public final static String PREFS_PASSIVE_INCOME = "pl.dors.radek.matt.tutorial.passiveincome";
    public final static String PREFS_SAVED_TIMESTAMP = "pl.dors.radek.matt.tutorial.savedtimestamp";

    private Preferences prefs;

    private int points;
    private int passiveIncome;

    public ScoreService() {
        init();
    }

    private void init() {
        prefs = Gdx.app.getPreferences(PREFS_NAME);
        loadScore();
        loadPassiveIncome();
    }

    private void loadScore() {
        points = prefs.getInteger(PREFS_SCORE);
    }


    private void loadPassiveIncome() {
        passiveIncome = prefs.getInteger(PREFS_PASSIVE_INCOME);
    }

    public void addPoint() {
        points++;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public void addPassiveIncome() {
        passiveIncome++;
    }

    public void resetGameScore() {
        points = 0;
        passiveIncome = 0;
    }

    public int getPoints() {
        return points;
    }

    public int getPassiveIncome() {
        return passiveIncome;
    }

    public long getSavedTimestamp() {
        return prefs.getLong(PREFS_SAVED_TIMESTAMP);
    }

    public void saveCurrentGameState() {
        prefs.putLong(PREFS_SAVED_TIMESTAMP, TimeUtils.millis());
        prefs.putInteger(PREFS_SCORE, points);
        prefs.putInteger(PREFS_PASSIVE_INCOME, passiveIncome);
        prefs.flush();
    }
}
