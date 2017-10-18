package ua.nure.zhazhkyi.Practice5;

public class Part1 extends Thread{

	@Override
	public void run(){
		for (int i = 0; i < 9; i++){
			System.out.println(getName());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		Part1 t1 = new Part1();
		Thread t2 = new Thread(new Part1Runnable());
		t1.start();
		t2.start();
	}

}
