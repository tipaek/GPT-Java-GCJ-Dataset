import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int N = scanner.nextInt();
            int[][] segments = new int[N][3];
            for (int i = 0; i < N; i++) {
                segments[i][0] = scanner.nextInt();
                segments[i][1] = scanner.nextInt();
                segments[i][2] = i;
            }

            String result = solve(N, segments);
            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    private static String solve(int N, int[][] segments) {
        Arrays.sort(segments, Comparator.comparingInt(a -> a[0]));
        char[] assignedChars = new char[N];
        int endC = 0;
        int endJ = 0;

        for (int[] segment : segments) {
            int start = segment[0];
            int end = segment[1];
            int index = segment[2];
            if (start >= endC) {
                assignedChars[index] = 'C';
                endC = end;
            } else if (start >= endJ) {
                assignedChars[index] = 'J';
                endJ = end;
            } else {
                return IMPOSSIBLE;
            }
        }

        return new String(assignedChars);
    }
}