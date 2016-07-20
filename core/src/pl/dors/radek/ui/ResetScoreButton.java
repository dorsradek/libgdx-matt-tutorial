package pl.dors.radek.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import pl.dors.radek.MattTutorial;

/**
 * Created by rdors on 2016-07-19.
 */
public class ResetScoreButton extends AbstractButton {

    public ResetScoreButton(final IClickCallback callback) {
        super(prepareResetButtonStyle());
        init(callback);
    }

    private void init(final IClickCallback callback) {
        this.setWidth(100);
        this.setHeight(100);
        this.setX(330);
        this.setY(560);
        this.setDebug(MattTutorial.DEBUG_MODE);

        initListener(callback);
    }

    private static Button.ButtonStyle prepareResetButtonStyle() {
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("ui-red.atlas"));
        Skin skin = new Skin(atlas);
        Button.ButtonStyle buttonStyle = new Button.ButtonStyle();
        buttonStyle.up = skin.getDrawable("button_02");
        buttonStyle.down = skin.getDrawable("button_03");
        return buttonStyle;
    }
}
