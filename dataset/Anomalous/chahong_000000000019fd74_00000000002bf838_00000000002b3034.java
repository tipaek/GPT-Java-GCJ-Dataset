import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = sc.nextInt();

        for (int i = 0; i < testCases; i++) {
            int numPatterns = sc.nextInt();
            String[] patterns = new String[numPatterns];

            for (int j = 0; j < numPatterns; j++) {
                patterns[j] = sc.next();
            }

            Arrays.sort(patterns, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    return s2.length() - s1.length();
                }
            });

            String finalResult = null;
            OUTER_LOOP:
            for (int k = 1; k < patterns.length; k++) {
                int index1 = 0, index2 = 0;
                boolean foundAsterisk1 = false, foundAsterisk2 = false;
                String suffix1 = null, suffix2 = null;

                while (true) {
                    char char1 = patterns[0].charAt(index1);
                    char char2 = patterns[k].charAt(index2);

                    if (foundAsterisk1 && foundAsterisk2) {
                        suffix1 = patterns[0].substring(index1);
                        suffix2 = patterns[k].substring(index2);

                        if (!suffix1.endsWith(suffix2)) {
                            finalResult = "*";
                            break OUTER_LOOP;
                        } else {
                            break;
                        }
                    }

                    if (char1 == '*') {
                        index1++;
                        foundAsterisk1 = true;
                    }

                    if (char2 == '*') {
                        index2++;
                        foundAsterisk2 = true;
                    }
                }
                finalResult = suffix1;
            }

            System.out.println("Case #" + (i + 1) + ": " + finalResult);
        }
    }
}