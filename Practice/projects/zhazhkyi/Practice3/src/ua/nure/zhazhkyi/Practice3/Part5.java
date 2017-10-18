package ua.nure.zhazhkyi.Practice3;

import java.util.NavigableMap;
import java.util.TreeMap;

public class Part5 {
    private static int decimal = 0;
    private static int lastRoman = 0;
    private static NavigableMap<Integer, String> romanValues = new TreeMap<>();

    static {
        romanValues.put(1, "I");
        romanValues.put(4, "IV");
        romanValues.put(5, "V");
        romanValues.put(9, "IX");
        romanValues.put(10, "X");
        romanValues.put(40, "XL");
        romanValues.put(50, "L");
        romanValues.put(90, "XC");
        romanValues.put(100, "C");
    }

    public static void main() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(i + " ====> " + decimal2Roman(i) + " ====> " + roman2Decimal(decimal2Roman(i)));
        }
    }

    static String decimal2Roman(int x) {
        int decimal = romanValues.floorKey(x);
        if (x == decimal) {
            return romanValues.get(x);
        }
        return romanValues.get(decimal) + decimal2Roman(x - decimal);
    }

    static int roman2Decimal(String s) {
        decimal=0;
        String romanNum = s.toUpperCase();
        char convertedNumber;
        for (int i = romanNum.length() - 1; i >= 0; i--) {
            convertedNumber = romanNum.charAt(i);
            switch (convertedNumber) {
                case ('I'):
                    decimal = calculate2Decimal(1, lastRoman, decimal);
                    lastRoman = 1;
                    break;
                case ('V'):
                    decimal = calculate2Decimal(5, lastRoman, decimal);
                    lastRoman = 5;
                    break;
                case ('X'):
                    decimal = calculate2Decimal(10, lastRoman, decimal);
                    lastRoman = 10;
                    break;
                case ('L'):
                    decimal = calculate2Decimal(50, lastRoman, decimal);
                    lastRoman = 50;
                    break;
                case ('C'):
                decimal = calculate2Decimal(100, lastRoman, decimal);
                lastRoman = 100;
                break;
            }
        }
        lastRoman = 0;
        return decimal;
    }

    private static int calculate2Decimal(int decimal, int lastRoman, int previousSum) {
        if (lastRoman > decimal) {
            return previousSum - decimal;
        } else {
            return previousSum + decimal;
        }
    }
}
