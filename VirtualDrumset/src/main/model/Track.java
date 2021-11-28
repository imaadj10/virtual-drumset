package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// Represents the track the user creates with the drumset
public class Track implements Writable {

    private static final int MAX_TRACK_LENGTH = 192;

    private List<Instrument> beats;
    private boolean isRecording;

    // EFFECTS: Creates new instance of track and initializes beats as a new ArrayList
    public Track() {
        beats = new ArrayList<>();
        isRecording = false;
    }

    // EFFECTS: Returns the length of the track
    public int trackLength() {
        return beats.size();
    }

    // MODIFIES: this
    // EFFECTS: Adds given beat to beats while trackLength is less than MAX_TRACK_LENGTH
    public String addBeat(Instrument beat) {
        if (trackLength() < MAX_TRACK_LENGTH) {
            beats.add(beat);
            EventLog.getInstance().logEvent(new Event("Added " + beat.getInstrumentName() + " to track."));
            return "";
        } else {
            EventLog.getInstance().logEvent(new Event("Failed to add new instrument to track."));
            return "Your track is full!";
        }
    }

    // EFFECTS: Returns if the track is being recorded or not
    public boolean getRecordingStatus() {
        return isRecording;
    }

    // MODIFIES: this
    // EFFECTS: Clears track of all instruments
    public void clearTrack() {
        beats = new ArrayList<>();
        EventLog.getInstance().logEvent(new Event("Reset track."));
    }

    // MODIFIES: this
    // EFFECTS: Sets isRecording to true
    public void startRecording() {
        isRecording = true;
        EventLog.getInstance().logEvent(new Event("Started recording track."));
    }

    // MODIFIES: this
    // EFFECTS: Sets isRecording to false
    public void stopRecording() {
        isRecording = false;
        EventLog.getInstance().logEvent(new Event("Stopped recording track."));
    }

    // REQUIRES: Index to be within bounds of size of track
    // EFFECTS: Returns the beat at a given index of the track
    public Instrument getBeat(int index) {
        if (index < beats.size()) {
            return beats.get(index);
        } else {
            return new Instrument("Error");
        }
    }

    // EFFECTS: Returns MAX_TRACK_LENGTH
    public int getMaxTrackLength() {
        return MAX_TRACK_LENGTH;
    }

    // EFFECTS: Returns a string representing the track the user created
    public String trackString() {
        StringBuilder myTrackString = new StringBuilder();
        myTrackString.append("This is your track: ");
        for (Instrument beat : beats) {
            myTrackString.append(beat.getInstrumentName());
            myTrackString.append(" ");
        }
        return myTrackString.toString();
    }

    // EFFECTS: Plays the track the user has created
    public boolean playTrack() {
        Drumset trackPlayer = new Drumset();
        for (Instrument beat : beats) {
            trackPlayer.identifySound(beat.getInstrumentName());
            try {
                Thread.sleep(350);
            } catch (InterruptedException e) {
                return false;
            }
        }
        EventLog.getInstance().logEvent(new Event("Played user's track."));
        return true;
    }

    // EFFECTS: Returns track as JSON object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("track", beatsToJson());
        return json;
    }

    // EFFECTS: returns things in this workroom as a JSON array
    private JSONArray beatsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Instrument beat : beats) {
            jsonArray.put(beat.toJson());
        }

        return jsonArray;
    }

}
