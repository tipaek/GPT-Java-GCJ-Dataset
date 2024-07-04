

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCase = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int testCase = 1; testCase <= numberOfTestCase; ++testCase) {
            String next = in.next();
            char[] line = next.toCharArray();
            List<Character> resultList = new ArrayList<>();
            int maxValue = 0;
            for (char c : line) {
                int value = Integer.parseInt(String.valueOf(c));
                if (value != 0) {
                    ArrayList<Character> wrap = wrap(value, c);
                    if (value > maxValue) maxValue = value;
                    resultList.addAll(wrap);
                } else {
                    resultList.add(c);
                }
            }
            StringBuilder result = new StringBuilder();
            resultList.forEach(result::append);
            String export = result.toString();
            for (int i = 0; i < maxValue; i++) {
                export = export.replaceAll("\\)\\(", "");
            }
            System.out.println("Case #" + testCase + ": " + export);
        }
    }
    
    private static ArrayList<Character> wrap(int value, char line) {
        ArrayList<Character> result = new ArrayList<>(value * 2 + 1);
        for (int i = 0; i < value; i++) result.add('(');
        result.add(line);
        for (int i = value + 1; i < value * 2 + 1; i++) result.add(')');
        return result;
    }
}