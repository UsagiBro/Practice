package ua.nure.zhazhkyi.Practice6.part2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Part2 {

    private Integer n;
    List<Integer> circle;
    List<Integer> linkedCircle;

    Part2(Integer value) {
        n = value;
        circle = new ArrayList<>(n);
        linkedCircle = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            circle.add(i);
            linkedCircle.add(i);
        }
    }

    public static void main(String[] args) {
        Part2 part2 = new Part2(10000);
        long start1 = System.currentTimeMillis();
        part2.circleCounting(part2.circle, 9);
        long end = System.currentTimeMillis() - start1;
        System.out.println(end);
        System.out.println(part2.circle.toString());
        long start2 = System.currentTimeMillis();
        part2.circleCounting(part2.linkedCircle, 9);
        long end2 = System.currentTimeMillis() - start2;
        System.out.println(end2);
        System.out.println(part2.linkedCircle.toString());
    }

    public void circleCounting(List<Integer> circle, Integer k) {
        if (k > 0 && k < n) {
            int pointer = k;
            int currentSize = n;
            for (int i = 0; i < n - 1; i++) {
                if (pointer >= currentSize) {
                    while (pointer >= currentSize) {
                        pointer -= currentSize;
                    }
                }
                circle.remove(pointer--);
                currentSize--;
                pointer = pointer + k;
            }
        } else {
            System.out.println("Illegal k value");
            return;
        }
    }
}
