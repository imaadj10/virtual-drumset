package persistence;

import model.Track;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

// These tests were provided by the CPSC210/JsonSerializationDemo project
class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyTrack.json");
        try {
            Track track = reader.read();
            assertEquals(0, track.trackLength());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralTrack.json");
        try {
            Track track = reader.read();
            assertEquals(2, track.trackLength());
            checkInstrument("bass", track.getBeat(0));
            checkInstrument("snare", track.getBeat(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}