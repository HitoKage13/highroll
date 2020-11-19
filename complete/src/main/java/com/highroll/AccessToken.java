package com.highroll;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.*;

class AccessToken {
    private String token;
    private String user = "62c5c2f381c1486ba1e8a090e8de526f";
    private String password = "Ut0Jkr27cOa6oGDEFUuqi7czbyAEZVwP";
    private String url = "https://us.battle.net/oauth/token";

    public AccessToken() {
        this.token = extractToken();
    }

    public String extractToken() {
        JSONObject t = new JSONObject(generateToken());
        return t.getString("access_token");
    }

    public String getToken() {
        return this.token;
    }

    public String generateToken() {
        String result = "";
        String[] command = {"curl", "-u", user + ":" + password, "-d", "grant_type=client_credentials", url};
        ProcessBuilder process = new ProcessBuilder(command);
        Process p;
        try {
            p = process.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(System.getProperty("line.separator"));
            }
            
            result = builder.toString();
            
        } catch (IOException e) {
            System.out.print("error");
            e.printStackTrace();
        }

        return result;
    }

}