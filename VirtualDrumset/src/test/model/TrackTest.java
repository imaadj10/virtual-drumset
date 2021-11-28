package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrackTest {
    private Track testTrack;

    @BeforeEach
    void runBefore() {
        testTrack = new Track();
    }

    @Test
    void testAddBeatNotMaxLength() {
        testTrack.addBeat(new Instrument("bass"));
        testTrack.addBeat(new Instrument("snare"));
        testTrack.addBeat(new Instrument("crash"));
        testTrack.addBeat(new Instrument("crash"));

        assertEquals(4, testTrack.trackLength());
    }

    @Test
    void testAddBeatMaxLength() {
        for (int t = 0; t < testTrack.getMaxTrackLength(); t++) {
            testTrack.addBeat(new Instrument("closed"));
        }
        assertEquals("Your track is full!", testTrack.addBeat(new Instrument("low")));
    }

    @Test
    void testTrackLengthZeroLength() {
        assertEquals(0, testTrack.trackLength());
    }

    @Test
    void testGetBeatNonEmpty() {
        testTrack.addBeat(new Instrument("snare"));
        testTrack.addBeat(new Instrument("crash"));
        testTrack.addBeat(new Instrument("crash"));

        assertEquals("snare", testTrack.getBeat(0).getInstrumentName());
        assertEquals("crash", testTrack.getBeat(1).getInstrumentName());
        assertEquals("crash", testTrack.getBeat(2).getInstrumentName());
        assertEquals("Error", testTrack.getBeat(3).getInstrumentName());
    }

    @Test
    void testGetBeatEmpty() {
        assertEquals("Error", testTrack.getBeat(0).getInstrumentName());
    }

    @Test
    void testGetRecordingStatus() {
        assertFalse(testTrack.getRecordingStatus());
    }

    @Test
    void testStartRecording() {
        testTrack.startRecording();

        assertTrue(testTrack.getRecordingStatus());
    }

    @Test
    void testStopRecording() {
        testTrack.startRecording();
        testTrack.stopRecording();

        assertFalse(testTrack.getRecordingStatus());
    }

    @Test
    void testClearTrack() {
        testTrack.addBeat(new Instrument("snare"));
        testTrack.addBeat(new Instrument("crash"));
        testTrack.addBeat(new Instrument("crash"));
        testTrack.clearTrack();

        assertEquals(0, testTrack.trackLength());
    }

    @Test
    void testTrackStringNonEmpty() {
        testTrack.addBeat(new Instrument("ride"));
        testTrack.addBeat(new Instrument("floor"));
        testTrack.addBeat(new Instrument("low"));

        assertEquals(35, testTrack.trackString().length());
    }

    @Test
    void testTrackStringEmpty() {
        assertEquals(20, testTrack.trackString().length());
    }

    @Test
    void testPlayTrackEmpty() {
         assertTrue(testTrack.playTrack());
    }

    @Test
    void testPlayTrackNonEmpty() {
        testTrack.addBeat(new Instrument("bass"));
        assertTrue(testTrack.playTrack());
    }

    @Test
    void testPlayTrackError() {
        testTrack.addBeat(new Instrument("bass"));
        testTrack.addBeat(new Instrument("bass"));
        testTrack.addBeat(new Instrument("open"));
        testTrack.addBeat(new Instrument("snare"));
        testTrack.addBeat(new Instrument("ride"));
        Thread.currentThread().interrupt();
        boolean testResult = testTrack.playTrack();
        assertFalse(testResult);
    }

    @Test
    void testGetMaxTrackLength() {
        assertEquals(192, testTrack.getMaxTrackLength());
    }

}
