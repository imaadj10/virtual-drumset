package ui;

import model.Drumset;
import model.Track;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// The saveTrack() and loadTrack() methods were provided by the CPSC210/JsonSerializationDemo project
// Represents the Virtual Drumset application
public class VirtualDrumsetApp {

    private static final String[] GIVEN_INPUTS = {"bass", "snare", "crash", "ride", "floor",
            "high", "low", "open", "closed"};
    private static final String JSON_STORE = "./data/track.json";

    public final Drumset drumset;
    private Track track;
    public final Set<String> instruments;
    private final JsonWriter jsonWriter;
    private final JsonReader jsonReader;

    // Creates a new instance of VirtualDrumsetApp
    public VirtualDrumsetApp() {
        drumset = new Drumset();
        track = new Track();
        instruments = new HashSet<>(Arrays.asList(GIVEN_INPUTS));
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
    }

    // EFFECTS: returns track
    public Track getTrack() {
        return track;
    }

    // EFFECTS: Sets track to newTrack
    public void setTrack(Track newTrack) {
        track = newTrack;
    }

    // EFFECTS: saves the track to file
    public void saveTrack() {
        try {
            jsonWriter.open();
            jsonWriter.write(track);
            jsonWriter.close();
            System.out.println("Saved track to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads track from file
    public void loadTrack() {
        try {
            track = jsonReader.read();
            System.out.println("Loaded track from" + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

}
