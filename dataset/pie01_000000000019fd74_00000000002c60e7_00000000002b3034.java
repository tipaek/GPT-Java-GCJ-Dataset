import java.util.*;
import java.io.*;

// Qualification Round 2020: Problem A - Vestigium
//
public class Solution {
    public static String solve(int N, String[] words) {
        Arrays.sort(words);
        for (int i = 1; i < N; i++) {
            String prev = words[i - 1].substring(1);
            String cur = words[i].substring(1);
            if (cur.indexOf(prev) < 0) return null;
        }
        return words[N - 1].substring(1);
    }

    public static void main(String[] args) {
        Scanner in =
            new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintStream out = System.out;
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int N = in.nextInt();
            out.format("Case #%d: ", i);
            String[] words = new String[N];
            for (int j = 0; j < N; j++) {
                words[j] = in.next();
            }
            String res = solve(N, words);
            out.println(res == null ? "*" : res);
        }
    }
}
