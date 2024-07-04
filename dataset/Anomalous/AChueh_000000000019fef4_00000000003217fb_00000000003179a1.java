import java.io.*;
import java.util.*;

public class Solution {
    public static int U;

    public static void main(String[] args) {
        boolean DEBUG = false;
        Scanner in = null;
        try {
            in = DEBUG ? new Scanner(new FileInputStream("test.in")) : new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int t = in.nextInt();
        U = in.nextInt();
        for (int i = 1; i <= t; i++) {
            System.out.println("Case #" + i + ": " + solve(in));
        }
    }

    private static String solve(Scanner in) {
        int[] letterCounts = new int[26];

        for (int i = 0; i < 10000; i++) {
            int Q = in.nextInt();
            String input = in.next();
            for (char c : input.toCharArray()) {
                letterCounts[c - 'A']++;
            }
        }

        List<LetterFrequency> frequencies = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (letterCounts[i] > 0) {
                frequencies.add(new LetterFrequency((char) ('A' + i), letterCounts[i]));
            }
        }

        frequencies.sort(new FrequencyComparator());

        StringBuilder result = new StringBuilder();
        result.append(frequencies.get(9).letter);
        frequencies.remove(9);
        for (LetterFrequency lf : frequencies) {
            result.append(lf.letter);
        }

        return result.toString();
    }

    private static class FrequencyComparator implements Comparator<LetterFrequency> {
        @Override
        public int compare(LetterFrequency lf1, LetterFrequency lf2) {
            return Integer.compare(lf2.frequency, lf1.frequency);
        }
    }

    private static class LetterFrequency {
        char letter;
        int frequency;

        LetterFrequency(char letter, int frequency) {
            this.letter = letter;
            this.frequency = frequency;
        }
    }
}