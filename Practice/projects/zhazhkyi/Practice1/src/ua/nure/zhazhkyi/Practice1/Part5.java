package ua.nure.zhazhkyi.Practice1;

/**
 * Created by Igor Zhazhky on 27.06.2017.
 */
public class Part5 {
    public static void main(String[] args) {
        String[] input = {"A", "B", "Z", "AA", "AZ", "BA", "ZZ", "AAA"};
        for (String s : input) {
            System.out.println(s + " ==> " + str2int(s) + " ==> " + int2str(str2int(s)));
        }

    }

    public static int str2int(String value) {
        int result = 0;
        for (int i = 0; i < value.length(); i++) {
            result += getNumberFromChar(value.charAt(value.length() - 1 - i)) * (int) Math.pow(26, i);
        }
        return result;
    }

    public static String int2str(int value) {
        StringBuilder result = new StringBuilder();
        while (value != 0) {
            if (value % 26 == 0) {
                result.append(getCharacterFromNumber(26));
                value = (value / 26) - 1;
            } else {
                result.append(getCharacterFromNumber(value % 26));
                value /= 26;
            }
        }
        return result.reverse().toString();
    }

    private static int getNumberFromChar(char ch) {
        return ch - 64;
    }

    private static char getCharacterFromNumber(int number) {
        return (char) (number + 64);
    }


    public static String rightColumn(String number) {
        return int2str(str2int(number) + 1);
    }
}
