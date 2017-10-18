package ua.nure.zhazhkyi.Practice1;

/**
 * Created by Igor Zhazhky on 27.06.2017.
 */
public class Part4 {
    public static void main(String[] args) {
        sumNumbers(args[0]);
    }

    public static int sumNumbers(String var) {
        int a = Integer.parseInt(var);
        int sum = 0;
        if (a > 0) {
            while (a > 0) {
                sum = sum + a % 10;
                a = a / 10;
            }
        } else {
            System.out.println("Incorrect variable");
        }
        System.out.println(sum);
        return sum;
    }
}
