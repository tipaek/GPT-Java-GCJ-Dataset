import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][4];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                intervals[i][2] = i;
            }

            Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

            int endC = -1;
            int endJ = -1;
            boolean isImpossible = false;
            StringBuilder result = new StringBuilder();

            for (int[] interval : intervals) {
                if (interval[0] >= endJ) {
                    endJ = interval[1];
                    interval[3] = 0; // Assign to J
                } else if (interval[0] >= endC) {
                    endC = interval[1];
                    interval[3] = 1; // Assign to C
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + (testCase + 1) + ": IMPOSSIBLE");
            } else {
                Arrays.sort(intervals, Comparator.comparingInt(o -> o[2]));
                for (int[] interval : intervals) {
                    result.append(interval[3] == 0 ? "J" : "C");
                }
                System.out.println("Case #" + (testCase + 1) + ": " + result);
            }
        }
        scanner.close();
    }

    public static class FastReader {
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