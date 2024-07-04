import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int nbPatterns = in.nextInt();
            in.nextLine();

            List<String> originalStirngs = new ArrayList<>();

            while (nbPatterns-- > 0) {
                String current = in.nextLine();
                originalStirngs.add(current);
            }

            String result = "*";

            String start = "";
            String end = "";

            for (String currentPattern : originalStirngs) {

                if (currentPattern.startsWith("*")) {
                    String tail = currentPattern.replace("*", "");
                    if (end.length() < tail.length()) {
                        end = tail;
                    }
                } else if (currentPattern.endsWith("*")) {
                    String head = currentPattern.replace("*", "");
                    if (start.length() < head.length()) {
                        start = head;
                    }
                } else {
                    String[] parts = currentPattern.replace("*", "#").split("#");

                    if (end.length() < parts[1].length()) {
                        end = parts[1];
                    }
                    if (start.length() < parts[0].length()) {
                        start = parts[0];
                    }
                }
            }

            String found = start + end;

            boolean allMatches = true;

            for (String pattern : originalStirngs) {
                Pattern pat = Pattern.compile(pattern.replace("*", ".*"));
                Matcher mat = pat.matcher(found);

                if (!mat.matches()) {
                    allMatches = false;
                }
            }

            if (allMatches) {
                result = found;
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }
}