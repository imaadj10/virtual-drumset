package persistence;

import model.Instrument;
import model.Track;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// This class was provided by the CPSC210/JsonSerializationDemo project
// Represents the class that will read saved data from a file
public class JsonReader {
    private final String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads track from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Track read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseTrack(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(contentBuilder::append);
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses track from JSON object and returns it
    private Track parseTrack(JSONObject jsonObject) {
        Track track = new Track();
        addBeats(track, jsonObject);
        return track;
    }

    // MODIFIES: track
    // EFFECTS: parses beats from JSON object and adds them to track
    private void addBeats(Track track, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("track");
        for (Object json : jsonArray) {
            JSONObject nextBeat = (JSONObject) json;
            addBeat(track, nextBeat);
        }
    }

    // MODIFIES: track
    // EFFECTS: parses beat from JSON object and adds it to track
    private void addBeat(Track tr, JSONObject jsonObject) {
        String name = jsonObject.getString("instrument");
        Instrument beat = new Instrument(name);
        tr.addBeat(beat);
    }
}
