package pl.dors.radek.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import pl.dors.radek.MattTutorial;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = MattTutorial.WIDTH;
		config.height = MattTutorial.HEIGHT;
		new LwjglApplication(new MattTutorial(), config);
	}
}
