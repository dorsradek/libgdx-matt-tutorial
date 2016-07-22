package pl.dors.radek.controller;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Timer;
import pl.dors.radek.MattTutorial;

/**
 * Created by rdors on 2016-07-22.
 */
public class RandomEventController {

    //TODO: change afeter initial impl
    private static final int RANDOM_TICK_INTERVAL = 5;

    private MattTutorial game;

    public RandomEventController(MattTutorial game) {
        this.game = game;
        init();
    }

    private void init() {
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                if (MathUtils.randomBoolean()) {
                    triggerRandomEvent();
                }
            }
        }, RANDOM_TICK_INTERVAL, RANDOM_TICK_INTERVAL);
    }

    private void triggerRandomEvent() {
        int randomNumber = MathUtils.random(1, 3);
        switch (randomNumber) {
            case 1:
                gainMoneyEvent();
                break;
            case 2:
                loseMoneyEvent();
                break;
            case 3:
                gainPassiveIncome();
            default:
                break;
        }
    }


    private void gainMoneyEvent() {
        game.getScoreService().addPoints(123);
    }

    private void loseMoneyEvent() {
        game.getScoreService().addPoints(-123);
    }

    private void gainPassiveIncome() {
        game.getScoreService().addPassiveIncome();
    }
}
