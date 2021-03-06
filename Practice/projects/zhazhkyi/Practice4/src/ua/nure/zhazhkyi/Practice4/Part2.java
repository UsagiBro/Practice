package ua.nure.zhazhkyi.Practice4;

import java.io.*;
import java.util.Random;

public class Part2 {

    private static final String RAW_DATA = "part2.txt";
    private static final String SORTED_DATA = "part2_sorted.txt";
    private static final String ENCODING = "Cp1251";
    private static final int MAX = 50;
    private static String thisLine = null;

    public static void main(String[] args) {
        createFile(RAW_DATA, ENCODING);
        readFile(SORTED_DATA);
    }

    public static void createFile(String fileName, String encoding) {
        StringBuilder sb = new StringBuilder("input ==> ");
        PrintWriter writer = null;
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = randomize();
        }
        //create file with unsorted ints
        try {
            writer = new PrintWriter(fileName, encoding);
            for (int i = 0; i < array.length; i++) {
                writer.print(array[i] + " ");
                sb.append(array[i]).append(" ");
            }
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
        System.out.println(sb);
    }

    public static int[] readFile(String file) {
        StringBuilder sb = new StringBuilder("output ==> ");
        int[] sortedArray = new int[10];
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(RAW_DATA), "Cp1251"))) {
            while ((thisLine = reader.readLine()) != null) {
                String[] splitted = thisLine.split(" ");
                for (int i = 0; i < splitted.length; i++) {
                    sortedArray[i] = Integer.valueOf(splitted[i]);
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        sort(sortedArray);
        //create file with sorted ints
        try (PrintWriter writer = new PrintWriter(file, "Cp1251")) {
            for (int i = 0; i < sortedArray.length; i++) {
                writer.print(sortedArray[i] + " ");
                sb.append(sortedArray[i]).append(" ");
            }
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(sb);
        return sortedArray;
    }

    static int randomize() {
        Random random = new Random();
        return (random.nextInt(MAX + 1));
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}