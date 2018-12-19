package com.example.user.mobdevassignment;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class FcmNotifier {
    // Method to send Notifications from server to client end.
    public final static String AUTH_KEY_FCM = "AIzaSyCZBhy1zPtFmY_DCR6Mg0ThGr7Khp4J3PU";
    public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";

    public static void sendNotification(final String body, final String title) throws Exception{

        String authKey = AUTH_KEY_FCM; // You FCM AUTH key
        String FMCurl = API_URL_FCM;

        URL url = new URL(FMCurl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setUseCaches(false);
        conn.setDoInput(true);
        conn.setDoOutput(true);

        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "key=" + authKey);
        conn.setRequestProperty("Content-Type", "application/json");

        JSONObject data = new JSONObject();
        data.put("to", "/topics/topic");
        JSONObject info = new JSONObject();
        info.put("title", "New Request Available"); // Notification title
        info.put("body", body); // Notification body
        data.put("data", info);
        data.put("notification",info);

        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
        wr.write(data.toString());
        wr.flush();
        wr.close();

        int responseCode = conn.getResponseCode();
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

    }

}
