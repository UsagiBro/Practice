package ua.nure.zhazhkyi.Practice4.part3;

import static org.junit.Assert.*;

import org.junit.Test;
import ua.nure.zhazhkyi.Practice4.Part3;

import java.io.*;

public class Part3Test {

	@Test
	public void test() throws IOException {
		System.setIn(new ByteArrayInputStream("char\nString\nint\ndouble".getBytes("Cp1251")));
		Part3.main(new String[]{});
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = reader.readLine();
		while (input != null) {
			testOutcomString(input);
			input = reader.readLine();
		}
	}

	public void testOutcomString(String consoleInput) {
		String checkString = null;
		switch (consoleInput) {
			case "int":
				checkString = Part3.searchData("int");
				assertTrue(checkString.equals("432\r\n5\r\n89\r\n937\r\n9\r\n65\r\n"));
				break;
			case "char":
				checkString = Part3.searchData("char");
				assertTrue(checkString.equals("ÿ\r\nf\r\nè\r\në\r\nw\r\nû\r\nì\r\n"));
				break;
			case "String":
				checkString = Part3.searchData("String");
				assertTrue(checkString.equals("bcd\r\nôâûà\r\nsfg\r\nêå÷ê\r\n"));
				break;
			case "double":
				checkString = Part3.searchData("double");
				assertTrue(checkString.equals("43.43\r\n.98\r\n64.12\r\n.915\r\n"));
				break;
		}
	}
}
