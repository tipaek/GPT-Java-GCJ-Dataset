import java.io.*;
import java.util.*;

class Pair {
    int start, end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        StringBuilder resultBuilder = new StringBuilder();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            Pair[] intervals = new Pair[n];

            for (int i = 0; i < n; i++) {
                intervals[i] = new Pair(scanner.nextInt(), scanner.nextInt());
            }

            int cameronStart = 0, cameronEnd = 0;
            int jamieStart = 0, jamieEnd = 0;
            boolean possible = true;
            StringBuilder assignment = new StringBuilder();

            for (int i = 0; i < n; i++) {
                if (intervals[i].start >= cameronEnd || intervals[i].end <= cameronStart) {
                    assignment.append("C");
                    cameronEnd = intervals[i].end;
                    cameronStart = intervals[i].start;
                } else if (intervals[i].start >= jamieEnd || intervals[i].end <= jamieStart) {
                    assignment.append("J");
                    jamieEnd = intervals[i].end;
                    jamieStart = intervals[i].start;
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible || assignment.length() != n) {
                resultBuilder.append("Case #").append(t).append(": IMPOSSIBLE");
            } else {
                resultBuilder.append("Case #").append(t).append(": ").append(assignment);
            }

            if (t < testCases) {
                resultBuilder.append("\n");
            }
        }

        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        out.print(resultBuilder);
        out.flush();
        out.close();
    }
}