package ua.nure.zhazhkyi.Practice3;

import java.io.IOException;
import java.nio.file.*;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Igor Zhazhky on 18.07.2017.
 */
public class Demo {
    private static final String ENCODING = "Cp1251";
    public static String readFile(String path) {
        String res = null;
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            res = new String(bytes, ENCODING);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return res;
    }
    public static void main(String[] args) {
        String input = readFile("part1.txt");
        String input2 = readFile("part2.txt");
        String input3 = readFile("part3.txt");
        System.out.println(Part1.convert1(input));
        System.out.println(Part1.convert2(input));
        System.out.println(Part1.convert3(input));
        System.out.printf(Part1.convert4(input));
        System.out.println(Part2.convert(input2));
        System.out.println(Part3.convert(input3));
        try {
            System.out.println(Part4.hash("adf", "MD5"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        Part5.main();
    }
}
