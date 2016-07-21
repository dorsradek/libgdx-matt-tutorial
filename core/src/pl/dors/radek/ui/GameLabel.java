package pl.dors.radek.ui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

/**
 * Created by rdors on 2016-07-19.
 */
public class GameLabel extends Label {

    public GameLabel() {
        super("", prepareLabelStyle());
        init();
    }

    private void init() {
        this.setX(70);
        this.setY(650);
    }

    private static LabelStyle prepareLabelStyle() {
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = new BitmapFont();
        return labelStyle;
    }
}
