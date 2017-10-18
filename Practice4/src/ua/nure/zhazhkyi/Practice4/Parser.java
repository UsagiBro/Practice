package ua.nure.zhazhkyi.Practice4;

import java.io.*;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser implements Iterable<String> {

    private static final String REGEX = "\\s*(\\p{javaUpperCase}+[\\w\\d\\s,()\":;-]+[.?!])";
    private static Pattern pattern = Pattern.compile(REGEX, Pattern.UNICODE_CHARACTER_CLASS);
    private StringBuilder allText;

    public Parser(String fileName, String encoding) throws FileNotFoundException {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(fileName), encoding))) {
            allText = new StringBuilder();
            String canRead;
            while ((canRead = reader.readLine()) != null) {
                allText.append(canRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new IterImpl();
    }

    private class IterImpl implements Iterator {
        boolean has = false;
        String text = allText.toString();
        StringBuilder builder = new StringBuilder();
        Matcher matcher = pattern.matcher(text);

        @Override
        public boolean hasNext() {
            if (matcher.find()) {
                return has = true;
            } else {
                return false;
            }
        }

        @Override
        public String next() {
            builder.setLength(0);
            builder.append(matcher.group(1));
            has = false;
            return builder.toString();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}