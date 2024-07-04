import java.awt.*;
import java.io.*;
import java.util.*;

public class Solution {
    static Point[] points;

    public static void main(String[] args) throws Exception {
        FastReader scanner = new FastReader();
        int testCases = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            StringBuilder caseResult = new StringBuilder();
            caseResult.append("Case #").append(testCase).append(": ");
            int n = scanner.nextInt();
            points = new Point[n];

            for (int i = 0; i < n; i++) {
                points[i] = new Point(scanner.nextInt(), scanner.nextInt());
            }

            char[] assignments = new char[n];
            Arrays.fill(assignments, '0');

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    if (intersects(points[i], points[j])) {
                        if (assignments[i] == '0' && assignments[j] == '0') {
                            assignments[i] = 'C';
                            assignments[j] = 'J';
                        } else if (assignments[i] == '0') {
                            assignments[i] = (assignments[j] == 'C') ? 'J' : 'C';
                        } else if (assignments[j] == '0') {
                            assignments[j] = (assignments[i] == 'C') ? 'J' : 'C';
                        }
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                if (assignments[i] == '0') assignments[i] = 'C';
            }

            if (isValidAssignment(assignments)) {
                caseResult.append(String.valueOf(assignments));
            } else {
                caseResult.append("IMPOSSIBLE");
            }

            caseResult.append("\n");
            result.append(caseResult);
        }

        System.out.print(result);
    }

    static boolean intersects(Point p1, Point p2) {
        return (p1.x > p2.x && p1.x < p2.y) || (p1.y > p2.x && p1.y < p2.y);
    }

    static boolean isValidAssignment(char[] assignments) {
        for (int i = 0; i < assignments.length; i++) {
            if (assignments[i] == 'C') {
                for (int j = 0; j < assignments.length; j++) {
                    if (i == j) continue;
                    if (assignments[j] == 'C' && intersects(points[i], points[j])) {
                        return false;
                    }
                }
            }
        }
        for (int i = 0; i < assignments.length; i++) {
            if (assignments[i] == 'J') {
                for (int j = 0; j < assignments.length; j++) {
                    if (i == j) continue;
                    if (assignments[j] == 'J' && intersects(points[i], points[j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}