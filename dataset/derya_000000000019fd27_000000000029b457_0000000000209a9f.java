import java.util.*;
import java.io.*;

public class Solution {
    private static PrintStream o = System.out;

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int T = Integer.parseInt(in.nextLine());

        for (int testCaseIdx = 0; testCaseIdx < T; ++testCaseIdx) {
            final char[] S = in.nextLine().toCharArray();

            StringBuilder SPRIME = new StringBuilder();

            int hanging = 0;
            for (char digitChar : S) {
                int digit = Integer.parseInt(String.valueOf(digitChar));

                if (digit > hanging) {
                    int numToIncrease = digit - hanging;

                    for (int i = 0; i < numToIncrease; i++) {
                        SPRIME.append('(');
                    }

                    SPRIME.append(digitChar);

                    hanging = digit;
                } else if (digit < hanging) {
                    int numToDecrease = hanging - digit;

                    for (int i = 0; i < numToDecrease; i++) {
                        SPRIME.append(')');
                    }

                    SPRIME.append(digitChar);

                    hanging = digit;
                } else {
                    SPRIME.append(digitChar);
                }
            }

            for (int i = 0; i < hanging; i++) {
                SPRIME.append(')');
            }

            o.printf("Case #%d: ", testCaseIdx + 1);
            o.printf("%s", SPRIME.toString());
            o.printf("%n");
        }
    }
}
