package ua.nure.zhazhkyi.Practice5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Part52 {
	private static final int ITERATION_NUMBER = 3;

	private static final int READERS_NUMBER = 3;

	// shared resource (not thread-safe!!!)
	private static final StringBuilder BUFFER = new StringBuilder();

	private static final int BUFFER_LENGTH = 5;

	// speed parameter
	private static final int PAUSE = 5;

	// stop signal
	private static boolean stop;

	private static Lock lock = new ReentrantLock();
    private static final Condition reading  = lock.newCondition();

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
					Thread.sleep(300);
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
            lock.lock();
            System.out.printf("Reader %s:", threadName);
            for (int j = 0; j < BUFFER_LENGTH; j++) {
            Thread.sleep(PAUSE);
                System.out.print(BUFFER.charAt(j));
            }
            System.out.println();
            Thread.sleep(5);
            reading.await(500, TimeUnit.MILLISECONDS);
			lock.unlock();
	}

	private static void write() throws InterruptedException {
	        lock.lock();
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
			reading.signalAll();
			lock.unlock();
	}

	public static void main(String[] args) throws InterruptedException {
        // create writer
        Part52.Writer writer = new Part52.Writer();

        // create readers
        List<Thread> readers = new ArrayList<>();
        for (int j = 0; j < READERS_NUMBER; j++) {
            readers.add(new Part52.Reader());
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