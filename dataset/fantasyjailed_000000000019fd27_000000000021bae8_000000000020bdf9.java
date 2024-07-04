import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int testCase = 1; testCase <= t; ++testCase) {
            int n = in.nextInt();

            int[] begArr = new int[n];
            int[] endArr = new int[n];

            for (int i = 0; i < n; i++) {
                begArr[i] = in.nextInt();
                endArr[i] = in.nextInt();
            }

            Arrays.sort(begArr);
            Arrays.sort(endArr);

            boolean isImpossible = false;
            for (int i = 0; i < endArr.length - 2 && !isImpossible; i++) {
                if (endArr[i] > begArr[i + 2]) {
                    isImpossible = true;
                }
                if (begArr[i] == begArr[i + 1] && begArr[i] == begArr[i + 2]
                        || endArr[i] == endArr[i + 1] && endArr[i] == endArr[i + 2]) {
                    isImpossible = true;
                }
            }

            StringBuilder sb = new StringBuilder();
            if (isImpossible) {
                sb.append("IMPOSSIBLE");
            } else {
                sb.append(String.join("", Collections.nCopies(n / 2, "CJ")));
                if (n % 2 == 1) {
                    sb.append("C");
                }
            }

            System.out.println(String.format("Case #%s: %s",
                    testCase, sb.toString()));
        }
    }

}
