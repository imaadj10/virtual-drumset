package persistence;

import model.Instrument;

import static org.junit.jupiter.api.Assertions.assertEquals;

// This test was provided by the CPSC210/JsonSerializationDemo project
public class JsonTest {
    protected void checkInstrument(String name, Instrument instrument) {
        assertEquals(name, instrument.getInstrumentName());
    }
}
