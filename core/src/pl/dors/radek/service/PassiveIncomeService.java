package pl.dors.radek.service;


import com.badlogic.gdx.utils.Timer;

/**
 * Created by rdors on 2016-07-21.
 */
public class PassiveIncomeService {

    private final static int INFINITE = Integer.MAX_VALUE;

    private ScoreService scoreService;

    public PassiveIncomeService(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    public void start() {
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                scoreService.addPoints(scoreService.getPassiveIncome());
            }
        }, 1, 1, INFINITE);
    }
}
