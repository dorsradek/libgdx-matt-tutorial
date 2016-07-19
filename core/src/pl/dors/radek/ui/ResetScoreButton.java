package pl.dors.radek.ui;

import pl.dors.radek.MattTutorial;

/**
 * Created by rdors on 2016-07-19.
 */
public class ResetScoreButton extends AbstractButton {

    public ResetScoreButton(final IClickCallback callback) {
        super(new ButtonStyle());
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
}
