import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= tests; t++) {
            int n = in.nextInt();
            int[] schedule = new int[1441];
            StringBuilder output = new StringBuilder("");
            for (int i = 0; i < n; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                if (schedule[start] == 0) {
                    output.append("C");
                    for (int j = start; j < end; j++) schedule[j] += 1;
                } else if (schedule[start] == 1) {
                    output.append("J");
                    for (int j = start; j < end; j++) schedule[j] += 2;
                } else if (schedule[start] == 2) {
                    output.append("C");
                    for (int j = start; j < end; j++) schedule[j] += 1;
                } else if (schedule[start] >= 3) {
                    output = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            String finalSchedule = output.toString();
            System.out.println("Case #" + t + ": " + finalSchedule);
        }
    }
}