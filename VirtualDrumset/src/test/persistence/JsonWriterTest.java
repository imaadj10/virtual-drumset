package persistence;

import model.Instrument;
import model.Track;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

// These tests were provided by the CPSC210/JsonSerializationDemo project
class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            Track track = new Track();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyTrack.json");
            writer.open();
            writer.write(track);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyTrack.json");
            track = reader.read();
            assertEquals(0, track.trackLength());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            Track track = new Track();
            track.addBeat(new Instrument("bass"));
            track.addBeat(new Instrument("snare"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralTrack.json");
            writer.open();
            writer.write(track);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralTrack.json");
            track = reader.read();
            assertEquals(2, track.trackLength());
            checkInstrument("bass", track.getBeat(0));
            checkInstrument("snare", track.getBeat(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}