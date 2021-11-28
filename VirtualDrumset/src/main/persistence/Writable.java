package persistence;

import org.json.JSONObject;

// This interface was provided by the CPSC210/JsonSerializationDemo project
// Interface that turns an object into a JSON object
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
