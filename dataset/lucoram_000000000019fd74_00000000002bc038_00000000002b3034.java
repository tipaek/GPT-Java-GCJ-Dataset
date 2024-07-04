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

            for (String currentPattern : originalStirngs) {
                String newString = currentPattern.replace("*", "A");
                String newStringEmp = currentPattern.replace("*", "");
                boolean allMatchesA = true;
                boolean allMatchesB = true;

                for (String pattern : originalStirngs) {
                    Pattern pat = Pattern.compile(pattern.replace("*", ".*"));
                    Matcher matA = pat.matcher(newString);
                    Matcher matB = pat.matcher(newStringEmp);

                    if (!matA.matches()) {
                        allMatchesA = false;
                    }

                    if (!matB.matches()) {
                        allMatchesB = false;
                    }
                }

                if (allMatchesA) {
                    result = newString;
                    break;
                }
                if(allMatchesB) {
                    result = newStringEmp;
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }
}