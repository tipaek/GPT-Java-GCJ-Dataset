import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt(); in.nextLine();
            String[] S = new String[N];
            for (int i = 0; i < N; i++) {
                S[i] = new StringBuilder(in.nextLine()).reverse().toString().replace("*", "");
            }
            Arrays.sort(S);
            for (int i = 0; i < N-1; i++) {
                if (!S[N-1].startsWith(S[i])) S[N-1] = "*";
            }
            System.out.printf("Case #%d: %s\n", t, new StringBuilder(S[N-1]).reverse().toString());
        }
        in.close();
    }
}