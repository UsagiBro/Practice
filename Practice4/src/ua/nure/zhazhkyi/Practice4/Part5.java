package ua.nure.zhazhkyi.Practice4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.ResourceBundle;

public class Part5 {

    private static ResourceBundle resourceBundle;
    private static final String BASE_NAME = "resources";

    static String resourceManager(String key, String locale) {
        resourceBundle = ResourceBundle.getBundle(BASE_NAME, new Locale(locale));
        return resourceBundle.getString(key);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String[] inputSeparate;
        while (input != null && !input.equals("stop")) {
            inputSeparate = input.split(" ");
            System.out.println(resourceManager(inputSeparate[0], inputSeparate[1]));
            input = reader.readLine();
        }
    }

}