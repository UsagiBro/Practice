package ua.nure.zhazhkyi.Practice4.part2;

import static org.junit.Assert.*;

import org.junit.Test;
import ua.nure.zhazhkyi.Practice4.Part2;

import java.io.*;

public class Part2Test {

    private static final String RAW_DATA = "part2.txt";

    private static final String SORTED_DATA = "part2_sorted.txt";
	@Test
	public void test() {
	    Part2.main(new String[]{});
        Part2.createFile(RAW_DATA, "Cp1251");
        testSortedFile(Part2.readFile(SORTED_DATA));
        Part2.createFile("nonExisting.txt", "notAnEncoding");
	}

	public void testSortedFile(int[] arrayOfData) {
        StringBuilder sb = new StringBuilder();
        String thisLine = null;
        String thisLine2 = null;
        int[] arrayForCheck = new int[10];
        int tempForSort;
	    try {
	        //Read a file with unsorted integers, fill our checkArray and sort it
            BufferedReader readerUnsorted = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("part2.txt"), "Cp1251"));
            while ((thisLine = readerUnsorted.readLine()) != null) {
                String[] splittedValues = thisLine.split(" ");
                for (int i = 0; i < arrayForCheck.length; i++) {
                    arrayForCheck[i] = Integer.valueOf(splittedValues[i]);
                }
            }
            for (int i = 0; i < arrayForCheck.length; i++) {
                for (int j = 1; j < (arrayForCheck.length - i); j++) {
                    if (arrayForCheck[j - 1] > arrayForCheck[j]) {
                        tempForSort = arrayForCheck[j - 1];
                        arrayForCheck[j - 1] = arrayForCheck[j];
                        arrayForCheck[j] = tempForSort;
                    }

                }
            }
            assertArrayEquals(arrayForCheck, arrayOfData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
