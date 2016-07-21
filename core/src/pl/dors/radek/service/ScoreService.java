package pl.dors.radek.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * Created by rdors on 2016-07-21.
 */
public class ScoreService {

    public final static String PREFS_NAME = "pl.dors.radek.matt.tutorial";
    public final static String PREFS_SCORE = "pl.dors.radek.matt.tutorial.score";
    public final static String PREFS_PASSIVE_INCOME = "pl.dors.radek.matt.tutorial.passiveIncome";

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
        updateSavedScoreAndPassiveIncomeInPrefs();
    }

    public void addPoints(int points) {
        this.points += points;
        updateSavedScoreAndPassiveIncomeInPrefs();
    }

    public void addPassiveIncome() {
        passiveIncome++;
        updateSavedScoreAndPassiveIncomeInPrefs();
    }

    public void resetGameScore() {
        points = 0;
        passiveIncome = 0;
        updateSavedScoreAndPassiveIncomeInPrefs();
    }

    private void updateSavedScoreAndPassiveIncomeInPrefs() {
        prefs.putInteger(PREFS_SCORE, points);
        prefs.putInteger(PREFS_PASSIVE_INCOME, passiveIncome);
        prefs.flush();
    }

    public int getPoints() {
        return points;
    }

    public int getPassiveIncome() {
        return passiveIncome;
    }
}
