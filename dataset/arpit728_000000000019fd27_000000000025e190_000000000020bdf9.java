import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

class Solution {

    private Input reader = new Input();


    public static void main(String args[]) throws Exception {
        Solution sol = new Solution();
        sol.solve();
    }

    void solve() throws Exception {

        int t = reader.readInt();
        for (int caseId = 1; caseId <= t; caseId++) {

            int n = reader.readInt();
            int intervals[][] = reader.readIntMatrix(n, 2);
            Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
            PriorityQueue<Integer> jamie = new PriorityQueue<>((i1, i2) -> Integer.compare(i2, i1));
            PriorityQueue<Integer> cameron = new PriorityQueue<>((i1, i2) -> Integer.compare(i2, i1));
            char result[] = new char[n];
            boolean impossible = false;
            for (int i = 0; i < n; i++) {
                int[] interval = intervals[i];
                if (jamie.isEmpty() || jamie.peek() <= interval[0]) {
                    jamie.offer(interval[1]);
                    result[interval[2]] = 'J';
                } else if (cameron.isEmpty() || cameron.peek() <= interval[0]) {
                    cameron.offer(interval[1]);
                    result[interval[2]] = 'C';
                } else {
                    impossible = true;
                    System.out.printf("Case #%d: IMPOSSIBLE\n", caseId);
                    break;
                }
            }
            if (!impossible) {
                System.out.printf("Case #%d: %s\n", caseId, String.valueOf(result));
            }

        }

    }

    private static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int readInt() throws Exception {
            return parseInt(br.readLine());
        }

        int[][] readIntMatrix(int rows, int cols) throws Exception {
            int a[][] = new int[rows][cols + 1];
            for (int i = 0; i < rows; i++) {
                String[] s = br.readLine().split("\\s");
                a[i][2] = i;
                for (int j = 0; j < cols; j++) {
                    a[i][j] = parseInt(s[j]);
                }
            }
            return a;
        }
    }
}

