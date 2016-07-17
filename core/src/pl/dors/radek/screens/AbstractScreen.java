package pl.dors.radek.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import pl.dors.radek.MattTutorial;

/**
 * Created by rdors on 2016-07-17.
 */
public abstract class AbstractScreen implements Screen {

    protected MattTutorial game;
    protected Stage stage;
    protected SpriteBatch spriteBatch;
    private OrthographicCamera camera;

    public AbstractScreen(MattTutorial game) {
        this.game = game;
        createCamera();
        stage = new Stage(new StretchViewport(MattTutorial.WIDTH, MattTutorial.HEIGHT, camera));
        spriteBatch = new SpriteBatch();
    }

    private void createCamera() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, MattTutorial.WIDTH, MattTutorial.HEIGHT);
        camera.update();
    }

    @Override
    public void render(float delta) {
        clearScreen();
        camera.update();
        spriteBatch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void show() {
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void resume() {
        game.setPaused(false);
    }

    @Override
    public void pause() {
        game.setPaused(true);
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        game.dispose();
    }

    @Override
    public void resize(int width, int height) {
    }
}
