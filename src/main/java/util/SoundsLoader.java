package util;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class SoundsLoader {

    public static final String MAN_SOUND_1 = "/voices/ohman2.wav";
    public static final String MAN_SOUND_2 = "/voices/ohman3.wav";
    public static final String MAN_SOUND_3 = "/voices/ohman4.wav";
    public static final String MAN_SOUND_4 = "/voices/ohman5.wav";

    public static final String WOMAN_SOUND_1 = "/voices/ohwoman1.wav";
    public static final String WOMAN_SOUND_2 = "/voices/ohwoman2.wav";
    public static final String WOMAN_SOUND_3 = "/voices/ohwoman3.wav";
    public static final String WOMAN_SOUND_4 = "/voices/ohwoman4.wav";

    public static final String CHILD_SOUND_1 = "/voices/ohkid1.wav";
    public static final String CHILD_SOUND_2 = "/voices/ohkid2.wav";
    public static final String CHILD_SOUND_3 = "/voices/ohkid3.wav";

    Clip clip;
    URL soundURL[] = new URL[11];

    URL manSounds[] = new URL[4];
    URL womanSounds[] = new URL[4];
    URL kidSounds[] = new URL[4];

    public SoundsLoader() {

        soundURL[0] = getClass().getResource(MAN_SOUND_1);
        soundURL[1] = getClass().getResource(MAN_SOUND_2);
        soundURL[2] = getClass().getResource(MAN_SOUND_3);
        soundURL[3] = getClass().getResource(MAN_SOUND_4);
        soundURL[4] = getClass().getResource(WOMAN_SOUND_1);
        soundURL[5] = getClass().getResource(WOMAN_SOUND_2);
        soundURL[6] = getClass().getResource(WOMAN_SOUND_3);
        soundURL[7] = getClass().getResource(WOMAN_SOUND_4);
        soundURL[8] = getClass().getResource(CHILD_SOUND_1);
        soundURL[9] = getClass().getResource(CHILD_SOUND_2);
        soundURL[10] = getClass().getResource(CHILD_SOUND_3);


        manSounds[0] = soundURL[0];
        manSounds[1] = soundURL[1];
        manSounds[2] = soundURL[2];
        manSounds[3] = soundURL[3];

        womanSounds[0] = soundURL[4];
        womanSounds[1] = soundURL[5];
        womanSounds[2] = soundURL[6];
        womanSounds[3] = soundURL[7];

        kidSounds[0] = soundURL[8];
        kidSounds[1] = soundURL[9];
        kidSounds[2] = soundURL[10];


    }

    public void setFile(int i) {

        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    public void setFileMale(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(manSounds[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
    public void setFileFemale(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(manSounds[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);

        } catch (Exception e) {

            e.printStackTrace();

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
