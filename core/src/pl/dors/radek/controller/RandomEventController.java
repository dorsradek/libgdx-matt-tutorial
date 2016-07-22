package pl.dors.radek.controller;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Timer;

/**
 * Created by rdors on 2016-07-22.
 */
public class RandomEventController {

    //TODO: change afeter initial impl
    private static final int RANDOM_TICK_INTERVAL = 5;

    public RandomEventController() {
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
        System.out.println("triggerRandomEvent");
    }
}
