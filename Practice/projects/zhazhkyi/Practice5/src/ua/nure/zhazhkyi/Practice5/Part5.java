package ua.nure.zhazhkyi.Practice5;

public class Part5 {

	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
		System.out.println("============Part51");
		Part51.main(args);

		System.out.println("============Part52");
		Part52.main(args);

		System.out.println("============Part53");
		Part53.main(args);
		long end = System.currentTimeMillis() - start;
		System.out.println(end);
	}

}
