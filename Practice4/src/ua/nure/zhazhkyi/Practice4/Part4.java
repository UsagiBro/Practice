package ua.nure.zhazhkyi.Practice4;

import java.io.FileNotFoundException;

public class Part4 {

	private static final String FILE_NAME = "part4.txt";

	private static final String ENCODING = "Cp1251";

	public static void main(String[] args) throws FileNotFoundException {
		returnParser();
	}

	public static String returnParser() throws FileNotFoundException {
		Parser parser = new Parser(FILE_NAME, ENCODING);
		StringBuilder sb = new StringBuilder();
		for (String str : parser) {
			System.out.println(str);
			sb.append(str).append(System.lineSeparator());
		}
		return sb.toString();
	}
}