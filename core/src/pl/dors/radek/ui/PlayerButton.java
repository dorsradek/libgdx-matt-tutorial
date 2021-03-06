package pl.dors.radek.ui;

import pl.dors.radek.MattTutorial;

/**
 * Created by rdors on 2016-07-19.
 */
public class PlayerButton extends AbstractButton {

    public PlayerButton(final IClickCallback callback) {
        super(new ButtonStyle());
        init(callback);
    }

    private void init(final IClickCallback callback) {
        this.setWidth(460);
        this.setHeight(360);
        this.setX(10);
        this.setY(170);
        this.setDebug(MattTutorial.DEBUG_MODE);

        initListener(callback);
    }
}
