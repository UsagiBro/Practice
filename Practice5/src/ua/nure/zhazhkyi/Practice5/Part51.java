package ua.nure.zhazhkyi.Practice5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Note!!! Without synchronization this application not work properly!! Most
 * likely a runtime exception will be thrown..
 */
public class Part51 {

    private static final int ITERATION_NUMBER = 3;

    private static final int READERS_NUMBER = 3;

    // shared resource (not thread-safe!!!)
    private static final StringBuilder BUFFER = new StringBuilder();

    private static final int BUFFER_LENGTH = 5;

    // speed parameter
    private static final int PAUSE = 5;

    // stop signal
    private static boolean stop;

    // reader
    private static class Reader extends Thread {
        public void run() {
            while (!stop) {
                try {
                    // read from the buffer
                    read(getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // writer
    private static class Writer extends Thread {
        public void run() {
            int tact = 0;
            while (!stop) {
                try {
                    // write to the buffer
                    write();
                    Thread.sleep(310);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (++tact == ITERATION_NUMBER) {
                        stop = true;
                    }
                }
            }
        }
    }

    private static void read(String threadName) throws InterruptedException {
        synchronized (BUFFER) {
            System.out.printf("Reader %s:", threadName);
            for (int j = 0; j < BUFFER_LENGTH; j++) {
                Thread.sleep(PAUSE);
                System.out.print(BUFFER.charAt(j));
            }
            System.out.println();
            Thread.sleep(5);
            BUFFER.wait(500);
        }
    }

    private static void write() throws InterruptedException {
        synchronized (BUFFER) {
            // clear buffer
            BUFFER.setLength(0);

            // write to buffer
            System.err.print("Writer writes:");

            Random random = new Random();
            for (int j = 0; j < BUFFER_LENGTH; j++) {
                Thread.sleep(PAUSE);
                char ch = (char) ('A' + random.nextInt(26));
                System.err.print(ch);
                BUFFER.append(ch);
            }
            System.err.println();
            Thread.sleep(5);
            BUFFER.notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // create writer
        Writer writer = new Writer();

        // create readers
        List<Thread> readers = new ArrayList<>();
        for (int j = 0; j < READERS_NUMBER; j++) {
            readers.add(new Reader());
        }
        // start writer
        Thread.sleep(10);
        writer.start();

        // start readers
        Thread.sleep(10);
        for (Thread reader : readers) {
            reader.start();
        }

        // main thread is waiting for the child threads
        writer.join();

        for (Thread reader : readers) {
            reader.join();
        }
    }

}