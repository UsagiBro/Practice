package ua.nure.zhazhkyi.Practice1;

/**
 * Created by Igor Zhazhky on 27.06.2017.
 */
public class Part2 {
    public static void main(String args[]) {
        sum(args[0], args[1]);
    }

    public static int sum(String var1, String var2) {
        int sum = Integer.parseInt(var1) + Integer.parseInt(var2);
        System.out.println(sum);
        return sum;
    }
}
