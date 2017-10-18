package ua.nure.zhazhkyi.Practice5;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class Part6 extends Thread {

    private static final Object MONITOR = new Object();
    private static final int THREADS_NUMBER = 10;
    private static final int COLUMNS = 20;
    private static final int EOL_LENGTH = System.lineSeparator().length();
    private static String fileName = "test.txt";

    private static RandomAccessFile out;

    private int rowNum;

    Part6(int value) {
        rowNum = value;
    }

    @Override
    public void run() {
        try {
            write(fileName);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void write(String fileName) throws IOException, InterruptedException {
        synchronized (MONITOR) {
            out = new RandomAccessFile(fileName, "rw");
            long beginIndexOfLine = (COLUMNS + 1) * rowNum;
            out.seek(beginIndexOfLine);
            for (int i = 0; i < COLUMNS; i++) {
                out.writeBytes(Integer.toString(rowNum));
            }
            out.writeBytes(System.lineSeparator());
            MONITOR.wait(150);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREADS_NUMBER; i++) {
            threads.add(new Part6(i));
        }
        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        RandomAccessFile file = new RandomAccessFile(fileName, "r");
        try {
            String line;
            while ((line = file.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println();
        } finally {
            file.close();
        }

    }

}