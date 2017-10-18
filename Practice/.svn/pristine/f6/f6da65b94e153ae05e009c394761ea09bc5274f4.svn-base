package ua.nure.zhazhkyi.Practice3;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Igor Zhazhky on 18.07.2017.
 */
public class Part1 {
    private static final String REGEXP = "(?ium)^(.+);(.+);(.+@.+\\.\\w{2,4})$";
    private static Pattern pattern = Pattern.compile(REGEXP, Pattern.UNICODE_CHARACTER_CLASS);
    private static Matcher matcher;

    public static String convert1(String input) {
        StringBuilder builder = new StringBuilder();
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            builder.append(matcher.group(1)).append("" +
                    " ==> ").append(matcher.group(3)).append(System.lineSeparator());
        }
        return builder.toString();
    }

    public static String convert2(String input) {
        StringBuilder builder = new StringBuilder();
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            builder.append(matcher.group(2)).append("" +
                    " (email: ").append(matcher.group(3)).append(")").append(System.lineSeparator());

        }
        return builder.toString();
    }

    public static String convert3(String input) {
        StringBuilder builder = new StringBuilder();
        Set<String> mails = new LinkedHashSet<>();
        String emailRegexp = "(?ium)(?<=@).+\\.\\w{2,4}";
        Pattern emailPattern = Pattern.compile(emailRegexp, Pattern.UNICODE_CHARACTER_CLASS);
        Matcher emailMatcher = emailPattern.matcher(input);
        matcher = pattern.matcher(input);
        while (emailMatcher.find()) {
            mails.add(emailMatcher.group());
        }
        for (String mail : mails) {
            builder.append(mail).append(" ==> ");
            while (matcher.find()) {
                if (matcher.group().contains(mail)) {
                    builder.append(matcher.group(1)).append(", ");
                }
            }
            builder.setLength(builder.length() - 2);
            builder.append(System.lineSeparator());
            matcher.reset();
        }
        return builder.toString();
    }

    public static String convert4(String input) {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        matcher = pattern.matcher(input);
        builder.append("Login;Name;Email;Password").append(System.lineSeparator());
        while (matcher.find()) {
            builder.append(matcher.group(1))
                    .append(";")
                    .append(matcher.group(2))
                    .append(";")
                    .append(matcher.group(3))
                    .append(";")
                    .append(getRandomPassword());
            if (i < 3) {
                builder.append(System.lineSeparator());
                i++;
            }
        }
        return builder.toString();
    }

    public static String getRandomPassword() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            sb.append(ThreadLocalRandom.current().nextInt(0, 10));
        }
        return sb.toString();
    }
}
