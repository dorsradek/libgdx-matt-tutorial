package pl.dors.radek.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by rdors on 2016-07-19.
 */
public abstract class AbstractButton extends Button {

    public AbstractButton(ButtonStyle style) {
        super(style);
    }

    public void initListener(final IClickCallback callback) {
        this.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                callback.onClick();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }
}
