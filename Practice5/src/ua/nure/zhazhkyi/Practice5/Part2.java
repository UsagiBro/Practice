package ua.nure.zhazhkyi.Practice5;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Part2 {

	public static void main(String[] args) throws InterruptedException {
        // save standard input
        InputStream stdIn = System.in;
        // create input stream with line terminator (=ENTER)
        ByteArrayInputStream bais = new ByteArrayInputStream(System.lineSeparator().getBytes());
        // move internal pointer of input stream to the end of input
        bais.skip(System.lineSeparator().length());
        Spam.main(new String[]{});
        System.setIn(bais);
    }

}
