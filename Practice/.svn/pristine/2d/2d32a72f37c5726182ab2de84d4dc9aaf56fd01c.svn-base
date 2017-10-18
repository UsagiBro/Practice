package ua.nure.zhazhkyi.Practice6.part7;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Range implements Iterable {

    private int n;
    private int m;
    private boolean reverse;
    private int[] inner;

    Range(int value1, int value2, boolean rev) {
        if (value1 >= value2) {
            System.out.println("Wrong range");
        } else {
            n = value1;
            m = value2;
            reverse = rev;
            int temp = n;
            inner = new int[m - n + 1];
            for (int i = 0; i < inner.length; i++) {
                inner[i] = temp++;
            }
        }
    }

    @Override
    public Iterator iterator() {
        return new MyIter();
    }

    private class MyIter implements Iterator {
        int cursor1 = -1;
        int cursor2 = inner.length;
        public StringBuilder sb = new StringBuilder();

        @Override
        public boolean hasNext() {
            if (reverse) {
                return (cursor1 < inner.length - 1);
            } else {
                return (cursor2 > 0);
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Object next() {
            if (reverse) {
                if (cursor1 >= inner.length) {
                    throw new NoSuchElementException();
                }
                cursor1++;
                sb.append(inner[cursor1]).append(", ");
                if (inner.length - cursor1 == 1) {
                    sb.deleteCharAt(sb.length() - 2);
                    System.out.println(sb);
                }
                return inner[cursor1];
            } else {
                if (cursor2 <= 0) {
                    throw new NoSuchElementException();
                }
                cursor2--;
                sb.append(inner[cursor2]).append(", ");
                if (cursor2 == 0) {
                    sb.deleteCharAt(sb.length() - 2);
                    System.out.println(sb);
                }
                return inner[cursor2];
            }

        }
    }
}
