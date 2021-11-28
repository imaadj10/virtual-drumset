package model;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.FileInputStream;
import java.io.InputStream;

// Represents a drumset consisting of all instruments in a drumset
public class Drumset {

    private static final String BASS_DRUM_AUDIO = "data/DrumSounds/Bass-Drum-1.wav";
    private static final String SNARE_DRUM_AUDIO = "data/DrumSounds/Snare-Drum-1.wav";
    private static final String CRASH_CYMBAL_AUDIO = "data/DrumSounds/Crash-Cymbal-1.wav";
    private static final String RIDE_CYMBAL_AUDIO = "data/DrumSounds/Ride-Cymbal-1.wav";
    private static final String FLOOR_TOM_AUDIO = "data/DrumSounds/Floor-Tom-1.wav";
    private static final String HIGH_TOM_AUDIO = "data/DrumSounds/Hi-Tom-1.wav";
    private static final String LOW_TOM_AUDIO = "data/DrumSounds/Low-Tom-1.wav";
    private static final String OPEN_HI_HAT_AUDIO = "data/DrumSounds/Open-Hi-Hat-1.wav";
    private static final String CLOSED_HI_HAT_AUDIO = "data/DrumSounds/Closed-Hi-Hat-1.wav";
    private static final int BASS_DRUM_KEY = 0;
    private static final int SNARE_DRUM_KEY = 1;
    private static final int CRASH_CYMBAL_KEY = 2;
    private static final int RIDE_CYMBAL_KEY = 3;
    private static final int FLOOR_TOM_KEY = 4;
    private static final int HIGH_TOM_KEY = 5;
    private static final int LOW_TOM_KEY = 6;
    private static final int OPEN_HI_HAT_KEY = 7;
    private static final int CLOSED_HI_HAT_KEY = 8;

    // EFFECTS: Creates a new instance of Drumset
    public Drumset() {
    }

    // EFFECTS: Plays given audio file
    public boolean playSound(String filePath) {
        InputStream music;
        AudioStream audio;
        try {
            music = new FileInputStream(filePath);
            audio = new AudioStream(music);
            AudioPlayer.player.start(audio);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // REQUIRES: String from given instrument inputs: [bass, snare, crash, ride, floor, high, low, open, closed]
    // EFFECTS: Identifies and plays which instrument sound should be played
    @SuppressWarnings("methodlength")
    public String identifySound(String sound) {
        switch (sound) {
            case ("bass"):
                playBassDrum();
                return "Boom!";
            case ("snare"):
                playSnareDrum();
                return "Ba-Dum!";
            case ("crash"):
                playCrashCymbal();
                return "Crash!";
            case ("ride"):
                playRideCymbal();
                return "Ting!";
            case ("floor"):
                playFloorTom();
                return "Bam!";
            case ("high"):
                playHighTom();
                return "Pop!";
            case ("low"):
                playLowTom();
                return "Bum!";
            case ("open"):
                playOpenHiHat();
                return "Tss!";
            case ("closed"):
                playClosedHiHat();
                return "Tch!";
        }
        return "We don't have this instrument in our drumset!";
    }

    // EFFECTS: Plays bass drum sound and returns number representing bass drum
    public int playBassDrum() {
        playSound(BASS_DRUM_AUDIO);
        return BASS_DRUM_KEY;
    }

    // EFFECTS: Plays snare drum sound and returns number representing snare drum
    public int playSnareDrum() {
        playSound(SNARE_DRUM_AUDIO);
        return SNARE_DRUM_KEY;
    }

    // EFFECTS: Plays crash cymbal sound and returns number representing crash cymbal
    public int playCrashCymbal() {
        playSound(CRASH_CYMBAL_AUDIO);
        return CRASH_CYMBAL_KEY;
    }

    // EFFECTS: Plays ride cymbal sound and returns number representing ride cymbal
    public int playRideCymbal() {
        playSound(RIDE_CYMBAL_AUDIO);
        return RIDE_CYMBAL_KEY;
    }

    // EFFECTS: Plays floor tom sound and returns number representing floor tom
    public int playFloorTom() {
        playSound(FLOOR_TOM_AUDIO);
        return FLOOR_TOM_KEY;
    }

    // EFFECTS: Plays high tom sound and returns number representing high tom
    public int playHighTom() {
        playSound(HIGH_TOM_AUDIO);
        return HIGH_TOM_KEY;
    }

    // EFFECTS: Plays low tom sound and returns number representing low tom
    public int playLowTom() {
        playSound(LOW_TOM_AUDIO);
        return LOW_TOM_KEY;
    }

    // EFFECTS: Plays open hi-hat sound and returns number representing open hi-hat
    public int playOpenHiHat() {
        playSound(OPEN_HI_HAT_AUDIO);
        return OPEN_HI_HAT_KEY;
    }

    // EFFECTS: Plays closed hi-hat sound and returns number representing closed hi-hat
    public int playClosedHiHat() {
        playSound(CLOSED_HI_HAT_AUDIO);
        return CLOSED_HI_HAT_KEY;
    }

}
