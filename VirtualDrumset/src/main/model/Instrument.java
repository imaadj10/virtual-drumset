package model;

import org.json.JSONObject;
import persistence.Writable;

// Represents an instrument that is a part of the drumset
public class Instrument implements Writable {

    private final String instrumentName;

    // REQUIRES: Instrument name comes from given inputs: [bass, snare, crash, ride, floor, high, low, open, closed]
    // EFFECTS: Creates new instance of Instrument and gives it the name instrumentName
    public Instrument(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    // EFFECTS: Returns the name of a given instrument
    public String getInstrumentName() {
        return instrumentName;
    }

    // EFFECTS: Returns instrument as JSON object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("instrument", instrumentName);
        return json;
    }

}
