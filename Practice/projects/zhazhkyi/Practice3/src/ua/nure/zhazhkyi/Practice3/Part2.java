package ua.nure.zhazhkyi.Practice3;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Igor Zhazhky on 18.07.2017.
 */
public class Part2 {
    private static final String REGEXP = "(?ium)\\w+";
    private static Pattern pattern = Pattern.compile(REGEXP, Pattern.UNICODE_CHARACTER_CLASS);
    private static Matcher matcher;

    public static String convert(String input) {
        StringBuilder builder = new StringBuilder();
        Set<String> mins = new LinkedHashSet<>();
        Set<String> maxs = new LinkedHashSet<>();
        int maxLength = 0;
        int minLength = Integer.MAX_VALUE;
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            if (matcher.group(0).length() < minLength) {
                mins.clear();
                mins.add(matcher.group(0));
                minLength = matcher.group(0).length();
            } else if (matcher.group(0).length() == minLength) {
                mins.add(matcher.group(0));
            } else if (matcher.group(0).length() > maxLength) {
                maxs.clear();
                maxs.add(matcher.group(0));
                maxLength = matcher.group(0).length();
            } else if (matcher.group(0).length() == maxLength) {
                maxs.add(matcher.group(0));
            }
        }
        builder.append("Min: ");
        for (String min : mins) {
            builder.append(min).append(", ");
        }
        builder.setLength(builder.length() - 2);
        builder.append(System.lineSeparator()).append("Max: ");
        for (String max : maxs) {
            builder.append(max).append(", ");
        }
        builder.setLength(builder.length() - 2);
        return builder.toString();
    }
}
