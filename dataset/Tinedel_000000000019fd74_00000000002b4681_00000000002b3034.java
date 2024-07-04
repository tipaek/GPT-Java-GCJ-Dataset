import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            Set<String> aCase = readCase(in);
            String simpleSolve = attemptSimpleSolve(aCase);
            System.out.printf("Case #%d: %s%n", i, simpleSolve);
        }
    }

    private static String attemptSimpleSolve(Set<String> aCase) {
        String minimal = null;
        for(String pattern: aCase) {
            if(minimal == null) {
                minimal = pattern.substring(1);
                continue;
            }
            String candidate = pattern.substring(1);
            if(minimal.endsWith(candidate)) {
                // do nothing
            } else if(candidate.endsWith(minimal)) {
                minimal = candidate;
            } else {
                return "*";
            }
        }
        return minimal;
    }

    private static Set<String> readCase(Scanner in) {
        int numPatterns = in.nextInt();
        Set<String> aCase = new HashSet<>(numPatterns);
        for (int i = 0; i < numPatterns; i++) {
            aCase.add(in.next());
        }
        return aCase;
    }
}