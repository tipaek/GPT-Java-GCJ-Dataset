

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            solve(i, in);
        }
    }

    private static void solve(int caseNum, Scanner in) {
        int n = in.nextInt();

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));

        for (int i = 0; i < n; i++) {
            pq.add(new int[]{in.nextInt(), in.nextInt()});
        }

        int c = 0;
        int j = 0;
        StringBuilder result = new StringBuilder();
        boolean good = true;
        for (int[] interval: pq) {
            if (c <= interval[0]) {
                c = interval[1];
                result.append('C');
            } else if (j <= interval[0]) {
                j = interval[1];
                result.append('J');
            } else {
                good = false;
                break;
            }
        }

        print(caseNum, good ? result.toString() : "IMPOSSIBLE");
    }

    private static void print(int caseNum, int[] result) {
        StringBuilder sb = new StringBuilder();
        for (int r: result) {
            sb.append(" ");
            sb.append(r);
        }
        print(caseNum, sb);
    }

    private static void print(int caseNum, StringBuilder result) {
        print(caseNum, result.toString());
    }

    private static void print(int caseNum, String result) {
        System.out.println("Case #" + caseNum + ": " + result);
    }
}
