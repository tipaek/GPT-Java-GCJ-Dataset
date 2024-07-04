import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            String out = insertParens(in.next());
            System.out.println("Case #" + i + ": " + out);
        }
    }

    static String insertParens(String str) {
        int[] counts = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            counts[i] = str.charAt(i) - '0';
        }

        int[] before = new int[str.length()];
        int[] after = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            while (counts[i] > 0) {
                before[i]++;

                int right = i;
                while (right + 1 < str.length() && counts[right + 1] > 0) {
                    counts[right + 1]--;
                    right++;
                }
                after[right]++;

                counts[i]--;
            }
        }

        StringBuilder out = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < before[i]; j++) {
                out.append('(');
            }

            out.append(str.charAt(i));

            for (int j = 0; j < after[i]; j++) {
                out.append(')');
            }
        }

        return out.toString();
    }
}