package pl.dors.radek.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by rdors on 2016-07-21.
 */
public class BasicDialog extends Image {

    private final static int WIDTH = 380;
    private final static int HEIGHT = 400;

    private GameLabel gameLabel;

    public BasicDialog() {
        super(new Texture("img/dialog.png"));

        this.setOrigin(WIDTH / 2, HEIGHT / 2);
        this.setSize(WIDTH, HEIGHT);

        this.setPosition(60, 200);

        gameLabel = new GameLabel();
        gameLabel.setPosition(100, 400);

        this.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                fadeOutDialog();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    public void initContent(String text) {
        gameLabel.setText(text);
        this.getStage().addActor(gameLabel);
    }

    private void fadeOutDialog() {
        SequenceAction sequence = Actions.sequence();
        sequence.addAction(Actions.fadeOut(1.5f));
        sequence.addAction(new Action() {
            @Override
            public boolean act(float delta) {
                BasicDialog.this.remove();
                gameLabel.remove();
                return false;
            }
        });
        this.addAction(sequence);
        this.gameLabel.addAction(Actions.fadeOut(1.5f));
    }
}
