package pl.dors.radek.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import pl.dors.radek.MattTutorial;
import pl.dors.radek.controller.FlyingObjectController;
import pl.dors.radek.controller.RandomEventController;
import pl.dors.radek.entities.Player;
import pl.dors.radek.service.PassiveIncomeService;
import pl.dors.radek.ui.*;

/**
 * Created by rdors on 2016-07-17.
 */
public class GameplayScreen extends AbstractScreen {

    private Player player;
    private PlayerButton playerButton;
    private ResetScoreButton resetScoreButton;
    private GameLabel gameLabel;
    private Image gameplayImage;
    private PassiveIncomeService passiveIncomeService;
    private FlyingObjectController flyingObjectController;
    private RandomEventController randomEventController;

    public GameplayScreen(MattTutorial game) {
        super(game);
        init();
    }

    @Override
    protected void init() {
        initBackground();
        initPlayer();
        initPlayerButton();
        initResetScoreButton();
        initScoreLabel();
        initFlyingStuffController();
        startTheMusic();
        initPassiveIncomeService();
        initPassiveIncomeInfoDialog();
        initRandomEventController();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update();

        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }

    @Override
    public void pause() {
        super.pause();
        game.getScoreService().saveCurrentGameState();
    }

    private void update() {
        gameLabel.setText("Score: " + game.getScoreService().getPoints());
        stage.act();
    }

    private void initRandomEventController() {
        randomEventController = new RandomEventController(this.stage, game);
    }

    private void initPassiveIncomeInfoDialog() {
        if (passiveIncomeService.getPointToAdd() > 0) {
            BasicDialog dialog = new BasicDialog();
            dialog.showDialog(stage, "Passive income gained: " + passiveIncomeService.getPointToAdd());
        }
    }

    private void initPassiveIncomeService() {
        passiveIncomeService = new PassiveIncomeService(game.getScoreService());
        passiveIncomeService.start();
    }

    private void startTheMusic() {
        game.getSoundService().startPlayingMusic(true);
    }

    private void initFlyingStuffController() {
        flyingObjectController = new FlyingObjectController(stage, game);
    }

    private void initBackground() {
        gameplayImage = new Image(new Texture("bg.png"));
        stage.addActor(gameplayImage);
    }

    private void initResetScoreButton() {
        resetScoreButton = new ResetScoreButton(new IClickCallback() {
            @Override
            public void onClick() {
                game.getScoreService().resetGameScore();
            }
        });
        stage.addActor(resetScoreButton);
    }


    private void initPlayerButton() {
        playerButton = new PlayerButton(new IClickCallback() {
            @Override
            public void onClick() {
                player.reactOnClick();
                game.getScoreService().addPoint();
                game.getSoundService().playJumpSound();
            }
        });
        stage.addActor(playerButton);
    }

    private void initScoreLabel() {
        gameLabel = new GameLabel();
        stage.addActor(gameLabel);
    }

    private void initPlayer() {
        player = new Player();
        stage.addActor(player);
    }

}
