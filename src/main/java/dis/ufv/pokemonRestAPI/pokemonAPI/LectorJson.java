package dis.ufv.pokemonRestAPI.pokemonAPI;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LectorJson {

    // Method to read JSON from a default file ("pokemonConId.json")
    public ArrayList<Pokemon> leeFicheroJson() {
        return leeFicheroJson("pokemonConId.json");
    }

    // Overloaded method to read JSON from a specified file
    public ArrayList<Pokemon> leeFicheroJson(String fichero) {
        ArrayList<Pokemon> listaPokemon = new ArrayList<>();
        try {
            // Load the file as a resource stream
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fichero);

            // Check if the file was found
            if (inputStream == null) {
                throw new IllegalArgumentException("File not found: " + fichero);
            }

            // Proceed with creating a BufferedReader from the InputStream
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            listaPokemon = new Gson().fromJson(reader, new TypeToken<ArrayList<Pokemon>>() {}.getType());
            reader.close(); // Close the reader after reading
        } catch (Exception ex) {
            ex.printStackTrace(); // Print stack trace for debugging
        }
        return listaPokemon; // Return the list (empty if an exception occurred)
    }
}
