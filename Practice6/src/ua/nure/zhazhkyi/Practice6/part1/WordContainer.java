package ua.nure.zhazhkyi.Practice6.part1;


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class WordContainer {

    Set<Word> myWords = new HashSet<>();

    public boolean add(Word word) {
        for (Word w : myWords) {
            if (w.equals(word)) {
                w.setFrequency(w.getFrequency() + 1);
                return true;
            }
        }
        return myWords.add(word);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Word[] arr = new Word[myWords.size()];
        arr = myWords.toArray(arr);
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i].getWord()).append(":").append(arr[i].getFrequency()).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public StringBuilder toStringForPart6() {
        StringBuilder sb = new StringBuilder();
        Word[] arr = new Word[myWords.size()];
        arr = myWords.toArray(arr);
        Arrays.sort(arr);
        int countForPrint = arr.length > 3 ? 3 : arr.length;
        Word[] arrForPart6 = new Word[countForPrint];
        for (int i = 0; i < countForPrint; i++) {
            arrForPart6[i] = arr[i];
        }
        Arrays.sort(arrForPart6, Word.getNewWordComparator());
        for (int i = 0; i < arrForPart6.length; i++) {
            sb.append(arrForPart6[i].getWord()).append(" ==> ")
                    .append(arrForPart6[i].getFrequency()).append(System.lineSeparator());
        }
        return sb;
    }

    public int size() {
        int size = 0;
        for (Word word : myWords) {
            size++;
        }
        return size;
    }
}
