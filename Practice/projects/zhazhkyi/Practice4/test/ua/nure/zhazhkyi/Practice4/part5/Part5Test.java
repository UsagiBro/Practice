package ua.nure.zhazhkyi.Practice4.part5;

import org.junit.Test;
import ua.nure.zhazhkyi.Practice4.Part5;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Part5Test {

    @Test
    public void test() throws IOException {
        System.setIn(new ByteArrayInputStream("table ru\ntable en\napple ru\napple en".getBytes("Cp1251")));
        Part5.main(new String[]{});
    }

}
