package ua.nure.zhazhkyi.Practice4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
    private static final Path FILE_PATH = Paths.get("part3.txt");
    private static final String ENCODING = "Cp1251";
    private static Pattern pattern;
    private static Matcher matcher;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        while (input != null && !input.equals("stop")) {
            System.out.println(searchData(input));
            input = reader.readLine();
        }
    }

    public static String searchData(String input) {
        String regexp = "(?uim)";
        sb = new StringBuilder();
        try {
            switch (input){
                case "int":
                    regexp = "^(\\d+)(?!\\.)(?=\\s)|(?<=\\s)(?<!\\.)(\\d+)(?!\\.)(?=\\s)|(?<!\\.)(?<=\\s)(\\d+)$";
                    break;
                case "char":
                    regexp = "^([^0-9\\s\\W])(?=\\s)|(?<=\\s)([^0-9\\s\\W])(?=\\s)|(?<=\\s)([^0-9\\s\\W])$";
                    break;
                case "double":
                    regexp = "(\\d+\\.\\d+)|(\\.\\d+)|(\\d+\\.)";
                    break;
                case "String":
                    regexp = "^(\\w{1,}[^\\d\\s\\.])(?=\\s)|(?<=\\s)(\\w{1,}[^\\d\\s\\.])(?=\\s)|(?<=\\s)(\\w{1,}[^\\d\\s\\.])$";
                    break;
            }
            pattern = Pattern.compile(regexp, Pattern.UNICODE_CHARACTER_CLASS);
            matcher = pattern.matcher(readFile(FILE_PATH));
            while (matcher.find()) {
                sb.append(matcher.group(0)).append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    static String readFile(Path filePath) throws IOException {
        StringBuilder builder = new StringBuilder();
        String currentLine;
        BufferedReader fileReader = Files.newBufferedReader(filePath, Charset.forName(ENCODING));
        while ((currentLine = fileReader.readLine()) != null) {
            builder.append(currentLine);
        }
        return builder.toString();
    }
}