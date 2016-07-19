package pl.dors.radek.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import pl.dors.radek.MattTutorial;
import pl.dors.radek.entities.Player;
import pl.dors.radek.ui.IClickCallback;
import pl.dors.radek.ui.PlayerButton;

/**
 * Created by rdors on 2016-07-17.
 */
public class GameplayScreen extends AbstractScreen {

    private Player player;
    private Button playerButton;
    private Button resetScoreButton;
    private Label scoreLabel;

    public GameplayScreen(MattTutorial game) {
        super(game);
        init();
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    protected void init() {
        initPlayer();
        initPlayerButton();
        initResetScoreButton();
        initScoreLabel();
    }

    private void initResetScoreButton() {
        resetScoreButton = new Button(new Button.ButtonStyle());
        resetScoreButton.setWidth(100);
        resetScoreButton.setHeight(100);
        resetScoreButton.setX(330);
        resetScoreButton.setY(560);
        resetScoreButton.setDebug(MattTutorial.DEBUG_MODE);

        stage.addActor(resetScoreButton);

        resetScoreButton.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                game.resetGameScore();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    private void initScoreLabel() {
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = new BitmapFont();
        scoreLabel = new Label("", labelStyle);
        scoreLabel.setX(20);
        scoreLabel.setY(650);

        stage.addActor(scoreLabel);
    }

    private void initPlayerButton() {
        playerButton = new PlayerButton(new IClickCallback() {
            @Override
            public void onClick() {
                player.reactOnClick();
                game.addPoint();
            }
        });

        stage.addActor(playerButton);
    }

    private void initPlayer() {
        player = new Player();
        stage.addActor(player);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update();

        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }

    private void update() {
        scoreLabel.setText("Score: " + game.getPoints());
        stage.act();
    }
}
