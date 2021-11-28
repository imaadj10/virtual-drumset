package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrumsetTest {
    private Drumset testDrumset;

    @BeforeEach
    void runBefore() {
        testDrumset = new Drumset();
    }

    @Test
    void testPlaySoundNoError() {
        assertTrue(testDrumset.playSound("data/test.wav"));
    }

    @Test
    void testPlaySoundError() {
        assertFalse(testDrumset.playSound("data/error.wav"));
        assertFalse(testDrumset.playSound("data/tobs.jpg"));
    }

    @Test
    void testIdentifySoundError() {
        assertEquals(45, testDrumset.identifySound("cowbell").length());
    }

    @Test
    void testIdentifySoundBass() {
        assertEquals(5, testDrumset.identifySound("bass").length());
    }

    @Test
    void testIdentifySoundSnare() {
        assertEquals(7, testDrumset.identifySound("snare").length());
    }

    @Test
    void testIdentifySoundCrash() {
        assertEquals(6, testDrumset.identifySound("crash").length());
    }

    @Test
    void testIdentifySoundRide() {
        assertEquals(5, testDrumset.identifySound("ride").length());
    }

    @Test
    void testIdentifySoundFloor() {
        assertEquals(4, testDrumset.identifySound("floor").length());
    }

    @Test
    void testIdentifySoundHigh() {
        assertEquals(4, testDrumset.identifySound("high").length());
    }

    @Test
    void testIdentifySoundLow() {
        assertEquals(4, testDrumset.identifySound("low").length());
    }

    @Test
    void testIdentifySoundOpen() {
        assertEquals(4, testDrumset.identifySound("open").length());
    }

    @Test
    void testIdentifySoundClosed() {
        assertEquals(4, testDrumset.identifySound("closed").length());
    }

    @Test
    void testPlayBassDrum() {
        assertEquals(0, testDrumset.playBassDrum());
    }

    @Test
    void testPlaySnareDrum() {
        assertEquals(1, testDrumset.playSnareDrum());
    }

    @Test
    void testPlayCrashCymbal() {
        assertEquals(2, testDrumset.playCrashCymbal());
    }

    @Test
    void testPlayRideCymbal() {
        assertEquals(3, testDrumset.playRideCymbal());
    }

    @Test
    void testPlayFloorTom() {
        assertEquals(4, testDrumset.playFloorTom());
    }

    @Test
    void testHighTom() {
        assertEquals(5, testDrumset.playHighTom());
    }

    @Test
    void testPlayLowTom() {
        assertEquals(6, testDrumset.playLowTom());
    }

    @Test
    void testPlayOpenHiHat() {
        assertEquals(7, testDrumset.playOpenHiHat());
    }

    @Test
    void testPlayClosedHiHat() {
        assertEquals(8, testDrumset.playClosedHiHat());
    }

}