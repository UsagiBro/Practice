package ua.nure.zhazhkyi.Practice6.part7;

import java.util.Iterator;

public class Part7 {
	
	public static void main(String[] args) {
		Range range = new Range(3, 10, false);
		Iterator iterator = range.iterator();
		while (iterator.hasNext()) {
			iterator.next();
		}

	}

}
