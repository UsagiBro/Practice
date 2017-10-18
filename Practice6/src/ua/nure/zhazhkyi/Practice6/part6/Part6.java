package ua.nure.zhazhkyi.Practice6.part6;

import ua.nure.zhazhkyi.Practice6.part1.Word;
import ua.nure.zhazhkyi.Practice6.part1.WordContainer;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {
    private static final String REGEXP = "(?ium)\\s*\\W*(\\w+)\\W*\\s*";
    private static final Pattern pattern = Pattern.compile(REGEXP);
    private static Matcher matcher;
    private static String wrongModeString = "Inserted wrong mode!";
    private static List<String> container;

    enum Mode {
        FREQUENCY, LENGTH, DUPLICATES;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern pat = Pattern.compile("(--input|-i)\\s+(\\w+.\\w+)\\s+(--task|-t)\\s+(\\w+)");
        Matcher mat = pat.matcher(sc.nextLine());
        if (mat.find()) {
            System.out.println(analysis(mat.group(2), mat.group(4)));
        } else {
            System.out.println("Invalid request!");
        }
//        -i input1.txt -t frequency --input input1.txt --task length
//        --input input3.txt --task duplicates
    }

    static StringBuilder readFile(String filename) {
        StringBuilder sb = new StringBuilder();
        String input = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(filename), "Cp1251"));
            while ((input = reader.readLine()) != null) {
                sb.append(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }

    static String analysis(String filename, String modeString) {
        Mode mode = Mode.valueOf(modeString.toUpperCase());
        matcher = pattern.matcher(readFile(filename));
        if (mode.equals(Mode.FREQUENCY)) {
            WordContainer container = new WordContainer();
            while (matcher.find()) {
                container.add(new Word(matcher.group(1)));
            }
            StringBuilder sb = container.toStringForPart6();
            return sb.toString();
        } else if (mode.equals(Mode.LENGTH)) {
            List<String> container = new ArrayList<>();
            while (matcher.find()) {
                if (!container.contains(matcher.group(1))) {
                    container.add(matcher.group(1));
                }
            }
            return lengthAnalysis(container);

        } else if (mode.equals(Mode.DUPLICATES)) {
            container = new ArrayList<>();
            while (matcher.find()) {
                container.add(matcher.group(1));
            }
            return duplicatesAnalysis(container);
        }
        return wrongModeString;
    }

    private static String lengthAnalysis(List<String> container) {
        Collections.sort(container, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() != s2.length()) {
                    return s2.length() - s1.length();
                }
                return -s1.compareTo(s2);
            }
        });
        StringBuilder sb = new StringBuilder();
        int countForPrint = container.size() > 3 ? 3 : container.size();
        String[] sortedArr = new String[countForPrint];
        for (int i = 0; i < countForPrint; i++) {
            sortedArr[i] = container.get(i);
        }
        for (String s : sortedArr) {
            sb.append(s).append(" ==> ").append(s.length()).append(System.lineSeparator());
        }
        return sb.toString();
    }

    private static String duplicatesAnalysis(List<String> allWords) {
        StringBuilder sb = new StringBuilder();
        int countForPrint = allWords.size() > 3 ? 3 : allWords.size();
        List<String> temp = new ArrayList<>(countForPrint);
        for (String s : allWords) {
            if (Collections.frequency(allWords, s) > 1 && !temp.contains(s)) {
                temp.add(s);
            }
        }
        for (String s : temp) {
            sb.append(s.toUpperCase()).reverse().append(System.lineSeparator());
        }
        return sb.toString();
    }

}
