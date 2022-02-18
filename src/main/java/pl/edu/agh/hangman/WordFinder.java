package pl.edu.agh.hangman;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WordFinder {

    public static String getRandomWord()  {
        String result = "random";
        try {
            URL url = new URL("https://random-word-api.herokuapp.com/word?number=1");
            HttpURLConnection con = null;
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            result = content.toString().replaceAll("[^a-zA-Z0-9]", "");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
