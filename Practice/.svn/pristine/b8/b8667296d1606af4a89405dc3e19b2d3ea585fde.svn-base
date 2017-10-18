package ua.nure.zhazhkyi.Practice4.part4;


import org.junit.Test;
import ua.nure.zhazhkyi.Practice4.Part4;
import ua.nure.zhazhkyi.Practice4.Parser;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

public class Part4Test {

	@Test
	public void test() throws FileNotFoundException {
		Part4.main(new String[]{});
		assertTrue(Part4.returnParser().equals(testParser()));
		Parser parser = new Parser("NonExistingFile.txt", "Cp1251");
		Parser parser2 = new Parser("part4.txt", "Cp1251");
		try {
			parser2.iterator().remove();
		}catch (UnsupportedOperationException e) {
			e.printStackTrace();
		}
	}

	private String testParser() throws FileNotFoundException {
		String regularEx = "\\s*(\\p{javaUpperCase}+[\\w\\d\\s,()\":;-]+[.?!])";
		StringBuilder allText = new StringBuilder();
		Pattern pattern = Pattern.compile(regularEx, Pattern.UNICODE_CHARACTER_CLASS);
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					new FileInputStream("part4.txt"), "Cp1251"));
			String canRead;
			while ((canRead = reader.readLine()) != null) {
				allText.append(canRead);
			}
			Matcher matcher = pattern.matcher(allText.toString());
			allText.delete(0, allText.length());
			while (matcher.find()) {
				allText.append(matcher.group(1)).append(System.lineSeparator());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return allText.toString();
	}
}
