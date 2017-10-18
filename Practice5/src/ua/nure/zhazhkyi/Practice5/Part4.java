package ua.nure.zhazhkyi.Practice5;

public class Part4 {
    private static final int M = 4;
    private static final int N = 100;
    private static int[][] matrix = new int[M][N];

    public static void main(String[] args) throws InterruptedException {
        matrixFill(matrix);
        Thread t1 = new MyThread(0);
        Thread t2 = new MyThread(1);
        Thread t3 = new MyThread(2);
        Thread t4 = new MyThread(3);
        long startTime = System.currentTimeMillis();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("Threads: " + endTime + " ms");

        long startTime1 = System.currentTimeMillis();
        findMax();
        long endTime1 = System.currentTimeMillis() - startTime1;
        System.out.println("Non threads: " + endTime1 + " ms");

    }

    private static int[][] matrixFill(int[][] matrix) {
        int a = 0;
        int b = 100;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = a + (int) (Math.random() * b);
            }
        }
        return matrix;
    }

    private static int findMax() throws InterruptedException {
        int maxRes = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (maxRes < matrix[i][j]) {
                    maxRes = matrix[i][j];
                }
                Thread.sleep(1);
            }
        }
        return maxRes;
    }

    static class MyThread extends Thread {
        int row = 0;
        private static int res = 0;

        MyThread(int row) {
            this.row = row;
        }

        @Override
        public void run() {
            try {
                findMax(matrix);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public int findMax(int[][] matrix) throws InterruptedException {
            int maxValue = 0;
            for (int j = 0; j < matrix[row].length; j++) {
                if (matrix[row][j] > maxValue) {
                    maxValue = matrix[row][j];
                }
                Thread.sleep(1);
            }
            if (maxValue > res) {
                res = maxValue;
            }
            return maxValue;
        }
    }
}
