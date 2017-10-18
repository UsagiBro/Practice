package ua.nure.zhazhkyi.Practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
    private static final String REGEXP = "(?ium)(\\w+)(\\W*)";
    private static final String REG_FOR_WORDS = "(^\\p{javaLowerCase}{3,})";
    private static Pattern pattern = Pattern.compile(REGEXP, Pattern.UNICODE_CHARACTER_CLASS);
    private static Pattern patternForWords = Pattern.compile(REG_FOR_WORDS, Pattern.UNICODE_CHARACTER_CLASS);
    private static Matcher matcher;
    private static Matcher matcherForWords;

    public static String convert(String input) {
        StringBuilder builder = new StringBuilder();
        matcher = pattern.matcher(input);
        while (matcher.find()){
            matcherForWords = patternForWords.matcher(matcher.group(1));
            if(matcherForWords.find()){
                builder.append(matcher.group(1).replaceFirst("^\\p{javaLowerCase}",
                        Character.toString(Character.toUpperCase(matcher.group(1).charAt(0)))));
                builder.append(matcher.group(2));
            }else {
                builder.append(matcher.group(1));
                builder.append(matcher.group(2));
            }
        }
        return builder.toString();
    }
}
