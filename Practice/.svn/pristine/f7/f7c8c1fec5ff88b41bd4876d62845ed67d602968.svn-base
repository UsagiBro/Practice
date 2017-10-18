package ua.nure.zhazhkyi.Practice6.part1;

import java.util.Comparator;

public class Word implements Comparable<Word> {

    private String word;

    private int frequency;

    public Word(String word) {
        this.word = word;
        frequency = 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word1 = (Word) o;

        return word != null ? word.equals(word1.word) : word1.word == null;
    }

    @Override
    public int hashCode() {
        return word != null ? word.hashCode() : 0;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public int compareTo(Word w) {
        Word wr = (Word) w;
        if (this.frequency > wr.frequency) {
            return -1;
        } else if (this.frequency < wr.frequency) {
            return 1;
        }
        return (this.word.compareTo(wr.word));
    }

    static Comparator<Word> getNewWordComparator() {
        return new Comparator<Word>() {
            @Override
            public int compare(Word w1, Word w2) {
                return -String.valueOf(w1.word).compareTo(String.valueOf(w2.word));
            }
        };
    }

}
