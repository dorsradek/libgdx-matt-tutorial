package pl.dors.radek.service;


import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Timer;

import java.util.concurrent.TimeUnit;

/**
 * Created by rdors on 2016-07-21.
 */
public class PassiveIncomeService {

    private final static int INFINITE = Integer.MAX_VALUE;

    private ScoreService scoreService;

    public PassiveIncomeService(ScoreService scoreService) {
        this.scoreService = scoreService;
        calculateGainedPassiveIncome();
    }

    public void start() {
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                scoreService.addPoints(scoreService.getPassiveIncome());
            }
        }, 1, 1, INFINITE);
    }

    private void calculateGainedPassiveIncome() {
        long savedTimestamp = scoreService.getSavedTimestamp();
        if (savedTimestamp > 0) {
            long millisPassed = TimeUtils.timeSinceMillis(savedTimestamp);
            long seconds = TimeUnit.MILLISECONDS.toSeconds(millisPassed);
            addPointsBasedOnPassedTime(seconds);
        }
    }

    private void addPointsBasedOnPassedTime(long seconds) {
        if (seconds > 0) {
            int points = (int) seconds * scoreService.getPassiveIncome() / 5;
            scoreService.addPoints(points);
        }
    }
}
