package pl.dors.radek.screens;

import com.badlogic.gdx.Gdx;
import pl.dors.radek.MattTutorial;
import pl.dors.radek.entities.Player;
import pl.dors.radek.ui.IClickCallback;
import pl.dors.radek.ui.PlayerButton;
import pl.dors.radek.ui.ResetScoreButton;
import pl.dors.radek.ui.ScoreLabel;

/**
 * Created by rdors on 2016-07-17.
 */
public class GameplayScreen extends AbstractScreen {

    private Player player;
    private PlayerButton playerButton;
    private ResetScoreButton resetScoreButton;
    private ScoreLabel scoreLabel;

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
        resetScoreButton = new ResetScoreButton(new IClickCallback() {
            @Override
            public void onClick() {
                game.resetGameScore();
            }
        });
        stage.addActor(resetScoreButton);
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

    private void initScoreLabel() {
        scoreLabel = new ScoreLabel();
        stage.addActor(scoreLabel);
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
