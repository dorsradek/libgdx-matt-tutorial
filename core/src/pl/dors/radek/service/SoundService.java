package pl.dors.radek.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

/**
 * Created by rdors on 2016-07-21.
 */
public class SoundService {

    private Sound moneySound;

    public SoundService() {
        init();
    }

    private void init() {
        moneySound = Gdx.audio.newSound(Gdx.files.internal("sound/money1.mp3"));
    }

    public void playMoneySound() {
        moneySound.play();
    }
}
