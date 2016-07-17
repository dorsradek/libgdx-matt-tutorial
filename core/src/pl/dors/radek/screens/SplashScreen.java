package pl.dors.radek.screens;

import com.badlogic.gdx.graphics.Texture;
import pl.dors.radek.MattTutorial;

/**
 * Created by rdors on 2016-07-17.
 */
public class SplashScreen extends AbstractScreen {

    private Texture splashImage;

    public SplashScreen(MattTutorial game) {
        super(game);
        init();
    }

    private void init() {
        // TODO: implement better assets loading when game grows
        splashImage = new Texture("badlogic.jpg");
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        spriteBatch.begin();
        spriteBatch.draw(splashImage, 0, 0);
        spriteBatch.end();
    }
}
