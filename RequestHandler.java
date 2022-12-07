import com.google.gson.*;

import java.lang.reflect.Array;
import java.util.List;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

// Request Handler
// Handles our HTTP request and creation of
// our array of objects from the data recieved from that request.
public class RequestHandler {

    // Get List From Json
    // Accepts a string of Json data and returns the list it represents
    private listItem[] getListFromJson(String jsonData) {
        Gson gson = new Gson();
        listItem[] l = gson.fromJson(jsonData, listItem[].class);

        return l;
    }

    // Request Json Data
    // Creates an HTTP request to the API
    // returns the response body or throws an error.
    /**
     * @return
     */
    private String requestJsonData() {
        URL url = null;
        try {
            url = new URL("https://fetch-hiring.s3.amazonaws.com/hiring.json");
        } catch (MalformedURLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            connection.setRequestMethod("GET");
        } catch (ProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String responseBody = null;
        try (InputStream response = connection.getInputStream()) {
            Scanner scanner = new Scanner(response);
            responseBody = scanner.useDelimiter("//A").next();
            System.out.println(responseBody);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return responseBody;
    }

    // Get List
    // Calls the methods to request the JSON data
    // and create the array of listItems from the recieved data
    // returns the array of listItems
    public listItem[] getList() {
        String jsonData = requestJsonData();
        listItem[] l = getListFromJson(jsonData);
        
        return l;
    }
}