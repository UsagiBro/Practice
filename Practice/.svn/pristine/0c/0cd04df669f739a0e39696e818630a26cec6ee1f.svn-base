package ua.nure.zhazhkyi.Practice4;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    private static final String FILE_NAME = "part1.txt";
    private static final String ENCODING = "Cp1251";
    private static final String REXEXP = "(?mui)(\\W*)(\\w+)(\\W*)";
    private static Pattern pattern = Pattern.compile(REXEXP, Pattern.UNICODE_CHARACTER_CLASS);
    private static Matcher matcher;

    public static void main(String[] args) {
        System.out.println(convert());
    }

    public static String convert() {
        String input = read(FILE_NAME);
        StringBuilder sb = new StringBuilder();
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            if (matcher.group(2).length() > 3) {
                sb.append(matcher.group(1)).append(matcher.group(2).toUpperCase()).append(matcher.group(3));
            } else {
                sb.append(matcher.group(1)).append(matcher.group(2)).append(matcher.group(3));
            }
        }
        return sb.toString();
    }

    public static String read(String fileName) {
        String res = null;
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(fileName));
            res = new String(bytes, ENCODING);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return res;
    }
}