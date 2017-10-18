package ua.nure.zhazhkyi.Practice6.part1;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Part1 {

	private static final String ENCODING = "Cp1251";

	public static void main(String[] args) throws IOException {
		WordContainer container = new WordContainer();
		System.setIn(new ByteArrayInputStream("asd\nasdf\nasd\nasdf\nasdf\n43\nasdsf\n43\n43\n434".getBytes(ENCODING)));
		container.add(new Word("asd"));
		container.add(new Word("asd"));
		container.add(new Word("asdd"));
		container.add(new Word("43"));
		container.add(new Word("43"));
		container.add(new Word("asdd"));
		container.add(new Word("asdf"));
		container.add(new Word("asd"));
		container.add(new Word("43"));
		System.out.println(container.toString());
	}
}
