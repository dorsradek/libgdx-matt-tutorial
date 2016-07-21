package pl.dors.radek.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

/**
 * Created by rdors on 2016-07-21.
 */
public class SoundService {

    private Sound moneySound;
    private Sound bookSound;
    private Sound jumpSound;
    private Sound pickSound;

    private Music music;

    public SoundService() {
        init();
    }

    private void init() {
        moneySound = Gdx.audio.newSound(Gdx.files.internal("sound/money1.mp3"));
        bookSound = Gdx.audio.newSound(Gdx.files.internal("sound/book.wav"));
        jumpSound = Gdx.audio.newSound(Gdx.files.internal("sound/jump.wav"));
        pickSound = Gdx.audio.newSound(Gdx.files.internal("sound/pick.mp3"));
        music = Gdx.audio.newMusic(Gdx.files.internal("sound/music.mp3"));
    }

    public void playMoneySound() {
        moneySound.play();
    }
    public void playBookSound() {
        bookSound.play();
    }
    public void playJumpSound() {
        jumpSound.play();
    }
    public void playPickSound() {
        pickSound.play();
    }

    public void startPlayingMusic(boolean looped) {
        music.setVolume(0.15F);
        music.play();
        music.setLooping(looped);
    }
}
