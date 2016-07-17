package pl.dors.radek.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


/**
 * Created by rdors on 2016-07-18.
 */
public class Player extends Image {

    private final static int WIDTH = 77;
    private final static int HEIGHT = 152;

    private final static int STARTING_X = 200;
    private final static int STARTING_Y = 300;

    public Player() {
        super(new Texture("badlogic.jpg"));
        this.setOrigin(WIDTH / 2, HEIGHT / 2);
        this.setSize(WIDTH, HEIGHT);
        this.setPosition(STARTING_X, STARTING_Y);
    }

    public void reactOnClick() {
        int xMoveAmount = MathUtils.random(-130, 130);
        int yMoveAmount = 10;
        float moveActionTime = 0.3f;
        Action moveAction = Actions.sequence(
                Actions.moveBy(xMoveAmount, yMoveAmount, moveActionTime, Interpolation.circleOut),
                Actions.moveBy(-xMoveAmount, -yMoveAmount, moveActionTime, Interpolation.circle)
        );
        int xGrowAmount = MathUtils.random(-30, 100);
        int yGrowAmount = 20;
        float growActionTime = 0.2f;
        Action growAction = Actions.sequence(
                Actions.sizeBy(xGrowAmount, yGrowAmount, growActionTime, Interpolation.circleOut),
                Actions.sizeBy(-xGrowAmount, -yGrowAmount, growActionTime, Interpolation.circle)
        );
        this.addAction(moveAction);
        this.addAction(growAction);
        if (getHeight() > 170) {
            this.addAction(Actions.rotateBy(MathUtils.randomSign() * 360, 0.4f));
        }
    }
}
