import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());
        for (int i = 0; i < T; i++) solve(reader, i + 1);
    }

    static void solve(BufferedReader reader, int caseNum) throws Exception {
        int N = Integer.parseInt(reader.readLine());
        System.out.printf("Case #%d:%n", caseNum);
        if (N <= 500) {
            for (int i = 1; i <= N; i++) {
                System.out.printf("%d %d%n", i, 1);
            }
        } else if (N == 501) {
            System.out.println("1 1");
            System.out.println("2 1");
            System.out.println("2 2");
            System.out.println("3 2");
            // int tot = 5;
            for (int i = 5; i < N; i++) {
                System.out.printf("%d %d%n", i - 2, 1);
                // tot++;
            }
            // System.out.println(tot);
        }
    }
}