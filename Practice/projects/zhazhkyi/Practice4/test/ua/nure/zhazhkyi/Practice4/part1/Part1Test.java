package ua.nure.zhazhkyi.Practice4.part1;

import static org.junit.Assert.*;

import org.junit.Test;
import ua.nure.zhazhkyi.Practice4.Part1;

import java.util.regex.Pattern;

public class Part1Test {

    @Test
    public void test() {
        Part1.main(new String[]{});
        testConvert(Part1.convert());
        Part1.read("nonExisting");

    }

    public void testConvert(String input) {
        String[] inputArr = input.split("[\\s,().]");
        String regex = "(\\p{javaUpperCase}{3,})";
        Pattern pattern = Pattern.compile(regex, Pattern.UNICODE_CHARACTER_CLASS);
        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i].length() > 3) {
                assertTrue(pattern.matcher(inputArr[i]).find());
            }
        }
    }

}
