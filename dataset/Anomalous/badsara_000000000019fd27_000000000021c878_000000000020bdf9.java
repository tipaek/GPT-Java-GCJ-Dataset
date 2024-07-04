import java.io.*;
import java.util.*;

class Pair {
    int start, end, index;

    public Pair(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder result = new StringBuilder();
        
        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            Pair[] pairs = new Pair[n];
            for (int i = 0; i < n; i++) {
                pairs[i] = new Pair(sc.nextInt(), sc.nextInt(), i);
            }

            // Sort pairs by the end time
            Arrays.sort(pairs, Comparator.comparingInt(p -> p.end));

            int cameronEnd = 0, jamieEnd = 0;
            char[] assignments = new char[n];
            boolean possible = true;

            for (Pair pair : pairs) {
                if (pair.start >= cameronEnd) {
                    assignments[pair.index] = 'C';
                    cameronEnd = pair.end;
                } else if (pair.start >= jamieEnd) {
                    assignments[pair.index] = 'J';
                    jamieEnd = pair.end;
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                result.append("Case #").append(t).append(": ");
                for (char c : assignments) {
                    result.append(c);
                }
                result.append("\n");
            } else {
                result.append("Case #").append(t).append(": IMPOSSIBLE\n");
            }
        }

        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        out.print(result);
        out.close();
    }
}