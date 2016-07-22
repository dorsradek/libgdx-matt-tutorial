package pl.dors.radek.controller;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Timer;
import pl.dors.radek.MattTutorial;
import pl.dors.radek.ui.BasicDialog;

/**
 * Created by rdors on 2016-07-22.
 */
public class RandomEventController {

    //TODO: change afeter initial impl
    private static final int RANDOM_TICK_INTERVAL = 5;

    private MattTutorial game;
    private Stage stage;

    public RandomEventController(Stage stage, MattTutorial game) {
        this.stage = stage;
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
        triggerDialog("Free money");
    }

    private void loseMoneyEvent() {
        game.getScoreService().addPoints(-123);
        triggerDialog("Pay taxes");
    }

    private void gainPassiveIncome() {
        game.getScoreService().addPassiveIncome();
        triggerDialog("You gained passive income! Yaay!");
    }

    private void triggerDialog(String text) {
        BasicDialog dialog = new BasicDialog();
        dialog.showDialog(stage, text);
    }
}
