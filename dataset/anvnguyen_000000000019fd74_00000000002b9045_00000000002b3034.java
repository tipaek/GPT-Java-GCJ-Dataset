import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            Integer np = in.nextInt();

            String[] patterns = new String[np];
            for (int p = 0; p < np; p++) {
                patterns[p] = in.next();
            }

            System.out.println("Case #" + i + ": " + find(patterns));
        }
    }

    public static String find(String[] patterns) {
        String finalPattern = "*";

        for (int i = 0; i < patterns.length; i++) {
            String tmpP = patterns[i].replace("*", "(.*)");
            String tmpF = finalPattern.replace("*", "(.*)");

            if (patterns[i].matches(tmpF) || patterns[i].replace("*", "").matches(tmpF)) {
                finalPattern = patterns[i];
                continue;
            }

            if (finalPattern.matches(tmpP) || finalPattern.replace("*", "").matches(tmpP)) {
                continue;
            }

            return "*";
        }

        return finalPattern.replace("*", "");
    }
}