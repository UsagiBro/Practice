package ua.nure.zhazhkyi.Practice1;

/**
 * Created by Igor Zhazhky on 27.06.2017.
 */
public class Part3 {
    public static void main(String[] args) {
        nod(args[0], args[1]);
    }

    public static int nod(String var1, String var2) {
        int a = Integer.parseInt(var1);
        int b = Integer.parseInt(var2);
        int sum;
        while (a != 0 && b != 0) {
            if (a > b) {
                a %= b;
            } else {
                b %= a;
            }
        }
        sum = a + b;
        System.out.println(sum);
        return sum;
    }
}
