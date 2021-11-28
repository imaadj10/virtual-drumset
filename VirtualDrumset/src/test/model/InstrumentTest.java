package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InstrumentTest {

    private Instrument testInstrument;

    @BeforeEach
    void runBefore() {
        testInstrument = new Instrument("bass");
    }

    @Test
    void testGetInstrumentName() {
        assertEquals(4, testInstrument.getInstrumentName().length());
        assertEquals("bass", testInstrument.getInstrumentName());
    }

}
