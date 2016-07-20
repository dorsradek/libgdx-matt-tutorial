package pl.dors.radek.controllers;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Timer;
import pl.dors.radek.MattTutorial;
import pl.dors.radek.entities.FlyingObject;

/**
 * Created by rdors on 2016-07-20.
 */
public class FlyingObjectController {

    private int spawnTime;

    public FlyingObjectController(Stage stage, MattTutorial game) {
        init(stage, game);
    }

    private void init(final Stage stage, final MattTutorial game) {
        randomizeSpawnTime();
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                FlyingObject flyingObject;
                if (MathUtils.randomBoolean()) {
                    flyingObject = new FlyingObject(FlyingObject.FlyingObjectType.MONEY, game);
                } else {
                    flyingObject = new FlyingObject(FlyingObject.FlyingObjectType.PASSIVE, game);
                }
                stage.addActor(flyingObject);
                flyingObject.flyLikeHell();

                randomizeSpawnTime();
            }
        }, spawnTime, spawnTime);
    }

    private void randomizeSpawnTime() {
        spawnTime = MathUtils.random(5, 10);
    }
}
