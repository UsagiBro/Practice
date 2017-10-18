package ua.nure.zhazhkyi.Practice5;

public class Part1Runnable implements Runnable {

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        String name = t.getName();
        for(int i = 0; i < 9; i++) {
            System.out.println(name);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
