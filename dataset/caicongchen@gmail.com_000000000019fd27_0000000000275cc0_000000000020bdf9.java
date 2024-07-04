import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();

        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int[] J = new int[24 * 60];
        int[] C = new int[24 * 60];
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            sb.setLength(0);
            J = new int[24 * 60];
            C = new int[24 * 60];

            for (int j = 1; j <= n; ++j) {
                int s = in.nextInt();
                int e = in.nextInt();
                if (j % 2 == 1) {
                    // J
                    if (checkAvailability(s, e, J)) {
                        sb.append("J");
                    } else if (checkAvailability(s, e, C)) {
                        sb.append("C");
                    } else {
                        sb.setLength(0);
                        sb.append("IMPOSSIBLE");
                        continue;
                    }
                } else {
                    // C
                    if (checkAvailability(s, e, C)) {
                        sb.append("C");
                    } else if (checkAvailability(s, e, J)) {
                        sb.append("J");
                    } else {
                        sb.setLength(0);
                        sb.append("IMPOSSIBLE");
                        continue;
                    }
                }
            }
            result.add("Case #" + i + ":" + " " + sb.toString());
        }
        for (String s : result) {
            System.out.println(s);
        }
    }

    static boolean checkAvailability(int s, int e, int[] n) {
        for (int i = s; i < e; i++) {
            if (n[i] == 1) {
                return false;
            }
            n[i] = 1;
        }
        return true;
    }
}