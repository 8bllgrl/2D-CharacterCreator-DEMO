package util;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class SoundsLoader {

    public static final String MAN_SOUND_1 = "/voices/ohman2.wav";
    public static final String MAN_SOUND_2 = "/voices/ohman3.wav";
    public static final String MAN_SOUND_3 = "";
    public static final String MAN_SOUND_4 = "";

    public static final String WOMAN_SOUND_1 = "";
    public static final String WOMAN_SOUND_2 = "";
    public static final String WOMAN_SOUND_3 = "";
    public static final String WOMAN_SOUND_4 = "";

    public static final String CHILD_SOUND_1 = "";
    public static final String CHILD_SOUND_2 = "";
    public static final String CHILD_SOUND_3 = "";

    Clip clip;
    URL soundURL[] = new URL[11];

    public SoundsLoader() {

        soundURL[0] = getClass().getResource(MAN_SOUND_1);
        soundURL[1] = getClass().getResource(MAN_SOUND_2);

    }

    public void setFile(int i) {

        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);

        } catch (Exception e) {


        }
    }

    public void play() {
        clip.start();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
    }
}
